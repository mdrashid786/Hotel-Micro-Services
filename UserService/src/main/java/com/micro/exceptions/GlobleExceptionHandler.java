//package com.micro.exceptions;
//
//import com.micro.payload.ApiResponse;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.RestControllerAdvice;
//
//@RestControllerAdvice
//public class GlobleExceptionHandler {
//
//    @ExceptionHandler(ResourceNotFoundExceptions.class)
//    public ResponseEntity<ApiResponse> handlerResourceNotFoundExceptions(ResourceNotFoundExceptions exceptions){
//
//        String message = exceptions.getMessage();
//        ApiResponse response = ApiResponse.builder()
//                .message(message)
//                .success(true) // Assuming this indicates the operation was not successful
//                .status(HttpStatus.NOT_FOUND)
//                .build();
//        return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
//    }
//}
