package bt.com.lucas.ControleFinanceiro.model;

public class Despesa extends Transacao{

    public Despesa(){super();}

    @Override
    public boolean isReceita(){return false;}
}
