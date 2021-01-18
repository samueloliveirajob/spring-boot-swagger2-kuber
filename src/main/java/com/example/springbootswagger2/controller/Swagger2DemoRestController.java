package com.example.springbootswagger2.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.example.springbootswagger2.exception.ParametersBodyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.springbootswagger2.model.Pessoa;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.validation.Valid;

@Api(description = "REST Apis related to Person Entity")
@RestController
public class Swagger2DemoRestController {

	List<Pessoa> persons = new ArrayList<Pessoa>();
	{
		persons.add(new Pessoa("Carlos", "Nova Delhi", "India"));
		persons.add(new Pessoa("Ricardo", "Nova Delhi", "India"));
		persons.add(new Pessoa("Samuel", "New York", "USA"));
		persons.add(new Pessoa("Sara", "New York", "USA"));
	}

	@ApiOperation(value = "Get list of Person in the System ", response = Pessoa.class, tags = "Person")
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Sucess"),
			@ApiResponse(code = 404, message = "Not found") })

	@GetMapping(value = "/persons")
	public List<Pessoa> getPessoas() throws Exception {
		return persons;
	}

	@ApiOperation(value = "Post Person in the System ", tags = "Person")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Sucess"),
			@ApiResponse(code = 201, message = "Created"),
			@ApiResponse(code = 400, message = "Bad Request parameter not in payload")})

	@PostMapping(value = "/person")
	public ResponseEntity setPessoas(@Valid @RequestBody Pessoa pessoa) throws Exception {
		if (pessoa.getState() == null || pessoa.getCountry() == null || pessoa.getName() == null){
			throw new ParametersBodyException("name, state and country is required!");
		}
		persons.add(pessoa);
		return new ResponseEntity<>( "Sucess", HttpStatus.CREATED);
	}

	@GetMapping(value = "/healthcheck")
	public String healthcheck(){
		return "Ok";
	}

	@GetMapping(value = "/healthcheck3")
	public String healthcheck3(){
		return "Ok";
	}

}
