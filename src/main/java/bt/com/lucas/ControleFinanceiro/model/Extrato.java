package bt.com.lucas.ControleFinanceiro.model;

import java.util.List;
import java.util.ArrayList; 

public class Extrato {

    //lista para Receitas e Despesas
    private List<Transacao> historicoGeral;
    
    //listas filtradas (para os totais e seções)
    private List<Receita> todasReceitas;
    private List<Despesa> todasDespesas;
    
    private double totalReceitas;
    private double totalDespesas;
    private double saldoFinal;

    public Extrato(List<Transacao> historicoGeral) {
        this.historicoGeral = historicoGeral;
        this.todasReceitas = new ArrayList<>();
        this.todasDespesas = new ArrayList<>();
        for (Transacao transacao : historicoGeral) {
            if (transacao instanceof Receita) {
                todasReceitas.add((Receita) transacao);
            } else if (transacao instanceof Despesa) {
                todasDespesas.add((Despesa) transacao);
            }
        }
        this.totalReceitas = todasReceitas.stream().mapToDouble(Transacao::getValor).sum();
        this.totalDespesas = todasDespesas.stream().mapToDouble(Transacao::getValor).sum();
        this.saldoFinal = this.totalReceitas - this.totalDespesas;
    }

    public List<Transacao> getHistoricoGeral() { return historicoGeral; }
    public List<Receita> getTodasReceitas() { return todasReceitas; }
    public List<Despesa> getTodasDespesas() { return todasDespesas; }
    public double getTotalReceitas() { return totalReceitas; }
    public double getTotalDespesas() { return totalDespesas; }
    public double getSaldoFinal() { return saldoFinal; }
}