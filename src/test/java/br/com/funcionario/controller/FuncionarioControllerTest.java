package br.com.funcionario.controller;

import br.com.funcionario.dto.FuncionarioDTORequest;
import br.com.funcionario.dto.FuncionarioDTOResponse;
import br.com.funcionario.entity.Funcionarios;
import br.com.funcionario.service.FuncionarioService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;

@RestController
@RequestMapping("/v1/funcionarios")
@RequiredArgsConstructor
public class FuncionarioControllerTest {

    private final FuncionarioService funcionarioService;

    @PostMapping
    private ResponseEntity<Void> inserirFuncionario(@Valid @NotNull @RequestBody FuncionarioDTORequest funcionarioDTO) {
        funcionarioService.inserirFuncionario(funcionarioDTO);
        return ResponseEntity.status(CREATED).build();
    }

    @GetMapping
    private ResponseEntity<List<FuncionarioDTOResponse>> buscarFuncionarios() {
        FuncionarioDTOResponse funcionarioDTOResponse = new FuncionarioDTOResponse();
        var funcionarios = funcionarioService.buscarFuncionarios();
        return ResponseEntity.ok().body(funcionarios);
    }

    @GetMapping("/{id}")
    private ResponseEntity<FuncionarioDTOResponse> buscarFuncionariosPorId(@PathVariable("id") Long id) {
        var funcionario = funcionarioService.buscarFuncionarioPorId(id);
        return ResponseEntity.ok().body(funcionario);
    }

    @GetMapping("/squad/{id}")
    private ResponseEntity<List<Funcionarios>> buscarFuncionariosPorSquad(@PathVariable("id") Long id) {
        var funcionario = funcionarioService.buscarFuncionariosPorSquad(id);
        return ResponseEntity.ok().body(funcionario);
    }

    @PatchMapping("/{id}")
    private @NotNull ResponseEntity<FuncionarioDTOResponse> atualizarFuncionario(@Valid @PathVariable("id") Long id, @RequestBody FuncionarioDTORequest funcionarioDTORequest) {
        var funcionario = funcionarioService.atualizarFuncionario(id, funcionarioDTORequest);
        return ResponseEntity.ok().body(funcionario);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<Void> deletarFuncionario(@PathVariable("id") Long id) {
        funcionarioService.deletarFuncionario(id);
        return ResponseEntity.status(NO_CONTENT).build();
    }

}
