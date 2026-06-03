package br.com.funcionario.exception;

import static br.com.funcionario.config.Constants.MENSAGEM_RACF_DUPLICADA;

public class RacfDuplicadaException extends RuntimeException{
    public RacfDuplicadaException() {
        super(MENSAGEM_RACF_DUPLICADA);
    }
    public RacfDuplicadaException(String message) {
        super(message);
    }
}
