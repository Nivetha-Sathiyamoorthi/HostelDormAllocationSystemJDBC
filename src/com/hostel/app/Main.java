package com.hostel.app;

import java.util.Scanner;

import com.hostel.service.HostelService;

public class Main {
	private static HostelService hostelService; 
	public static void main(String[] args) { 
	hostelService = new HostelService(); 
	Scanner sc = new Scanner(System.in); 
	System.out.println("--- Hostel Allocation Console ---"); 
	try { 
	boolean r = 
	hostelService.allocateStudent("R001","ST1234","Vinay Kumar"); 
	System.out.println(r ? "ALLOCATED" : "FAILED"); 
	} catch(Exception e){ System.out.println(e);}  
	try { 
	boolean r = hostelService.vacateStudent(7001); 
	System.out.println(r ? "VACATED" : "FAILED"); 
	} catch(Exception e){ System.out.println(e);}  
	sc.close(); 
	}

}
