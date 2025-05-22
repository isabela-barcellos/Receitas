package br.com.fiap.espb.checkpoint.receitas.dto;

import java.util.List;

public class ReceitasDto {
    private int idReceitas;
    private String nome;
    private String descricao;
    private int tempoDePreparo;
    private List<IngredienteDto> ingredientes;


    public int getIdReceitas() {
        return idReceitas;
    }

    public void setIdReceitas(int idReceitas) {
        this.idReceitas = idReceitas;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getTempoDePreparo() {
        return tempoDePreparo;
    }

    public void setTempoDePreparo(int tempoDePreparo) {
        this.tempoDePreparo = tempoDePreparo;
    }

    public List<IngredienteDto> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(List<IngredienteDto> ingredientes) {
        this.ingredientes = ingredientes;
    }

    public ReceitasDto() {
    }

    public ReceitasDto(int idReceitas, String nome, String descricao, int tempoDePreparo, List<IngredienteDto> ingredientes) {
        this.idReceitas = idReceitas;
        this.nome = nome;
        this.descricao = descricao;
        this.tempoDePreparo = tempoDePreparo;
        this.ingredientes = ingredientes;
    }
}

