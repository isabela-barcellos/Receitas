package br.com.fiap.espb.checkpoint.receitas.controllers;

import br.com.fiap.espb.checkpoint.receitas.dto.IngredienteDto;
import br.com.fiap.espb.checkpoint.receitas.dto.ReceitasDto;
import br.com.fiap.espb.checkpoint.receitas.service.IngredienteService;
import br.com.fiap.espb.checkpoint.receitas.service.ReceitasService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class HomeWebController {

    private final ReceitasService receitasService;
    private final IngredienteService ingredienteService;

    public HomeWebController(ReceitasService receitasService, IngredienteService ingredienteService) {
        this.receitasService = receitasService;
        this.ingredienteService = ingredienteService;
    }

    @GetMapping
    public String home(Model model) {
        model.addAttribute("receitas", receitasService.listarReceitasDto());
        model.addAttribute("ingredientes", ingredienteService.listarTodos());
        return "home";
    }

    // RECEITA

    @GetMapping("/receitas/nova")
    public String novaReceitaForm(Model model) {
        model.addAttribute("receitas", new ReceitasDto());
        model.addAttribute("listarTodos", ingredienteService.listarTodos()); // Adiciona ingredientes para o select
        return "form-receitas";
    }

    @PostMapping("/receitas")
    public String salvarReceita(@ModelAttribute("receitas") ReceitasDto receitaDto) {
        receitasService.inserirDto(receitaDto);
        return "redirect:/";
    }

    @GetMapping("/receitas/editar/{id}")
    public String editarReceita(@PathVariable int id, Model model) {
        ReceitasDto receitaDto = receitasService.buscarId(id);
        if (receitaDto == null) {
            return "redirect:/";
        }
        model.addAttribute("receitas", receitaDto);
        model.addAttribute("listarTodos", ingredienteService.listarTodos()); // Adiciona ingredientes para o select
        return "form-receitas";
    }

    @GetMapping("/receitas/excluir/{id}")
    public String excluirReceita(@PathVariable int id) {
        receitasService.deletar(id);
        return "redirect:/";
    }

    // INGREDIENTE

    @GetMapping("/ingredientes/novo")
    public String novoIngredienteForm(Model model) {
        model.addAttribute("ingrediente", new IngredienteDto());
        return "form-ingrediente";
    }

    @PostMapping("/ingredientes")
    public String salvarIngrediente(@ModelAttribute("ingrediente") IngredienteDto ingredienteDto) {
        ingredienteService.inserir(ingredienteDto);
        return "redirect:/";
    }

    @GetMapping("/ingredientes/editar/{id}")
    public String editarIngrediente(@PathVariable int id, Model model) {
        IngredienteDto ingredienteDto = ingredienteService.buscarId(id);
        if (ingredienteDto == null) {
            return "redirect:/";
        }
        model.addAttribute("ingrediente", ingredienteDto);
        return "form-ingrediente";
    }

    @GetMapping("/ingredientes/excluir/{id}")
    public String excluirIngrediente(@PathVariable int id) {
        ingredienteService.deletar(id);
        return "redirect:/";
    }
}
