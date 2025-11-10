package bt.com.lucas.ControleFinanceiro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import bt.com.lucas.ControleFinanceiro.model.Despesa;
import bt.com.lucas.ControleFinanceiro.model.Extrato;
import bt.com.lucas.ControleFinanceiro.model.Receita;
import bt.com.lucas.ControleFinanceiro.model.Transacao;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class FinanceiroController {
    
    private static final String SESSAO_TRANSACOES = "listaTransacoes";

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
    public String salvarReceita(@ModelAttribute("receita") Receita receita, Model model, HttpSession session) {
        
        List<Transacao> transacoes = getTransacoesDaSessao(session);
        transacoes.add(receita);
        session.setAttribute(SESSAO_TRANSACOES, transacoes);

        model.addAttribute("mensagem", "Receita '" + receita.getDescricao() + "' registrada!");
        model.addAttribute("receita", new Receita()); 
        return "receitas";
    }

    // --- MÉTODOS DE DESPESA ---
    @GetMapping("/despesas")
    public String formDespesas(Model model) {
        model.addAttribute("despesa", new Despesa());
        return "despesas";
    }

    @PostMapping("/despesas")
    public String salvarDespesa(@ModelAttribute("despesa") Despesa despesa, Model model, HttpSession session) {
        List<Transacao> transacoes = getTransacoesDaSessao(session);
        transacoes.add(despesa);
        session.setAttribute(SESSAO_TRANSACOES, transacoes);
        model.addAttribute("mensagem", "Despesa '" + despesa.getDescricao() + "' registrada!");
        model.addAttribute("despesa", new Despesa()); 
        return "despesas";
    }

    @GetMapping("/extrato")
    public String extrato(Model model, HttpSession session) {   
        List<Transacao> transacoes = getTransacoesDaSessao(session);
        Extrato extratoModel = new Extrato(transacoes);
        model.addAttribute("extrato", extratoModel);
        return "extrato";
    }

    @SuppressWarnings("unchecked")
    private List<Transacao> getTransacoesDaSessao(HttpSession session) {
        List<Transacao> transacoes = (List<Transacao>) session.getAttribute(SESSAO_TRANSACOES);
        if (transacoes == null) {
            transacoes = new ArrayList<>();
        }
        return transacoes;
    }
}