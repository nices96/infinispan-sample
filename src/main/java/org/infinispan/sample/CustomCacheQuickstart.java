package org.infinispan.sample;

import java.util.concurrent.TimeUnit;

import org.infinispan.Cache;
import org.infinispan.configuration.cache.ConfigurationBuilder;
import org.infinispan.eviction.EvictionStrategy;
import org.infinispan.manager.DefaultCacheManager;
import org.infinispan.manager.EmbeddedCacheManager;

public class CustomCacheQuickstart {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		EmbeddedCacheManager manager = new DefaultCacheManager();

		manager.defineConfiguration("custom-cache", new ConfigurationBuilder()
				.eviction().strategy(EvictionStrategy.LIRS).maxEntries(10)
				.build());
		Cache<Object, Object> cache = manager.getCache("custom-cache");

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
		
		// Validate the entry is now in the cache
		System.out.println("cache.size() => " + cache.size());
		System.out.println("cache.containsKey(\"key\") => " + cache.containsKey("key"));
		System.out.println("cache.containsKey(\"key1\") => " + cache.containsKey("key1"));
		System.out.println("cache.containsKey(\"key2\") => " + cache.containsKey("key2"));
		System.out.println("cache.containsKey(\"key3\") => " + cache.containsKey("key3"));
		System.out.println("cache.containsKey(\"key4\") => " + cache.containsKey("key4"));
		System.out.println("cache.containsKey(\"key5\") => " + cache.containsKey("key5"));
		System.out.println("cache.containsKey(\"key6\") => " + cache.containsKey("key6"));
		System.out.println("cache.containsKey(\"key7\") => " + cache.containsKey("key7"));
		System.out.println("cache.containsKey(\"key8\") => " + cache.containsKey("key8"));
		System.out.println("cache.containsKey(\"key9\") => " + cache.containsKey("key9"));
		
		// Remove the entry from the cache
		Object v = cache.remove("key");
		
		// Validate the entry is no longer in the cache
		System.out.println("v => " + v);

		// Add an entry with the key "key"
		cache.put("key", "value");
		
		// And replace it if missing
		cache.putIfAbsent("key", "newValue");
		
		// Validate that the new value was not added
		System.out.println("cache.get(\"key\") => " + cache.get("key"));

		// By default entries are immortal but we can override this on a per-key
		// basis and provide lifespans.
		cache.put("key", "value", 5, TimeUnit.SECONDS);
		System.out.println("cache.containsKey(\"key\") => " + cache.containsKey("key"));
		
		Thread.sleep(10000);
		
		System.out.println("cache.containsKey(\"key\") => " + cache.containsKey("key"));
	}
}