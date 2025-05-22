package br.com.fiap.espb.checkpoint.receitas.controllers;

import br.com.fiap.espb.checkpoint.receitas.dto.ReceitasDto;
import br.com.fiap.espb.checkpoint.receitas.service.ReceitasService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/receitas")
public class ReceitasController {
    private final ReceitasService service;

    public ReceitasController(ReceitasService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ReceitasDto> criarReceita(@RequestBody ReceitasDto receitasDto) {
        try {
            ReceitasDto novaReceita = service.inserirDto(receitasDto);
            return ResponseEntity.status(HttpStatus.CREATED).body(novaReceita);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping
    public ResponseEntity<List<ReceitasDto>> listarReceitasDto() {
        List<ReceitasDto> receitas = service.listarReceitasDto();
        return receitas.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(receitas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReceitasDto> buscarId(@PathVariable int id) {
        ReceitasDto receitaDto = service.buscarId(id);
        return receitaDto != null ? ResponseEntity.ok(receitaDto) : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReceitasDto> atualizarReceita(@PathVariable int id, @RequestBody ReceitasDto receitaAtualizada) {
        try {
            ReceitasDto receitaDto = service.atualizar(id, receitaAtualizada);
            return ResponseEntity.ok(receitaDto);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarReceita(@PathVariable int id) {
        try {
            service.deletar(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}