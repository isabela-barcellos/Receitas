package br.com.fiap.espb.checkpoint.receitas.domainModel;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity

public class Receitas {
    @Id //definindo o id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //criando o autoincrement no banco de dados.
    private int idReceitas;
    private String nome;
    private String descricao;
    private int tempoDePreparo;

    @OneToMany(mappedBy = "receita", cascade = CascadeType.ALL, orphanRemoval = true) //mapenando a chave estrangeira. Referencia dos ingredientes.
    private List<Ingrediente> ingredientes = new ArrayList<>();

    //Criando o get e set para tornar os atributos publicos
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

    public List<Ingrediente> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(List<Ingrediente> ingredientes) {
        this.ingredientes = ingredientes;
    }



}
