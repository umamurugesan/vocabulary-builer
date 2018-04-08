package com.javasampleapproach.jqueryajax.message;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import com.example.jsonformat.LexicalEntry;

public class ResponseString {
	
	@Override
	public String toString() {
		return "ResponseString [type=" + type + ", lexical=" + lexical + ", Definiton=" + Definiton + ", Domain="
				+ Domain + ", Definiton1=" + Definiton1 + ", Domain1=" + Domain1 + ", Register1=" + Register1
				+ ", text=" + text + ", Register=" + Register + "]";
	}

	List<String> type;
	 
	 List<String> lexical;
	 
	 List<String>  Definiton;
	 
	 List<String> Domain;
	 
 List<String>  Definiton1;
	 
	 List<String> Domain1;
	 
		List<String> Register1;
		String text;
	 
	 public String getText() {
			return text;
		}

		public void setText(String text) {
			this.text = text;
		}

	public List<String> getDefiniton1() {
			return Definiton1;
		}

		public void setDefiniton1(List<String> definiton1) {
			Definiton1 = definiton1;
		}

		public List<String> getDomain1() {
			return Domain1;
		}

		public void setDomain1(List<String> domain1) {
			Domain1 = domain1;
		}

		public List<String> getRegister1() {
			return Register1;
		}

		public void setRegister1(List<String> register1) {
			Register1 = register1;
		}

	public List<String> getRegister() {
		return Register;
	}

	public void setRegister(List<String> register) {
		Register = register;
	}

	List<String> Register;

	public List<String> getDomain() {
		return Domain;
	}

	public void setDomain(List<String> domain) {
		Domain = domain;
	}

	public List<String> getDefiniton() {
		return Definiton;
	}

	public void setDefiniton(List<String> definiton) {
		Definiton = definiton;
	}

	public List<String> getLexical() {
		return lexical;
	}

	public void setLexical(List<String> lexical) {
		this.lexical = lexical;
	}

	public List<String> getType() {
		return type;
	}

	public void setType(List<String> type) {
		this.type = type;
	}

	


}
