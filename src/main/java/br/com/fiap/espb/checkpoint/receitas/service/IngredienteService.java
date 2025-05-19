package br.com.fiap.espb.checkpoint.receitas.service;

import br.com.fiap.espb.checkpoint.receitas.domainModel.Ingrediente;
import br.com.fiap.espb.checkpoint.receitas.dto.IngredienteDto;
import br.com.fiap.espb.checkpoint.receitas.mapper.IngredienteMapper;
import br.com.fiap.espb.checkpoint.receitas.repository.IngredienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class IngredienteService {
    private final IngredienteRepository ingredienteRepo;

    //variavel final precisa de um construtor obrigatoriamente.
    public IngredienteService(IngredienteRepository ingredienteRepo) {
        this.ingredienteRepo = ingredienteRepo;
    }

    //criando CRUD

    //listar
    public List<IngredienteDto> listarTodos(){
        return ingredienteRepo.findAll().stream().map(IngredienteMapper::toDto).collect(Collectors.toList());
    }

    //Busca por id
    public IngredienteDto buscarId(int idIngrediente){
        Ingrediente ingrediente = ingredienteRepo.findById(idIngrediente).orElseThrow(() -> new RuntimeException("Ingrediente não encontrado para o id: " + idIngrediente));
        return IngredienteMapper.toDto(ingrediente);
    }

    //Inserindo
    public IngredienteDto inserir(IngredienteDto ingrediente){
        Ingrediente ingredienteSalvar = IngredienteMapper.toEntity(ingrediente);
        Ingrediente salvar = ingredienteRepo.save(ingredienteSalvar);
        return IngredienteMapper.toDto(salvar);
    }

    //Atualizar
    public IngredienteDto atualizar(int idIngrediente, IngredienteDto ingredienteDto){
        Ingrediente ingrediente = ingredienteRepo.findById(idIngrediente).orElseThrow(() -> new RuntimeException("Ingrediente não encontrado para o id: " + idIngrediente));
        ingrediente.setNome(ingredienteDto.getNome());
        ingrediente.setQuantidade(ingredienteDto.getQuantidade());
        ingrediente.setMedida(ingredienteDto.getMedida());
        Ingrediente atualizada = ingredienteRepo.save(ingrediente);
        return IngredienteMapper.toDto(atualizada);
    }

    //Deletando
    public void deletar(int idIngrediente){
        if (!ingredienteRepo.existsById(idIngrediente)){
            throw new RuntimeException("Ingrediente não encontrado para o id: " + idIngrediente);
        }
        ingredienteRepo.deleteById(idIngrediente);
    }
}
