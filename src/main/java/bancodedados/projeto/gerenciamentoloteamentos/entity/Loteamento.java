package bancodedados.projeto.gerenciamentoloteamentos.entity;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "loteamento")
public class Loteamento {
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID loteamentoId;

    private String nome;

    private String localizacao;

    private Float areatotal;

    private String fotos;

    private Integer quantidadeLotes;

    private Integer lotesDisppniveis;

    public Loteamento() {
    }

    public Loteamento(UUID loteamentoId, String nome, String localizacao, Float areatotal, String fotos,
            Integer quantidadeLotes, Integer lotesDisppniveis) {
        this.loteamentoId = loteamentoId;
        this.nome = nome;
        this.localizacao = localizacao;
        this.areatotal = areatotal;
        this.fotos = fotos;
        this.quantidadeLotes = quantidadeLotes;
        this.lotesDisppniveis = lotesDisppniveis;
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

    public Integer getLotesDisppniveis() {
        return lotesDisppniveis;
    }

    public void setLotesDisppniveis(Integer lotesDisppniveis) {
        this.lotesDisppniveis = lotesDisppniveis;
    }
}
