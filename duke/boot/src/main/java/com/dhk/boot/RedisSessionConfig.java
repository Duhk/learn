package com.dhk.boot;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.session.events.SessionCreatedEvent;
import org.springframework.session.events.SessionDeletedEvent;
import org.springframework.session.events.SessionExpiredEvent;

@Configuration
@EnableRedisHttpSession(maxInactiveIntervalInSeconds= 600,redisNamespace = "bootDemo")
public class RedisSessionConfig {
	/**
	 * Redis内session过期事件监听
	 * @param expiredEvent
	 */
	@EventListener
	public void onSessionExpired(SessionExpiredEvent expiredEvent) {
		String sessionId = expiredEvent.getSessionId();
		System.out.println("过期；sessionId="+sessionId);
	}
	/**
	 * Redis内session销毁监听
	 * @param expiredEvent
	 */
	@EventListener
	public void onSessionDeleted(SessionDeletedEvent deletedEvent) {
		String sessionId = deletedEvent.getSessionId();
		System.out.println("删除；sessionId="+sessionId);
	}
	/**
	 * Redis内session创建监听
	 * @param expiredEvent
	 */	
	@EventListener
	public void onSessionCreated(SessionCreatedEvent createdEvent) {
		String sessionId = createdEvent.getSessionId();
		System.out.println("创建；sessionId="+sessionId);
	}
}