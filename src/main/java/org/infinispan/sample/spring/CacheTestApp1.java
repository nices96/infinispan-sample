package org.infinispan.sample.spring;

import org.infinispan.Cache;
import org.infinispan.manager.EmbeddedCacheManager;
import org.infinispan.spring.provider.SpringEmbeddedCacheManager;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CacheTestApp1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/context-cache.xml");
		
		EmbeddedCacheManager cacheManager = ((SpringEmbeddedCacheManager)context.getBean("cacheManager")).getNativeCacheManager();
		Cache<Object, Object> cache = cacheManager.getCache("myCache");
		
		// Add a entry
		cache.put("key", "value");
		cache.put("key1", "value1");
		cache.put("key2", "value2");
		cache.put("key3", "value3");
		cache.put("key4", "value4");
		cache.put("key5", "value5");
		cache.put("key6", "value6");
		cache.put("key7", "value7");
		cache.put("key8", "value8");
		cache.put("key9", "value9");
	}
}