package oop;

public class Overload {
	
	public void displayInt(int param) {
		System.out.println("정수값 = " +param);
	}
	
	public void displayBoolean(boolean param) {
		System.out.println("논리값 = " +param);
	}
	
	public void displayString(String param) {
		System.out.println("문자열 = " +param);
	}
	
//=====================================================================================
//매개변수가 다를 경우 메서드 명이 같아도 다른 메서드로 취급함
//	따라서, 같은 기능을 하는데 매개변수만 다르게 사용할 경우 메서드 명을 같게 선언함. -> main 메서드에서 사용시 더 편리하게 사용할 수 있음.
//	접근제한자와 반환형은 오버로드 선언과 무관함. ( 오버로드란? ﻿기존에 없는 새로운 메서드 정의)
	
	public void display(int param) {
		System.out.println("정수값 = " +param);
	}
	public void display(boolean param){
		System.out.println("논리값 = " +param);
	}
	public void display(String param){
		System.out.println("문자열 = " +param);
	}
}
