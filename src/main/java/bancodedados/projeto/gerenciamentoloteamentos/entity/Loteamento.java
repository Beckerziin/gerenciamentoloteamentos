package bancodedados.projeto.gerenciamentoloteamentos.entity;

import java.util.List;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "loteamento")
public class Loteamento {
    
    @Id
    @Column (name = "loteamento_id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID loteamentoId;

    @ManyToOne
    @JoinColumn(name = "loteadora_id")
    private Loteadora loteadora;

    @OneToOne(mappedBy = "loteamento")
    private Obra obra;

    @ManyToOne
    @JoinColumn(name = "status_loteamento_id")
    private StatusLoteamento statusLoteamento;

    @OneToMany(mappedBy = "loteamento")
    private List<Lote> lotes;

    @OneToMany(mappedBy = "loteamento")
    private List<Documentacao> documentacoes;

    @Column (name = "nome")
    private String nome;

    @Column (name = "localizacao")
    private String localizacao;

    @Column (name = "area_total")
    private Float areatotal;

    @Column (name = "fotos")
    private String fotos;

    @Column (name = "quantidade_lotes")
    private Integer quantidadeLotes;

    @Column (name = "lotes_disponiveis")
    private Integer lotesDisponiveis;

    public Loteamento() {
    }

    public Loteamento(UUID loteamentoId, String nome, String localizacao, Float areatotal, String fotos,
            Integer quantidadeLotes, Integer lotesDisponiveis) {
        this.loteamentoId = loteamentoId;
        this.nome = nome;
        this.localizacao = localizacao;
        this.areatotal = areatotal;
        this.fotos = fotos;
        this.quantidadeLotes = quantidadeLotes;
        this.lotesDisponiveis = lotesDisponiveis;
    }

    public UUID getLoteamentoId() {
        return loteamentoId;
    }

    public void setLoteamentoId(UUID loteamentoId) {
        this.loteamentoId = loteamentoId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public Float getAreatotal() {
        return areatotal;
    }

    public void setAreatotal(Float areatotal) {
        this.areatotal = areatotal;
    }

    public String getFotos() {
        return fotos;
    }

    public void setFotos(String fotos) {
        this.fotos = fotos;
    }

    public Integer getQuantidadeLotes() {
        return quantidadeLotes;
    }

    public void setQuantidadeLotes(Integer quantidadeLotes) {
        this.quantidadeLotes = quantidadeLotes;
    }

    public Integer getLotesDisponiveis() {
        return lotesDisponiveis;
    }

    public void setLotesDisponiveis(Integer lotesDisponiveis) {
        this.lotesDisponiveis = lotesDisponiveis;
    }

    public Loteadora getLoteadora() {
        return loteadora;
    }

    public void setLoteadora(Loteadora loteadora) {
        this.loteadora = loteadora;
    }

    public Obra getObra() {
        return obra;
    }

    public void setObra(Obra obra) {
        this.obra = obra;
    }

    public StatusLoteamento getStatusLoteamento() {
        return statusLoteamento;
    }

    public void setStatusLoteamento(StatusLoteamento statusLoteamento) {
        this.statusLoteamento = statusLoteamento;
    }

    public List<Lote> getLotes() {
        return lotes;
    }

    public void setLotes(List<Lote> lotes) {
        this.lotes = lotes;
    }
    
}
