package bt.com.lucas.ControleFinanceiro.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("RECEITA")
public class Receita extends Transacao{

    public Receita(){super();}

    @Override
    public double aplicarNoSaldo(double saldoAtual){
        return saldoAtual + this.valor;
    }

    @Override
    public double getValorAssinado(){
        return this.valor;
    }
}
