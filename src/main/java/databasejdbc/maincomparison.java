package databasejdbc;

import java.awt.List;
import java.util.ArrayList;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

import com.javasampleapproach.jqueryajax.message.Response;
import com.javasampleapproach.jqueryajax.message.ResponseString;
import com.javasampleapproach.jqueryajax.model.Word;
@RestController
@Component
public class maincomparison {
	
	
	public Response checkcondition(Word wo)
	{
	String id=wo.getword();
		boolean flag=false;
		try {
			java.util.List<wodlist> words=new ArrayList<>();
			DictioanryJDBCtemplate djdbc=new DictioanryJDBCtemplate();
			djdbc.createDictioanryJDBCtemplate();
			words=djdbc.listofword();
			String URL=null;
			Response res1=null;
		if(words!=null)
		{
			for (wodlist wodlist : words) {
				if(wodlist.getWordname().equals(id))
				{
					flag=true;
					URL=wodlist.getURL();
				
		
				}
				
			}}
			if(flag==false)
				
			{
				
				//djdbc.create(id,wo.getURL(), "uma");
				res1=new Response();
				return res1;
			}
			else
			{
				System.out.println("already present");
				
				System.out.println();
				if(URL==null)
					URL="URL unkonwn";
				 res1=new Response("already known word",URL);
				return res1;
			}
		
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		return null;
	}
	
	public void store(Word wo)
	{
		DictioanryJDBCtemplate djdbc=new DictioanryJDBCtemplate();
		try {
			djdbc.createDictioanryJDBCtemplate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		djdbc.create(wo.getword(),wo.getMeaning(), "uma");
	}

	
	

}
