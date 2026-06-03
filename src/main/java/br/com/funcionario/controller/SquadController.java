package br.com.funcionario.controller;

import br.com.funcionario.dto.SquadDTORequest;
import br.com.funcionario.dto.SquadDTOResponse;
import br.com.funcionario.service.SquadService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;

@RestController
@RequestMapping("/v1/squads")
@AllArgsConstructor
public class SquadController {

    private SquadService squadService;

    @PostMapping
    private ResponseEntity<Void> inserirSquad(@Valid @NotNull @RequestBody SquadDTORequest squadDTO) {
        squadService.inserirSquad(squadDTO);
        return ResponseEntity.status(CREATED).build();
    }

    @GetMapping
    private ResponseEntity<List<SquadDTOResponse>> buscarSquads() {
        var squads = squadService.buscarSquads();
        return ResponseEntity.ok().body(squads);
    }

    @GetMapping("/{id}")
    private ResponseEntity<SquadDTOResponse> buscarSquadsPorId(@NotNull @PathVariable("id") Long id) {
        var squad = squadService.buscarSquadPorId(id);
        return ResponseEntity.ok().body(squad);
    }

    @PatchMapping("/{id}")
    private ResponseEntity<SquadDTOResponse> atualizarSquad(@NotNull @Valid @PathVariable("id") Long id, @RequestBody SquadDTORequest squadDTORequest) {
        var squad = squadService.atualizarSquad(id, squadDTORequest);
        return ResponseEntity.ok().body(squad);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<Void> deletarSquad(@NotNull @PathVariable("id") Long id) {
        squadService.deletarSquad(id);
        return ResponseEntity.status(NO_CONTENT).build();
    }
}
