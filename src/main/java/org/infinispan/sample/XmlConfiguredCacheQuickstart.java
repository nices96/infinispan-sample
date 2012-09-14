package org.infinispan.sample;

import org.infinispan.Cache;
import org.infinispan.manager.DefaultCacheManager;

public class XmlConfiguredCacheQuickstart {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		Cache<Object, Object> cache = new DefaultCacheManager("cache/infinispan-config.xml").getCache("myCache");
		
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