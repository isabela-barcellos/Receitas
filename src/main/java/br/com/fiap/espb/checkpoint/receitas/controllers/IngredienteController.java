package br.com.fiap.espb.checkpoint.receitas.controllers;

import br.com.fiap.espb.checkpoint.receitas.domainModel.Ingrediente;
import br.com.fiap.espb.checkpoint.receitas.domainModel.Receitas;
import br.com.fiap.espb.checkpoint.receitas.exception.ResourceNotFoundException;
import br.com.fiap.espb.checkpoint.receitas.service.IngredienteService;
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
    public ResponseEntity<List<Ingrediente>> listarTodos() {
        return ResponseEntity.ok(service.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ingrediente> buscarId(@PathVariable int idIngrediente) {
        return service.listarTodos().stream().filter(i -> Objects.equals(i.getIdIngrediente(), idIngrediente)).findFirst().map(ResponseEntity::ok).orElseThrow(() -> new ResourceNotFoundException("Ingrediente não encontrado para o id: " + idIngrediente));

    }

    @PostMapping
    public ResponseEntity<Ingrediente> criarIngrediente(@RequestBody Ingrediente ingrediente){
        return ResponseEntity.status(201).body(service.inserir(ingrediente));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Ingrediente> atualizarIngrediente(@PathVariable int idIngrediente,
                                                            @RequestBody Ingrediente ingredienteAtualizado){
        Ingrediente ingrediente = service.listarTodos().stream().filter(i -> Objects.equals(i.getIdIngrediente(),
                idIngrediente)).findFirst().orElseThrow(() -> new ResourceNotFoundException(
                        "Ingrediente não encontrado para o id: " + idIngrediente));
        ingrediente.setNome(ingredienteAtualizado.getNome());
        ingrediente.setQuantidade(ingredienteAtualizado.getQuantidade());
        ingrediente.setMedida(ingredienteAtualizado.getMedida());
       return ResponseEntity.ok(service.inserir(ingrediente));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarIngrediente(@PathVariable int idIngrediente){
        service.deletar(idIngrediente);
        return ResponseEntity.noContent().build();
    }

}
