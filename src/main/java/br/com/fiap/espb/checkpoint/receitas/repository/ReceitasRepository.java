package br.com.fiap.espb.checkpoint.receitas.repository;

//criando repositorio
import br.com.fiap.espb.checkpoint.receitas.domainModel.Receitas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReceitasRepository extends JpaRepository <Receitas, Integer> {


}
