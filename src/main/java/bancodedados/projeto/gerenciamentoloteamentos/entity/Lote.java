package bancodedados.projeto.gerenciamentoloteamentos.entity;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table
public class Lote {
    
    @Id
    @Column (name = "lote_id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID loteId;

    @ManyToOne
    @JoinColumn(name = "loteamento_id")
    private Loteamento loteamento;

    @ManyToOne
    @JoinColumn(name = "status_lote_id")
    private StatusLote statusLote;

    @Column (name = "area")
    private float Area;

    @Column (name = "valor")
    private float valor;

    @Column (name = "numero")
    private String numero;

    @Column (name = "descricao")
    private String descricao;

    public Lote() {
    }

    public Lote(UUID loteId, float area, float valor, String numero, String descricao) {
        this.loteId = loteId;
        Area = area;
        this.valor = valor;
        this.numero = numero;
        this.descricao = descricao;
    }

    public UUID getLoteId() {
        return loteId;
    }

    public void setLoteId(UUID loteId) {
        this.loteId = loteId;
    }

    public float getArea() {
        return Area;
    }

    public void setArea(float area) {
        Area = area;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Loteamento getLoteamento() {
        return loteamento;
    }

    public void setLoteamento(Loteamento loteamento) {
        this.loteamento = loteamento;
    }

    public StatusLote getStatusLote() {
        return statusLote;
    }

    public void setStatusLote(StatusLote statusLote) {
        this.statusLote = statusLote;
    }
}
