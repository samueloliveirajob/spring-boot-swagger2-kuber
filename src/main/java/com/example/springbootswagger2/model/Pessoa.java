package com.example.springbootswagger2.model;

import io.swagger.annotations.ApiModelProperty;

public class Pessoa {
	@ApiModelProperty(notes = "Name of the Pessoa",name="name", required=true,value="test name")
	private String name;
	@ApiModelProperty(notes = "State of the Pessoa",name="state", required=true,value="test state")
	private String state;
	@ApiModelProperty(notes = "Country of the Pessoa",name="country", required=true,value="test country")
	private String country;

	public Pessoa() {
	}

	public Pessoa(String name, String state, String country) {
		super();
		this.name = name;
		this.state = state;
		this.country = country;
	}

	public String getName() {
		return name;
	}

	public String getState() {
		return state;
	}

	public String getCountry() {
		return country;
	}

	@Override
	public String toString() {
		return "Pessoa [name=" + name + ", state=" + state + ", country=" + country + "]";
	}

}
