package com.example.jsonformat;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"definitions",
"domains",
"examples",
"id",
"registers",
"notes"
})
public class Subsense {

@Override
	public String toString() {
		return "Subsense [definitions=" + definitions + ", domains=" + domains + ", examples=" + examples + ", id=" + id
				+ ", registers=" + registers + ", notes=" + notes + ", additionalProperties=" + additionalProperties
				+ "]";
	}

@JsonProperty("definitions")
private List<String> definitions = null;
@JsonProperty("domains")
private List<String> domains = null;
@JsonProperty("examples")
private List<Example__> examples = null;
@JsonProperty("id")
private String id;
@JsonProperty("registers")
private List<String> registers = null;
@JsonProperty("notes")
private List<Note> notes = null;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

@JsonProperty("definitions")
public List<String> getDefinitions() {
return definitions;
}

@JsonProperty("definitions")
public void setDefinitions(List<String> definitions) {
this.definitions = definitions;
}

@JsonProperty("domains")
public List<String> getDomains() {
return domains;
}

@JsonProperty("domains")
public void setDomains(List<String> domains) {
this.domains = domains;
}

@JsonProperty("examples")
public List<Example__> getExamples() {
return examples;
}

@JsonProperty("examples")
public void setExamples(List<Example__> examples) {
this.examples = examples;
}

@JsonProperty("id")
public String getId() {
return id;
}

@JsonProperty("id")
public void setId(String id) {
this.id = id;
}

@JsonProperty("registers")
public List<String> getRegisters() {
return registers;
}

@JsonProperty("registers")
public void setRegisters(List<String> registers) {
this.registers = registers;
}

@JsonProperty("notes")
public List<Note> getNotes() {
return notes;
}

@JsonProperty("notes")
public void setNotes(List<Note> notes) {
this.notes = notes;
}

@JsonAnyGetter
public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

@JsonAnySetter
public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

}
