package br.com.fiap.espb.checkpoint.receitas.service;

import br.com.fiap.espb.checkpoint.receitas.domainModel.Ingrediente;
import br.com.fiap.espb.checkpoint.receitas.domainModel.Receitas;
import br.com.fiap.espb.checkpoint.receitas.dto.ReceitasDto;
import br.com.fiap.espb.checkpoint.receitas.mapper.IngredienteMapper;
import br.com.fiap.espb.checkpoint.receitas.mapper.ReceitasMapper;
import br.com.fiap.espb.checkpoint.receitas.repository.ReceitasRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ReceitasService {
    private final ReceitasRepository receitasRepo;

    //variavel final precisa de um construtor obrigatoriamente.
    public ReceitasService(ReceitasRepository receitasRepo) {
        this.receitasRepo = receitasRepo;
    }

    //criando CRUD
    public ReceitasDto inserirDto(ReceitasDto receitas){
        Receitas receita = ReceitasMapper.toEntity(receitas);
        //Relacionar cada igrediente a receita
        if (receitas.getIngredientes() != null){
            receita.getIngredientes().forEach(i -> i.setReceita(receita));
        }
        Receitas salvar = receitasRepo.save(receita);
        return ReceitasMapper.toDto(salvar);
    }

    //listar
    public List<ReceitasDto> listarReceitasDto(){
      List<Receitas> receitas = receitasRepo.findAll();
      return receitas.stream().map(ReceitasMapper::toDto).collect(Collectors.toList());
    }

    //Busca por id
    public ReceitasDto buscarId(int idReceita){
        Receitas receita = receitasRepo.findById(idReceita).orElseThrow(() -> new RuntimeException("Receita " +
                "não encontrada com o id: " + idReceita));
        return ReceitasMapper.toDto(receita);
    }
    //atualizar
    public ReceitasDto atualizar(int idReceita, ReceitasDto receitasDto) {
        Receitas receita = receitasRepo.findById(idReceita).orElseThrow(() -> new RuntimeException("Receita " +
                "não encontrada com o id: " + idReceita));
        receita.setNome(receitasDto.getNome());
        receita.setDescricao(receitasDto.getDescricao());
        receita.setTempoDePreparo(receitasDto.getTempoDePreparo());
        receita.getIngredientes().clear();
        if (receitasDto.getIngredientes() != null) {
            List<Ingrediente> novosIngredientes =
                    receitasDto.getIngredientes().stream().map(IngredienteMapper::toEntity).peek(i -> i.setReceita(receita)).collect(Collectors.toList());
            receita.getIngredientes().addAll(novosIngredientes);
        }
        Receitas atualizada = receitasRepo.save(receita);
        return ReceitasMapper.toDto(atualizada);
    }

    //Deletando
    public void deletar(int idReceita){
        if(!receitasRepo.existsById(idReceita)){
            throw new RuntimeException("Receita não encontrada com o id: " + idReceita);
        }
        receitasRepo.deleteById(idReceita);

    }
}
