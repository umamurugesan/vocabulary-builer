package com.example.demo.getdetails;

import java.util.List;


import com.example.jsonformat.*;
import com.javasampleapproach.jqueryajax.message.ResponseString;
public class getsensedetails {
	
	public ResponseString getsense(Sense se)
	{
	 List<String> examp=se.getDefinitions();
	 List<String> def=se.getDefinitions();
	 //to print definition
//	 System.setOut(ps);
	 ResponseString res=new ResponseString();
	 System.out.println("definition:");
	 printstringdetails pt=new printstringdetails();
	 pt.printstring(def);
//	 res.setDefiniton(def);
	 //to print domain
	 List<String> dom=se.getDomains();
	// System.setOut(ps);
	 System.out.println("Domain");
	 pt.printstring(dom);
	// res.setDomain(dom);
	 List<Example_> ex=se.getExamples();
	 if(ex!=null)
	 {
	 for (Example_ example_ : ex) {
		getexampledetails ge=new getexampledetails();
		examp.addAll(ge.getexample(example_));
	}}
	 res.setRegister(examp);
	 List<Subsense> sub=se.getSubsenses();
	 if(sub!=null)
	 {
    for (Subsense subsense : sub) {
    	if(subsense!=null)
    	{
		getsubsensedetails gsbu=new getsubsensedetails();
		if(gsbu!=null)
		{
		res=gsbu.getsubsense(subsense);
		}
    	}
	}
	}
	return res; 
	}

}
