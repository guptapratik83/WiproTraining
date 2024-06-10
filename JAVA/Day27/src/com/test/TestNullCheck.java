package com.test;




import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
 
class TestNullCheck {
 
 @Test
 
 void test() {
 
  JUnitTesting test=new JUnitTesting();
 
  String nullString=null;
 
  String notNullString="Maria";
 
  assertNull(nullString);
 
  //assertNotNull(notNullString);
 
 }
 
}