package com.example.springbootswagger2.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

public class ResponseUtil {

    public static ResponseEntity<String> buildResponseEntity(Object contentBody, HttpStatus httpStatus) {
        return ResponseEntity.status(httpStatus).contentType(MediaType.APPLICATION_JSON)
                .body(GsonUtil.getDefault().toJson(contentBody));
    }

    public static ResponseEntity erroResponseEntity(Object message, HttpStatus httpStatus) {
        return ResponseEntity.status(httpStatus)
                .contentType(MediaType.APPLICATION_JSON)
                .body(GsonUtil.getDefault().toJson(message));
    }

    public static String formatString(String string){
        string = string.replaceAll("[ãâàáä]", "a")
                .replaceAll("[êèéë]", "e")
                .replaceAll("[îìíï]", "i")
                .replaceAll("[õôòóö]", "o")
                .replaceAll("[ûúùü]", "u")
                .replaceAll("[ÃÂÀÁÄ]", "A")
                .replaceAll("[ÊÈÉË]", "E")
                .replaceAll("[ÎÌÍÏ]", "I")
                .replaceAll("[ÕÔÒÓÖ]", "O")
                .replaceAll("[ÛÙÚÜ]", "U")
                .replace('ç', 'c')
                .replace('Ç', 'C')
                .replace('ñ', 'n')
                .replace('Ñ', 'N')
                .replaceAll("!", "");
        return string;
    }
}
