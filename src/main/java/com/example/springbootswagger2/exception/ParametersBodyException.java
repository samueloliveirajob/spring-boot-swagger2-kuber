package com.example.springbootswagger2.exception;

//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//@NoArgsConstructor
//@AllArgsConstructor
//@Data
public class ParametersBodyException extends Exception {
    String message;

    public ParametersBodyException(String s) {
        message = s;
    }
}
