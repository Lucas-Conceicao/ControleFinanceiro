package bt.com.lucas.ControleFinanceiro.model;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public abstract class Transacao {

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date data;
    private String descricao;
    private double valor;

    public Transacao(){}

    public Date getData() {return data;}
    public void setData(Date data) {this.data = data;}
    public String getDescricao() {return descricao;}
    public void setDescricao(String descricao) {this.descricao = descricao;}
    public double getValor() {return valor;}
    public void setValor(double valor) {this.valor = valor;}
    public abstract boolean isReceita();
}
