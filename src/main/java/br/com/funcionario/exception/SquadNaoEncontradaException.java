package br.com.funcionario.exception;

import static br.com.funcionario.config.Constants.MENSAGEM_SQUAD_NAO_ENCONTRADA;

public class SquadNaoEncontradaException extends RuntimeException{
    public SquadNaoEncontradaException() {
        super(MENSAGEM_SQUAD_NAO_ENCONTRADA);
    }
    public SquadNaoEncontradaException(String message) {
        super(message);
    }
}
