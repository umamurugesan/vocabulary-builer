package com.javasampleapproach.jqueryajax.model;

public class Word {
    private String word;
    private String meaning;
     
    public Word(){}
     
   
     
    // firstname
    public String getword() {
        return word;
    }
    public void setFirstname(String firstname) {
        this.word = firstname;
    }



	public String getMeaning() {
		return meaning;
	}



	public void setMeaning(String meaning) {
		this.meaning = meaning;
	}



	public Word(String word, String meaning) {
		super();
		this.word = word;
		this.meaning = meaning;
	}
     
    // lastname

}