package databasejdbc;

import java.sql.Connection;
import java.util.List;

import javax.activation.DataSource;



abstract public class DictionaryDAO {
	
	
	
	 /** 
     * This is the method to be used to initialize
     * database resources ie. connection.
  */
	  abstract public void setDataSource(DataSource ds);
	   
	   /** 
	      * This is the method to be used to create
	      * a record in the Student table.
	   */
	abstract   public void create(String word, String URL,String Userid);
	   
	   abstract public  List<wodlist> listofword();
	   

}
