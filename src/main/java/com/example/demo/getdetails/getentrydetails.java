package com.example.demo.getdetails;

import java.util.List;

import com.example.demo.*;
import com.javasampleapproach.jqueryajax.message.ResponseString;


public class getentrydetails {
	
	public ResponseString getentry(com.example.jsonformat.Entry en)
	{
	
		ResponseString res=new ResponseString();
		List<com.example.jsonformat.Sense> senses=en.getSenses();
		for (com.example.jsonformat.Sense sense : senses) {
			if(sense!=null)
			{
			getsensedetails gse=new getsensedetails();
			if(gse!=null)
			    res =gse.getsense(sense);
			}
		}
		return res;
	}

}
