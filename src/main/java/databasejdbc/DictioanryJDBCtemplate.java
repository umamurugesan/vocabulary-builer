package databasejdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Set;

import javax.sql.*;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import com.mysql.jdbc.Driver;

//import com.mysql.jdbc.Driver;


public class DictioanryJDBCtemplate extends DictionaryDAO {
	
	 DataSource dataSource;
	   private JdbcTemplate	   jdbcTemplateObject;
	   
	   

	public  void createDictioanryJDBCtemplate() throws Exception{
		
		String Url="jdbc:mysql://localhost:3306/dictionary";
			String  username="root";
			String  password="root";
			com.mysql.cj.jdbc.Driver d=new com.mysql.cj.jdbc.Driver();
        dataSource= new SimpleDriverDataSource(d,Url, username, password);
 
    
        
         
        jdbcTemplateObject = new JdbcTemplate(dataSource);
        int rows=jdbcTemplateObject.getMaxRows();
     //   System.out.println("connection established"+rows);
	}



	@Override
	public List<wodlist> listofword() {
		// TODO Auto-generated method stub
		String SQL = "select * from wordlist";
		
		  List<wodlist> listContact = jdbcTemplateObject.query(SQL, new RowMapper<wodlist>()
		  {

			@Override
			public wodlist mapRow(ResultSet arg0, int arg1) throws SQLException 
			{
				// TODO Auto-generated method stub
				//System.out.println(arg1);
			if(arg0!=null)	
			{
				wodlist wo=new wodlist();
		
				wo.setURL(arg0.getString(4));
				wo.setWordname(arg0.getString(3));
				wo.setUserid(arg0.getString(2));
				return wo;
			}
			else
				return null;
			}
			
		  });
		  
		return listContact;
	}

	

	@Override
	public void create(String word, String URL, String Userid) {
		// TODO Auto-generated method stub
		
		 String SQL = "insert into wordlist (userid, wordname,URL) values (?, ?,?)";
		 System.out.println(URL);
	jdbcTemplateObject.update(SQL, Userid,word,URL);
	      
	   
		
	}



	@Override
	public void setDataSource(javax.activation.DataSource ds) {
		// TODO Auto-generated method stub
		
		  this.dataSource = dataSource;
	      this.jdbcTemplateObject = new JdbcTemplate(dataSource);
		
	}



	
}
