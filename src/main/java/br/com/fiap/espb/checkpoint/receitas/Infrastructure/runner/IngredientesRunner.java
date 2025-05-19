package br.com.fiap.espb.checkpoint.receitas.Infrastructure.runner;
import br.com.fiap.espb.checkpoint.receitas.dto.IngredienteDto;
import br.com.fiap.espb.checkpoint.receitas.service.IngredienteService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class IngredientesRunner implements CommandLineRunner {
    private final IngredienteService ingredienteService;
    public IngredientesRunner(IngredienteService ingredienteService) {
        this.ingredienteService = ingredienteService;
    }

    @Override
    public void run(String... args) throws Exception {
        IngredienteDto ingrediente = new IngredienteDto();
        ingrediente.setNome("Queijo");
        ingrediente.setQuantidade(200);

        IngredienteDto salva = ingredienteService.inserir(ingrediente);
        System.out.println("Ingrediente criado: " + salva.getNome());
    }
}

