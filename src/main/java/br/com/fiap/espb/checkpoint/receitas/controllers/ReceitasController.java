package br.com.fiap.espb.checkpoint.receitas.controllers;

import br.com.fiap.espb.checkpoint.receitas.domainModel.Receitas;
import br.com.fiap.espb.checkpoint.receitas.exception.ResourceNotFoundException;
import br.com.fiap.espb.checkpoint.receitas.service.ReceitasService;
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
    //Criação do banco de dados

    @GetMapping
    public ResponseEntity<List<Receitas>> listarTodas() {
        return ResponseEntity.ok(service.listarTodas());
    }

    @GetMapping("/{idReceita}")
    public ResponseEntity<Receitas> buscarId(@PathVariable int idReceita) {
        return service.buscarId(idReceita).map(ResponseEntity::ok).orElseThrow(() -> new ResourceNotFoundException("Receita não encontrada com o id: " + idReceita));
    }
//trocando idReceita por id
    @PostMapping
    public ResponseEntity<Receitas> criarReceita(@RequestBody Receitas receita) {
        Receitas novaReceita = service.inserir(receita);
        return ResponseEntity.status(201).body(novaReceita);
    }
    //201 - protocolo http criado

    @PutMapping("/{idReceita}")
    public ResponseEntity<Receitas> atualizarReceita(@PathVariable int idReceita, @RequestBody Receitas receitaAtualizada) {
        Receitas receita = service.buscarId(idReceita).orElseThrow(() -> new ResourceNotFoundException("Receita não encontrada com o id: " + idReceita));
        receita.setNome(receitaAtualizada.getNome());
        receita.setDescricao(receitaAtualizada.getDescricao());
        receita.setTempoDePreparo(receitaAtualizada.getTempoDePreparo());
        return ResponseEntity.ok(service.inserir(receita));
    }

    @DeleteMapping("/{idReceita}")
    public ResponseEntity<Void> deletarReceita(@PathVariable int idReceita) {
        Receitas receita = service.buscarId(idReceita).orElseThrow(() -> new ResourceNotFoundException("Receita não encontrada com o id: " + idReceita));
        service.deletar(receita.getIdReceitas());
        return ResponseEntity.noContent().build();
        //protocolo http 204 - no Content
    }
}
