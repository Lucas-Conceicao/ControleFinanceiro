package bt.com.lucas.ControleFinanceiro.controller;

import java.util.List;
import bt.com.lucas.ControleFinanceiro.service.TransacaoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import bt.com.lucas.ControleFinanceiro.model.Despesa;
import bt.com.lucas.ControleFinanceiro.model.Extrato;
import bt.com.lucas.ControleFinanceiro.model.Receita;
import bt.com.lucas.ControleFinanceiro.model.Transacao;

@Controller
public class FinanceiroController {

    private final TransacaoService service;

    public FinanceiroController(TransacaoService service){
        this.service = service;
    }

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
        service.salvar(receita);
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
        service.salvar(despesa);
        model.addAttribute("mensagem", "Despesa '" + despesa.getDescricao() + "' registrada!");
        model.addAttribute("despesa", new Despesa()); 
        return "despesas";
    }

    @GetMapping("/extrato")
    public String extrato(Model model) {
        List<Transacao> transacoesDoBanco = service.listarTodas();
        Extrato extratoModel = new Extrato(transacoesDoBanco);
        model.addAttribute("extrato", extratoModel);
        return "extrato";
    }
}