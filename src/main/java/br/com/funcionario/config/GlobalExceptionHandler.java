package br.com.funcionario.config;

import br.com.funcionario.dto.ResponseException;
import br.com.funcionario.exception.FuncionarioNaoEncontradoException;
import br.com.funcionario.exception.RacfDuplicadaException;
import br.com.funcionario.exception.SquadNaoEncontradaException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.HandlerMethodValidationException;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseException> exception (Exception exceptionGeneric) {
        ResponseException responseException = new ResponseException(HttpStatus.INTERNAL_SERVER_ERROR, "Erro interno do servidor");
        log.error("Exceção não tratada capturada: ", exceptionGeneric);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseException);
    }

    @ExceptionHandler(HandlerMethodValidationException.class)
    public ResponseEntity<ResponseException> handlerMethodValidationException(HandlerMethodValidationException exception) {
        var exceptionMessage = exception.getMessage();
        ResponseException responseException = new ResponseException(HttpStatus.UNPROCESSABLE_ENTITY, exceptionMessage);
        log.error("Exceção não tratada capturada: {}", exceptionMessage);
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(responseException);
    }

    @ExceptionHandler(FuncionarioNaoEncontradoException.class)
    public ResponseEntity<ResponseException> funcionarioNaoEncontradoException(FuncionarioNaoEncontradoException exception) {
        ResponseException responseException = new ResponseException(HttpStatus.NOT_FOUND, exception.getMessage());
        log.error("Exceção não tratada capturada: ", exception);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseException);
    }

    @ExceptionHandler(RacfDuplicadaException.class)
    public ResponseEntity<ResponseException> racfDuplicadaException(RacfDuplicadaException exception) {
        ResponseException responseException = new ResponseException(HttpStatus.UNPROCESSABLE_ENTITY, exception.getMessage());
        log.error("Exceção não tratada capturada: ", exception);
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(responseException);
    }

    @ExceptionHandler(SquadNaoEncontradaException.class)
    public ResponseEntity<ResponseException> squadNaoEncontradaException(SquadNaoEncontradaException exception) {
        ResponseException responseException = new ResponseException(HttpStatus.NOT_FOUND, exception.getMessage());
        log.error("Exceção não tratada capturada: ", exception);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseException);
    }

}