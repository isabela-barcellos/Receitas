package br.com.fiap.espb.checkpoint.receitas.controllers;

import br.com.fiap.espb.checkpoint.receitas.domainModel.Ingrediente;
import br.com.fiap.espb.checkpoint.receitas.domainModel.Receitas;
import br.com.fiap.espb.checkpoint.receitas.dto.IngredienteDto;
import br.com.fiap.espb.checkpoint.receitas.exception.ResourceNotFoundException;
import br.com.fiap.espb.checkpoint.receitas.service.IngredienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/ingrediente")
public class IngredienteController {
    private final IngredienteService service;

    public IngredienteController(IngredienteService service) {
        this.service = service;
    }

    //Criação do banco de dados

    @GetMapping
    public ResponseEntity<List<IngredienteDto>> listarTodos() {
        return ResponseEntity.ok(service.listarTodos());
    }

    @GetMapping("/{idIngrediente}")
    public ResponseEntity<IngredienteDto> buscarId(@PathVariable int idIngrediente) {
        return ResponseEntity.ok(service.buscarId(idIngrediente));
    }

    @PostMapping
    public ResponseEntity<IngredienteDto> criarIngrediente(@RequestBody IngredienteDto ingrediente){
        IngredienteDto novo = service.inserir(ingrediente);
        return ResponseEntity.status(HttpStatus.CREATED).body(novo);
    }

    @PutMapping("/{idIngrediente}")
    public ResponseEntity<IngredienteDto> atualizarIngrediente(@PathVariable int idIngrediente, @RequestBody IngredienteDto ingredienteAtualizado){
        return ResponseEntity.ok(service.atualizar(idIngrediente, ingredienteAtualizado));
        //protocolo http 200 - ok
    }

    @DeleteMapping("/{idIngrediente}")
    public ResponseEntity<Void> deletarIngrediente(@PathVariable int idIngrediente){
        service.deletar(idIngrediente);
        return ResponseEntity.noContent().build();
    }

}
