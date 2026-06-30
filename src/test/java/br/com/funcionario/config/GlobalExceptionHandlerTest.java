package br.com.funcionario.config;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.mock;

@ExtendWith(MockitoExtension.class)
public class GlobalExceptionHandlerTest {

    private final GlobalExceptionHandler handler = new GlobalExceptionHandler();

    @Test
    void funcionarioNaoEncontradoException() {
        FuncionarioNaoEncontradoException ex = mock(FuncionarioNaoEncontradoException.class);

    }
}
