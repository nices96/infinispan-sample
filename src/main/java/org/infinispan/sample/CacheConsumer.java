package org.infinispan.sample;

import java.util.concurrent.TimeUnit;

import org.infinispan.Cache;
import org.infinispan.manager.DefaultCacheManager;

public class CacheConsumer {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		Cache<Object, Object> cache = new DefaultCacheManager("cache2/infinispan-config.xml").getCache("myCache");
		
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