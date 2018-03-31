package com.example.demo.getdetails;

import java.util.List;

import com.example.jsonformat.*;
import com.javasampleapproach.jqueryajax.message.ResponseString;

public class getexampledetails{
	public ResponseString getexample(Example_ ex)
	{
	 ResponseString res=new ResponseString();
		List<String> register=ex.getRegisters();
		printstringdetails p=new printstringdetails();
		p.printstring(register);
		res.setRegister(register);
	//	 System.setOut(ps);
		System.out.println(ex.getText());
		return res;
	}

}
