package com.javasampleapproach.jqueryajax.controller;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
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
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.example.demo.getdetails.getmeaninglexicalentry;
import com.example.jsonformat.Entry;
import com.example.jsonformat.Example;
import com.example.jsonformat.Example_;
import com.example.jsonformat.LexicalEntry;
import com.example.jsonformat.Result;
import com.example.jsonformat.Sense;
import com.example.jsonformat.Subsense;
import com.javasampleapproach.jqueryajax.message.Response;
import com.javasampleapproach.jqueryajax.message.ResponseString;
import com.javasampleapproach.jqueryajax.model.Word;

import databasejdbc.maincomparison;


import javax.ws.rs.*;




@RestController
@RequestMapping("/api/customer")
public class RestWebController {

	List<Word> cust = new ArrayList<Word>();
	
	 

	@GetMapping(value = "/all")
	public Response getResource() {
		Response response = new Response("Done", cust);
		return response;
	}

	@PostMapping(value = "/save",consumes="application/json")
	public Response postCustomer(@RequestBody Word customer) throws Exception {
		cust.add(customer);
		System.out.println(customer.getword());
		System.out.println(customer.getMeaning());
		
		// Create Response Object
		
ResponseString res1=new ResponseString();

		Object response=new Object();
		String status=null;
			response=	checkwordpresnt(customer);

	//		System.out.println("respone type"+response.getClass());
			
	
			if(response==null)
			{
				 response="error in data entry";
				 status="wrong";
			}
			else if(response.getClass().equals(res1.getClass()))
			{
				status="Done";
			
			}
			else
				
			{
				status="present";
			}
				
		Response res=new Response(status, response);
	return res;
		
	}
	
	@RequestMapping(produces=javax.ws.rs.core.MediaType.APPLICATION_JSON,method=RequestMethod.GET)
	public Object checkwordpresnt(Word wo) throws Exception
	{
		
		 
		String id=wo.getword();
		Object response=null;
		String URL=wo.getMeaning();
		System.out.println("URL in rest:"+URL);
		System.out.println(id);
		Object response1=new Object();
		Response datapresent;
		  maincomparison mai=new maincomparison();
		  datapresent=mai.checkcondition(wo);
		  String status=datapresent.getStatus();
		  System.out.println(status);
		  
		  if(datapresent.getStatus().equals("Done"))
		  {
		 
		
			  response1= meaningoftheword(id);
			  mai.store(wo);
		
		
 
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
	         Object response=new Object();
	 		RestTemplate rest=new RestTemplate();
	 		HttpHeaders header=new HttpHeaders();
	 		header.set("app_id", app_id);
	 		header.set("app_key", app_key);
	 	header.set("Accept", Accept);
	     HttpEntity<String> entity = new HttpEntity<String>("parameters", header);
	 

			String uri="https://od-api.oxforddictionaries.com:443/api/v1/entries/en/"+id;
		java.util.List<MediaType> m=new ArrayList<>();
		

	 
	    ResponseEntity<Example> result=null;
		try {
			result = rest.exchange(uri, HttpMethod.GET, entity, Example.class);
		} catch (RestClientException e) {
			// TODO Auto-generated catch block
			response="word is not found in dictionary";
		
			return response;
		}
	
	    
 Example ex=result.getBody();

 ResponseString restring=new ResponseString();

	java.util.List<Result> re=ex.getResults();	
	List<String>  resulttype=new ArrayList<>();
	List<String> lex=new ArrayList<>();

	List<String> def1=new ArrayList<>();
	List<String> dom1=new ArrayList<>();
	List<String> reg1=new ArrayList<>();
	List<String> def=new ArrayList<>();
	List<String> dom=new ArrayList<>();
	List<String> reg=new ArrayList<>();

	 for (Result result2 : re) 
	  {
		java.util.List<LexicalEntry> le=result2.getLexicalEntries();
		/*if(le!=null)
		{
		getmeaninglexicalentry ge=new getmeaninglexicalentry();
		if(ge!=null)
		{
		ge.getmean(le);
	
		
		
	  
		}*/
	
		
		if(le!=null)
		{
			
			for (LexicalEntry lexicalEntry : le) {
				lex.add(lexicalEntry.getLexicalCategory());
			  List<Entry>	en=new ArrayList<>();
			  en=lexicalEntry.getEntries();
			  for (Entry entry : en) {
				List<Sense> se=new ArrayList<>();
			se=entry.getSenses();
				for (Sense sense : se) {
					List<String> temp=new ArrayList<>();
					temp=sense.getDefinitions();
					System.out.println("definition");
					if(temp!=null)
					{
					for (String string : temp) {
						System.out.println(string);
					}
				
					def.addAll(temp);
					}
					temp=sense.getDomains();
					if(temp!=null)
					dom.addAll(sense.getDomains());
					temp=sense.getRegisters();
					if(temp!=null)
					reg.addAll(sense.getRegisters());
					List<Example_> ex1=new ArrayList<>();
					List<String> text=new ArrayList<>();
					if(ex!=null)
					for (Example_ example_ : ex1) {
						text.add(example_.getText());
					}
					List<Subsense> sub=new ArrayList<>();
					if(sub!=null)
					for (Subsense subsense : sub) {
						temp=subsense.getDefinitions();
						if(temp!=null)
						def1.addAll(subsense.getDefinitions());
						temp=subsense.getDomains();
						if(temp!=null)
						dom1.addAll(subsense.getDomains());
						temp=subsense.getRegisters();
								if(temp!=null)
						reg1.addAll(subsense.getRegisters());
					}
					
				}
				
			}
			
			
			}
			
			
		}
		
		System.out.println(result2.getType());
		resulttype.add(result2.getType());
	
		}
		
		
	restring.setDefiniton(def);
	restring.setDefiniton1(def1);
	restring.setDomain(dom);
	restring.setDomain1(dom1);
	restring.setLexical(lex);
	restring.setRegister(reg);
	restring.setRegister1(reg1);
	restring.setText("new word");
	response=restring;
//	 restring.setType(resulttype);
//	 response=restring;
//System.out.println("printing from object");
//System.out.println(restring.getText());
//System.out.println("Definition:");
//
////definition
//List<String> st=new ArrayList<>();
//st=restring.getDefiniton();
//if(st!=null)
//for (String string : st) {
//	System.out.println(string);
//}
//
////domain
//System.out.println("Domain");
//st=restring.getDomain();
//if(st!=null)
//for (String string : st) {
//	System.out.println(string);
//}
//
////lexical entry
//System.out.println("Lexical entry");
//st=restring.getLexical();
//for (String string : st) {
//	System.out.println(string);
//}
 
	    
	 
	 return response;
	}
}