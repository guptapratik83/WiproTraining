package com.test;

public class JUnitTesting {


public int square(int a) {
	 return a*a;
	}
	 
	 
	public int countA(String s) {//Maria - 2,output
	 int count=0;
	 for(int i=0;i<s.length();i++) {
	  if(s.charAt(i)=='a' || s.charAt(i)=='A'){
	   count=count+1;
	  }  
	 }
	 return count;
	 
	}
	 
	 
	public boolean ageCheck(int age) {
	 if(age<20)
	  return true;
	 else
	  return false;
	}
	 
	 
	public String nullCheck(String s) {
	 if((s.equals("")) && (s!=null))
	  return "";
	 else  
	  return s;
	}
}