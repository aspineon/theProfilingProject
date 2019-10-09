package com.theprofilingproject;

import java.util.HashMap;
import java.util.Map;

public class JVMOutOfMemorySimulator {

  private static final String SOME_STRING = "datadatadatadatadatadatadatadatadatadatadatadatad"
      + "atadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadata"
      + "datadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadata"
      + "datadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatad"
      + "atadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadat"
      + "adatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadata";

  private static Map<String, String> mapToStoreData = new HashMap<>();
  
  private void appendData() {
    for(int i=0 ; i<500000; i++) {
      String data = SOME_STRING + i;
      mapToStoreData.put(SOME_STRING, SOME_STRING);
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
