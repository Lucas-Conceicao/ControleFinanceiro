package bt.com.lucas.ControleFinanceiro.model;

public class Receita extends Transacao{

    public Receita(){super();}

    @Override
    public boolean isReceita(){return true;}
}
