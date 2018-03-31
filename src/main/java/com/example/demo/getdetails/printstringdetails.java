package com.example.demo.getdetails;

import java.util.List;

import com.javasampleapproach.jqueryajax.message.ResponseString;

public class printstringdetails {
	
	public  void printstring(List<String> s)
	{
		if(s!=null)
		{
		for (String string : s) {
			if(string!=null)
			{
				 //System.setOut(ps);
			System.out.println(string);
			}
		}}
	}

}
