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
"subsenses",
"regions"
})
public class Sense {

@Override
	public String toString() {
		return "Sense [definitions=" + definitions + ", domains=" + domains + ", examples=" + examples + ", id=" + id
				+ ", registers=" + registers + ", subsenses=" + subsenses + ", regions=" + regions
				+ ", additionalProperties=" + additionalProperties + "]";
	}

@JsonProperty("definitions")
private List<String> definitions = null;
@JsonProperty("domains")
private List<String> domains = null;
@JsonProperty("examples")
private List<Example_> examples = null;
@JsonProperty("id")
private String id;
@JsonProperty("registers")
private List<String> registers = null;
@JsonProperty("subsenses")
private List<Subsense> subsenses = null;
@JsonProperty("regions")
private List<String> regions = null;
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
public List<Example_> getExamples() {
return examples;
}

@JsonProperty("examples")
public void setExamples(List<Example_> examples) {
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

@JsonProperty("subsenses")
public List<Subsense> getSubsenses() {
return subsenses;
}

@JsonProperty("subsenses")
public void setSubsenses(List<Subsense> subsenses) {
this.subsenses = subsenses;
}

@JsonProperty("regions")
public List<String> getRegions() {
return regions;
}

@JsonProperty("regions")
public void setRegions(List<String> regions) {
this.regions = regions;
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