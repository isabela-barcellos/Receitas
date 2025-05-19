package br.com.fiap.espb.checkpoint.receitas.controllers;

import br.com.fiap.espb.checkpoint.receitas.domainModel.Receitas;
import br.com.fiap.espb.checkpoint.receitas.dto.ReceitasDto;
import br.com.fiap.espb.checkpoint.receitas.exception.ResourceNotFoundException;
import br.com.fiap.espb.checkpoint.receitas.mapper.ReceitasMapper;
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
    //Criação do banco de dados


//trocando idReceita por id
    @PostMapping
    public ResponseEntity<ReceitasDto> criarReceita(@RequestBody ReceitasDto receitasDto) {
        ReceitasDto novaReceita = service.inserirDto(receitasDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaReceita);
    }
    //201 - protocolo http criado
    @GetMapping
    public ResponseEntity<List<ReceitasDto>> listarReceitasDto() {
    return ResponseEntity.ok(service.listarReceitasDto());
    }

    @GetMapping("/{idReceita}")
    public ResponseEntity<ReceitasDto> buscarId(@PathVariable int idReceita) {
        ReceitasDto receitaDto = service.buscarId(idReceita);
        return ResponseEntity.ok(receitaDto);
    }

    @PutMapping("/{idReceita}")
    public ResponseEntity<ReceitasDto> atualizarReceita(@PathVariable int idReceita,
                                                      @RequestBody ReceitasDto receitaAtualizada) {
        ReceitasDto receitaDto = service.atualizar(idReceita, receitaAtualizada);
        return ResponseEntity.ok(receitaDto);
        //protocolo http 200 - ok
    }

    @DeleteMapping("/{idReceita}")
    public ResponseEntity<Void> deletarReceita(@PathVariable int idReceita) {
      service.deletar(idReceita);
      return ResponseEntity.noContent().build();
    }
}
