package bt.com.lucas.ControleFinanceiro.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import bt.com.lucas.ControleFinanceiro.model.Despesa;
import bt.com.lucas.ControleFinanceiro.model.Extrato;
import bt.com.lucas.ControleFinanceiro.model.Receita;
import bt.com.lucas.ControleFinanceiro.model.Transacao;
// Importe do "HttpSession" foi removido

@Controller
public class FinanceiroController {
    
    private List<Transacao> transacoes = new ArrayList<>();

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/receitas")
    public String formReceitas(Model model) {   
        model.addAttribute("receita", new Receita());
        return "receitas";
    }

    @PostMapping("/receitas")
    public String salvarReceita(@ModelAttribute("receita") Receita receita, Model model) {
        this.transacoes.add(receita);
        model.addAttribute("mensagem", "Receita '" + receita.getDescricao() + "' registrada!");
        model.addAttribute("receita", new Receita()); 
        return "receitas";
    }

    @GetMapping("/despesas")
    public String formDespesas(Model model) {
        model.addAttribute("despesa", new Despesa());
        return "despesas";
    }

    @PostMapping("/despesas")

    public String salvarDespesa(@ModelAttribute("despesa") Despesa despesa, Model model) {
  
        this.transacoes.add(despesa);

        model.addAttribute("mensagem", "Despesa '" + despesa.getDescricao() + "' registrada!");
        model.addAttribute("despesa", new Despesa()); 
        return "despesas";
    }

    @GetMapping("/extrato")
    public String extrato(Model model) {   
        Extrato extratoModel = new Extrato(this.transacoes);
        model.addAttribute("extrato", extratoModel);
        return "extrato";
    }
}