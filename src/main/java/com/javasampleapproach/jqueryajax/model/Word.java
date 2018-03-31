package com.javasampleapproach.jqueryajax.model;

public class Word {
    private String word;
    private String URL;
     
    public Word(){}
     
    public Word(String firstname, String lastname){
        this.word = firstname;
        this.URL = lastname;
    }
     
    // firstname
    public String getword() {
        return word;
    }
    public void setFirstname(String firstname) {
        this.word = firstname;
    }
     
    // lastname
    public String getURL() {
        return URL;
    }
    public void setURL(String URL) {
        this.URL = URL;
    }
}