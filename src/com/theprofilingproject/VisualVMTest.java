package com.theprofilingproject;

import java.util.ArrayList;
import java.util.List;

public class VisualVMTest {

  static List<VisualVMTest> visualVMTestList = new ArrayList<VisualVMTest>();

  public static void main(String[] args) {

//    HeapDumper.dumpHeap("HeapDump0_1.hprof", true);
    for (int i = 0; i <= 10000; i++) {
      visualVMTestList.add(new VisualVMTest());
    }
    HeapDumper.dumpHeap("HeapDump0_0.hprof", true);

  }
}
