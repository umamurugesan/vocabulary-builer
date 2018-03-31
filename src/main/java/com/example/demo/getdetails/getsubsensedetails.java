package com.example.demo.getdetails;

import java.util.List;


import com.example.jsonformat.*;
import com.javasampleapproach.jqueryajax.message.ResponseString;
public class getsubsensedetails  {
	public ResponseString getsubsense(Subsense se)
	{
		ResponseString res=new ResponseString();
		// System.setOut(ps);
		System.out.println("definitions");
		List<String> def=se.getDefinitions();
		printstringdetails pr=new printstringdetails();
		pr.printstring(def);
		res.setDefiniton1(def);
		// System.setOut(ps);
		System.out.println("domains");
		List<String>  dom=se.getDomains();
		pr.printstring(dom);
		res.setDomain1(dom);
		List<String>  regi=se.getRegisters();
		pr.printstring(regi);
		res.setRegister1(regi);
		List<Example__>  ex=se.getExamples();
		if(ex!=null)
		{
		for (Example__ example__ : ex) {
		//	 System.setOut(ps);
			if(example__!=null)
			{
			res.setText(example__.getText());
			System.out.println(example__.getText());
			}
		}
		}
		return res;
	}

}
