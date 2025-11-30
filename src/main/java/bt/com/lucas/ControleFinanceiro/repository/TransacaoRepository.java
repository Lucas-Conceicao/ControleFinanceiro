package bt.com.lucas.ControleFinanceiro.repository;

import bt.com.lucas.ControleFinanceiro.model.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransacaoRepository extends JpaRepository<Transacao, Long> {
}
