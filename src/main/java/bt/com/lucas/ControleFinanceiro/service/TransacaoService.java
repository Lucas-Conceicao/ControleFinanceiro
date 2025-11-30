package bt.com.lucas.ControleFinanceiro.service;

import bt.com.lucas.ControleFinanceiro.model.Transacao;
import bt.com.lucas.ControleFinanceiro.repository.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransacaoService {

    @Autowired
    private TransacaoRepository repository;

    public void salvar(Transacao transacao) {
        repository.save(transacao);
    }

    public List<Transacao> listarTodas() {
        return repository.findAll();
    }
}
