package br.com.fiap.seguroautomotivo.config;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.fiap.seguroautomotivo.models.RestValidationError;



//indicando que ele vai captar todas a execpetions disparadas
@RestControllerAdvice
public class RestExecptionHandler {
    
    Logger log = LoggerFactory.getLogger(getClass());

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<RestValidationError>> methodArgumentNotValidExecpetionHandler(MethodArgumentNotValidException e){
        log.error("Erro de validação");
        List<RestValidationError> errors = new ArrayList<>();
        e.getFieldErrors().forEach(v-> errors.add(new RestValidationError(v.getField(), v.getDefaultMessage())));
        return ResponseEntity.badRequest().body(errors);
    }
}
