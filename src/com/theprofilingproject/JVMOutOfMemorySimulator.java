package com.theprofilingproject;

import java.util.HashMap;
import java.util.Map;

/**
 * Main purpose of this program is to generate an OutOfMemoryError and produce
 * an heapdump which can be analyzed later
 * 
 * For more information, refer the workflows doc in this project folder
 * 
 */

public class JVMOutOfMemorySimulator {

  private static final String SOME_STRING = "datadatadatadatadatadatadatadatadatadatadatadatad"
      + "atadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadata"
      + "datadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadata"
      + "datadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatad"
      + "atadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadat"
      + "adatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadata";

  private static Map<String, String> mapToStoreData = new HashMap<>();

  private void appendData() {
    for (int i = 0; i < 50000000; i++) {
      String data = SOME_STRING + i;
      mapToStoreData.put(data, data);
      /*
       * if(i==499999) HeapDumper.dumpHeap("NoStringAdd2.hprof", false);
       */
    }

  }

  public static void main(String[] args) {
    new JVMOutOfMemorySimulator().appendData();
    System.out.println("finished");
  }

}
