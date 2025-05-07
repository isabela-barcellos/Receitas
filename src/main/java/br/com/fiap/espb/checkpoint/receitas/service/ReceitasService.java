package br.com.fiap.espb.checkpoint.receitas.service;

import br.com.fiap.espb.checkpoint.receitas.domainModel.Receitas;
import br.com.fiap.espb.checkpoint.receitas.repository.ReceitasRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

@Service
public class ReceitasService {
    private final ReceitasRepository receitasRepo;

    //variavel final precisa de um construtor obrigatoriamente.
    public ReceitasService(ReceitasRepository receitasRepo) {
        this.receitasRepo = receitasRepo;
    }

    //criando CRUD

    //listar
    public List<Receitas> listarTodas(){
      return receitasRepo.findAll();
    }

    //Busca por id
    public Optional<Receitas> buscarId(int idReceita){
        return receitasRepo.findById(idReceita);
    }

    //Inserindo
    public Receitas inserir(Receitas receitas){
        return receitasRepo.save(receitas);
    }

    //Deletando
    public void deletar(int idReceita){
        receitasRepo.deleteById(idReceita);
    }
}
