package br.com.fiap.espb.checkpoint.receitas.mapper;

import br.com.fiap.espb.checkpoint.receitas.domainModel.Receitas;
import br.com.fiap.espb.checkpoint.receitas.dto.ReceitasDto;
import java.util.stream.Collectors;
import java.util.List;


public class ReceitasMapper {
    public static ReceitasDto toDto(Receitas receitas){
        if (receitas == null){
            return null;
        }
        ReceitasDto dto = new ReceitasDto();
        dto.setIdReceita(receitas.getIdReceitas());
        dto.setNome(receitas.getNome());
        dto.setDescricao(receitas.getDescricao());
        dto.setTempoDePreparo(receitas.getTempoDePreparo());

        if (receitas.getIngredientes() != null){
            dto.setIngredientes(receitas.getIngredientes().stream().map(IngredienteMapper::toDto).toList());

        }
        return dto;
    }

    public static Receitas toEntity(ReceitasDto dto){
        if (dto == null){
            return null;
        }
        Receitas receitas = new Receitas();
        receitas.setIdReceitas(dto.getIdReceita());
        receitas.setNome(dto.getNome());
        receitas.setDescricao(dto.getDescricao());
        receitas.setTempoDePreparo(dto.getTempoDePreparo());
        if (dto.getIngredientes() != null){
            receitas.setIngredientes(dto.getIngredientes().stream().map(IngredienteMapper::toEntity).toList());
        }
        return receitas;
    }
}
