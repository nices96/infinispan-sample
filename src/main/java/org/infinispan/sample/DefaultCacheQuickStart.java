package org.infinispan.sample;

import java.util.concurrent.TimeUnit;

import org.infinispan.Cache;
import org.infinispan.manager.DefaultCacheManager;

public class DefaultCacheQuickStart {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		Cache<Object, Object> cache = new DefaultCacheManager().getCache();

		// Add a entry
		cache.put("key", "value");
		cache.put("key1", "value");
		cache.put("key2", "value");
		cache.put("key3", "value");
		cache.put("key4", "value");
		cache.put("key5", "value");
		cache.put("key6", "value");
		cache.put("key7", "value");
		cache.put("key8", "value");
		cache.put("key9", "value");
		
		// Validate the entry is now in the cache
		System.out.println("cache.size() => " + cache.size());
		System.out.println("cache.containsKey(\"key\") => " + cache.containsKey("key"));
		
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