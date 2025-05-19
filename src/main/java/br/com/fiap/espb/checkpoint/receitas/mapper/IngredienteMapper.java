package br.com.fiap.espb.checkpoint.receitas.mapper;

import br.com.fiap.espb.checkpoint.receitas.domainModel.Ingrediente;
import br.com.fiap.espb.checkpoint.receitas.dto.IngredienteDto;

public class IngredienteMapper {
    //criando os métodos para mapear
    public static IngredienteDto toDto(Ingrediente ingrediente){
        if (ingrediente == null){
            return null;
        }
        IngredienteDto dto = new IngredienteDto();
        dto.setIdIngrediente(ingrediente.getIdIngrediente());
        dto.setNome(ingrediente.getNome());
        dto.setQuantidade(ingrediente.getQuantidade());
        dto.setMedida(ingrediente.getMedida());
        return dto;
    }
    public static Ingrediente toEntity(IngredienteDto dto){
        if (dto == null){
            return null;
        }
        Ingrediente ingrediente = new Ingrediente();
        ingrediente.setIdIngrediente(dto.getIdIngrediente());
        ingrediente.setNome(dto.getNome());
        ingrediente.setQuantidade(dto.getQuantidade());
        ingrediente.setMedida(dto.getMedida());

        return ingrediente;
    }
}
