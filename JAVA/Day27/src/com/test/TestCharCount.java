package com.test;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
 
class TestCharCount {
 
 @Test
 
 void test() {
 
  JUnitTesting test=new JUnitTesting();
 
  int output=test.countA("Janani");
 
 assertEquals(2, output);
 
 }
 
}


