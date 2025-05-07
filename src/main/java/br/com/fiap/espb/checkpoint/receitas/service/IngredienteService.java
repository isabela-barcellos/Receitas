package br.com.fiap.espb.checkpoint.receitas.service;

import br.com.fiap.espb.checkpoint.receitas.domainModel.Ingrediente;
import br.com.fiap.espb.checkpoint.receitas.repository.IngredienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IngredienteService {
    private final IngredienteRepository ingredienteRepo;

    //variavel final precisa de um construtor obrigatoriamente.
    public IngredienteService(IngredienteRepository ingredienteRepo) {
        this.ingredienteRepo = ingredienteRepo;
    }

    //criando CRUD

    //listar
    public List<Ingrediente> listarTodas(){
        return ingredienteRepo.findAll();
    }

    //Busca por id
    public Optional<Ingrediente> buscarId(int idIngrediente){
        return ingredienteRepo.findById(idIngrediente);
    }

    //Inserindo
    public Ingrediente inserir(Ingrediente ingrediente){
        return ingredienteRepo.save(ingrediente);
    }

    //Deletando
    public void deletar(int idIngrediente){
        ingredienteRepo.deleteById(idIngrediente);
    }
}
