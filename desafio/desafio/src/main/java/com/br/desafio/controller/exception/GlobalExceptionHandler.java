package com.br.desafio.controller.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Void> handleValidationExceptions(MethodArgumentNotValidException ex) {
        log.warn("Erro na requisição do usuário.");
        return ResponseEntity.unprocessableEntity().build();
    }
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<Void> handleBadRequestException(HttpMessageNotReadableException ex) {
        log.warn("Corpo da requisição inválido (400).");
        return ResponseEntity.badRequest().build();
    }
}