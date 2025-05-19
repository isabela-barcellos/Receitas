package br.com.fiap.espb.checkpoint.receitas.dto;

public class IngredienteDto {
    private int idIngrediente;
    private String nome;
    private double quantidade;
    private String medida;
    //getters e setters
    public int getIdIngrediente() {
        return idIngrediente;
    }
    public void setIdIngrediente(int idIngrediente) {
        this.idIngrediente = idIngrediente;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public double getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }
    public String getMedida() {
        return medida;
    }
    public void setMedida(String medida) {
        this.medida = medida;
    }
    //criando o construtor

    public IngredienteDto() {
    }
    public IngredienteDto(int idIngrediente, String nome, double quantidade, String medida) {
        this.idIngrediente = idIngrediente;
        this.nome = nome;
        this.quantidade = quantidade;
        this.medida = medida;

    }
}
