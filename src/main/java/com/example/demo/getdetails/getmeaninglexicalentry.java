package com.example.demo.getdetails;

import java.util.ArrayList;
import java.util.List;

import com.example.jsonformat.*;
import com.javasampleapproach.jqueryajax.message.ResponseString;




public class getmeaninglexicalentry {
	
	
	
	public ResponseString getmean(List<LexicalEntry> le)
	{
		List<String> st=new ArrayList<>();
		ResponseString res=new ResponseString();
		for (LexicalEntry lexicalEntry : le) {
		  
		st.add(lexicalEntry.getLexicalCategory());
		System.out.println(lexicalEntry.getLexicalCategory());
		List<Entry> en=lexicalEntry.getEntries();
		for (Entry entry : en) {
			if(entry!=null)
			{
		 getentrydetails g=new getentrydetails();
		 if(g!=null)
		res= g.getentry(entry);
		}}}
		res.setLexical(st);
		return res;
	}

}
