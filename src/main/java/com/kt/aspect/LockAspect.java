package com.kt.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.stereotype.Component;

import com.kt.common.CustomException;
import com.kt.common.ErrorCode;
import com.kt.common.Lock;

import lombok.RequiredArgsConstructor;

@Aspect
@Component
@RequiredArgsConstructor
public class LockAspect {
	private final AopTransactionManager aopTransactionManager;
	private final RedissonClient redissonClient;

	@Around("@annotation(com.kt.common.Lock) && @annotation(lock)")
	public Object lock(ProceedingJoinPoint joinPoint, Lock lock) throws Throwable {
		Object[] arguments = joinPoint.getArgs();
		var identity = (Long)arguments[lock.index()];
		String key = String.format(
			"%s:%d",
			lock.key().name().toLowerCase(),
			identity
		);

		RLock rLock = redissonClient.getLock(key);

		try {

			boolean available = rLock.tryLock(
				lock.waitTime(),
				lock.leaseTime(),
				lock.timeUnit()
			);

			if (!available) {
				throw new CustomException(ErrorCode.FAIL_ACQUIRED_LOCK);
			}
			return aopTransactionManager.proceed(joinPoint);
		} finally {
			if (rLock.isHeldByCurrentThread()) {
				rLock.unlock();
			}
		}
	}
}
