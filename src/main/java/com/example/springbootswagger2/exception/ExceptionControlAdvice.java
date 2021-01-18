package com.example.springbootswagger2.exception;
import com.example.springbootswagger2.util.ResponseUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.security.auth.login.AccountNotFoundException;
import javax.validation.ConstraintViolationException;
import java.util.*;

@ControllerAdvice
public class ExceptionControlAdvice {


    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }

//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public ResponseEntity<Object> handleMethodArgumentNotValid(
//            MethodArgumentNotValidException exception) {
//
//        List<FieldError> errors = exception.getBindingResult().getFieldErrors();
//
//        String erro = errors.get(0).getDefaultMessage();
//        System.out.println(erro);
//
//        return ResponseUtil.erroResponseEntity("parameter"+errors.get(0).getField()+" is required", HttpStatus.BAD_REQUEST);
//    }

//    @ExceptionHandler(ConstraintViolationException.class)
//    public ResponseEntity<Object> handleConstraintViolation(ConstraintViolationException e) {
//        ResponseDTO responseDTO = new ResponseDTO(StatusResponseEnum.INVALID_CARD.getStatusValue(), StatusResponseEnum.INVALID_CARD.getMessageValue(), StatusResponseEnum.INVALID_CARD.getMessageValueBacen(), e.getMessage());
//
//        return ResponseUtil.erroResponseEntity(responseDTO, HttpStatus.BAD_REQUEST);
//    }
//
//    @ExceptionHandler(Exception.class)
//    public ResponseEntity handlerException(Exception e){
//        ResponseDTO responseDTO = new ResponseDTO(StatusResponseEnum.INCORRECT_SYSTEM_FUNCTION.getStatusValue(), StatusResponseEnum.INCORRECT_SYSTEM_FUNCTION.getMessageValue(), StatusResponseEnum.INCORRECT_SYSTEM_FUNCTION.getMessageValueBacen(), e.getMessage());
//        return ResponseUtil.erroResponseEntity(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
//    }
//
    @ExceptionHandler(ParametersBodyException.class)
    public ResponseEntity handlerParametersBodyException(ParametersBodyException e){
//        ResponseDTO responseDTO = new ResponseDTO();
        System.out.println(e.message);

        return ResponseUtil.erroResponseEntity(e.message, HttpStatus.BAD_REQUEST);
    }



}
