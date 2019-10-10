package com.theprofilingproject;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Sample program which purposefully makes an logical blunder and hence gives a
 * good scenario to profile the application and learn from it.
 * 
 * @author sridhar
 *
 */

@SuppressWarnings({ "StatementWithEmptyBody", "WeakerAccess", "unused",
    "ResultOfMethodCallIgnored" })
public class BuggyCache {

  public static class ObjectInCache {
    private final String key;

    public ObjectInCache(final String key) {
      this.key = key;
    }

    public String getKey() {
      return key;
    }
  }

  private static Map<String, ObjectInCache> cache = Collections.synchronizedMap(new HashMap<>());

  /*
   * Here we are purposefully putting the entire object as a key in the map,
   * instead of just putting the key by calling getKey()
   * 
   */
  public static void computeForKey(final String key) {
    if (!cache.containsKey(key)) {
      final ObjectInCache loadedObject = complexObjectFinder(key);
      cache.put(loadedObject.toString(), loadedObject);
    } else {
      // Cheap computation here...
      System.out.println("Key available in cache");
    }
  }

  private static ObjectInCache complexObjectFinder(final String key) {
    try {
      Thread.sleep(10);
      return new ObjectInCache(key);
    } catch (final InterruptedException e) {
      throw new RuntimeException();
    }
  }

  public static void main(final String[] args) throws IOException {

    System.out.println("Press Enter to start...");
    System.in.read();

    System.out.println("Starting...");
    final long startTime = System.currentTimeMillis();
    for (int i = 0; i < 500; i++) {
      computeForKey("the-same-key");
    }
    System.out.println("Done! Time = " + (System.currentTimeMillis() - startTime));
  }
}