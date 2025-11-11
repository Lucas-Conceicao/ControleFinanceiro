package bt.com.lucas.ControleFinanceiro.model;

import java.util.List; 

public class Extrato {

    private List<Transacao> historicoGeral;
    private double totalReceitas;
    private double totalDespesas;
    private double saldoFinal;

    public Extrato(List<Transacao> historicoGeral) {
        this.historicoGeral = historicoGeral;
        this.totalReceitas = 0;
        this.totalDespesas = 0;
        for (Transacao t : historicoGeral) {
            if (t.isReceita())
                totalReceitas += t.getValor();
            else
                totalDespesas += t.getValor();
        }
        this.saldoFinal = totalReceitas - totalDespesas;
    }

    public List<Transacao> getHistoricoGeral(){return historicoGeral;}
    public double getTotalReceitas(){return totalReceitas; }
    public double getTotalDespesas(){return totalDespesas; }
    public double getSaldoFinal(){return saldoFinal; }
}