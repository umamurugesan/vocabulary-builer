package com.example.demo.getdetails;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.*;
import com.javasampleapproach.jqueryajax.message.ResponseString;


public class getentrydetails {
	
	public ResponseString getentry(com.example.jsonformat.Entry en)
	{
	
		ResponseString res=new ResponseString();
		List<String>  def1=new ArrayList<>();
		List<String> dom1=new ArrayList<>();
		List<com.example.jsonformat.Sense> senses=en.getSenses();
		for (com.example.jsonformat.Sense sense : senses) {
			if(sense!=null)
			{
			getsensedetails gse=new getsensedetails();
			if(gse!=null)
			{
				List<String> temp=new ArrayList<>();
				temp=sense.getDefinitions();
				if(temp!=null)
				def1.addAll(temp);
				temp=sense.getDomains();
				if(temp!=null)
				dom1.addAll(temp);
				
			    gse.getsense(sense);
			}
			}
		}
		res.setDefiniton(def1);
		res.setDomain(dom1);
		return res;
	}

}
