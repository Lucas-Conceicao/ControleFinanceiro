package bt.com.lucas.ControleFinanceiro.model;
import java.util.Date;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_transacao")
public abstract class Transacao{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected long id;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Temporal(TemporalType.DATE)
    protected Date data;

    protected String descricao;
    protected double valor;

    public Transacao(){}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Date getData() {return data;}
    public void setData(Date data) {this.data = data;}
    public String getDescricao() {return descricao;}
    public void setDescricao(String descricao) {this.descricao = descricao;}
    public double getValor() {return valor;}
    public void setValor(double valor) {this.valor = valor;}
    public abstract double aplicarNoSaldo(double saldoAtual);
    public abstract double getValorAssinado();
}
