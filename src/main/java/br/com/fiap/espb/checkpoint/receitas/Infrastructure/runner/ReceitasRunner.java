package br.com.fiap.espb.checkpoint.receitas.Infrastructure.runner;
import br.com.fiap.espb.checkpoint.receitas.dto.ReceitasDto;
import br.com.fiap.espb.checkpoint.receitas.service.ReceitasService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ReceitasRunner implements CommandLineRunner {

    private final ReceitasService receitasService;

    public ReceitasRunner(ReceitasService receitasService) {
        this.receitasService = receitasService;
    }

    @Override
    public void run(String... args) throws Exception {
        ReceitasDto receita = new ReceitasDto();
        receita.setNome("Lasanha");
        receita.setDescricao("Lasanha de carne com molho branco");

        ReceitasDto salva = receitasService.inserirDto(receita);
        System.out.println("Receita criada: " + salva.getNome());
    }
}
