package br.com.fiap.espb.checkpoint.receitas.repository;

import br.com.fiap.espb.checkpoint.receitas.domainModel.Ingrediente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredienteRepository extends JpaRepository<Ingrediente, Integer> {
}
