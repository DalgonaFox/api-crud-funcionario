package br.com.funcionario.exception;

import static br.com.funcionario.config.Constants.MENSAGEM_FUNCIONARIO_NAO_ENCONTRADO;

public class FuncionarioNaoEncontradoException extends RuntimeException{
    public FuncionarioNaoEncontradoException() {
        super(MENSAGEM_FUNCIONARIO_NAO_ENCONTRADO);
    }

    public FuncionarioNaoEncontradoException(String message) {
        super(message);
    }
}
