package com.javasampleapproach.jqueryajax.controller;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.getdetails.getmeaninglexicalentry;
import com.example.jsonformat.Example;
import com.example.jsonformat.LexicalEntry;
import com.example.jsonformat.Result;
import com.javasampleapproach.jqueryajax.message.Response;
import com.javasampleapproach.jqueryajax.message.ResponseString;
import com.javasampleapproach.jqueryajax.model.Word;

import databasejdbc.maincomparison;

import javax.ws.*;




@RestController
@RequestMapping("/api/customer")
public class RestWebController {

	List<Word> cust = new ArrayList<Word>();
	
	 

	@GetMapping(value = "/all")
	public Response getResource() {
		Response response = new Response("Done", cust);
		return response;
	}

	@PostMapping(value = "/save")
	public Response postCustomer(@RequestBody Word customer) throws Exception {
		cust.add(customer);
		
		// Create Response Object
		


		Object response=null;
			response=	checkwordpresnt(customer);
			if(response==null)
				 response="no data";
		Response res=new Response("Done", response);
	return res;
		
	}
	
	@RequestMapping(produces=javax.ws.rs.core.MediaType.APPLICATION_JSON,method=RequestMethod.GET)
	public Object checkwordpresnt(Word wo) throws Exception
	{
		
		 
		String id=wo.getword();
		Object response=null;
		System.out.println(id);
		Object response1=null;
		Response datapresent;
		  maincomparison mai=new maincomparison();
		  datapresent=mai.checkcondition(wo);
		  String status=datapresent.getStatus();
		  System.out.println(status);
		  if(datapresent.getStatus().equals("Done"))
		  {
		 
		  System.out.println("inside if");
			  response1= meaningoftheword(id);
		
		
 
		  }
		 else
		  {
		
			 response1="You know the meaning of the word,You have read the word in the URL:"+datapresent.getData();
		  }
		  return response1;
        }
	
	public Object meaningoftheword( String id)
	{
		//oxford api call
		final String app_id = "fc534ef9";
	         final String app_key = "a1c4bcca85b806a172d5fed6e0a26e96";
	         final String Accept="application/json";
	     	
	 		RestTemplate rest=new RestTemplate();
	 		HttpHeaders header=new HttpHeaders();
	 		header.set("app_id", app_id);
	 		header.set("app_key", app_key);
	 	header.set("Accept", Accept);
	     HttpEntity<String> entity = new HttpEntity<String>("parameters", header);
	 

			String uri="https://od-api.oxforddictionaries.com:443/api/v1/entries/en/"+id;
		java.util.List<MediaType> m=new ArrayList<>();
		

	    ResponseEntity<Example> result = rest.exchange(uri, HttpMethod.GET, entity, Example.class);
	
	    
	   Example ex=result.getBody();
Object response=ex;
 ResponseString restring=new ResponseString();

	java.util.List<Result> re=ex.getResults();	
	List<String>  resulttype=new ArrayList<>();

	 for (Result result2 : re) 
	  {
		java.util.List<LexicalEntry> le=result2.getLexicalEntries();
		if(le!=null)
		{
		getmeaninglexicalentry ge=new getmeaninglexicalentry();
		if(ge!=null)
		{
		restring=ge.getmean(le);
	
		
		
	  
		}
		
		System.out.println(result2.getType());
		
	
		}
		resulttype.add(result2.getType());
		
	}
	 restring.setType(resulttype);
	 response=result;
	 System.out.println(restring.toString());
	 return response;
	}
}