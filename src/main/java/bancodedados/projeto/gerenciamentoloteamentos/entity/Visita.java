package bancodedados.projeto.gerenciamentoloteamentos.entity;

import java.time.Instant;
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
@Table(name = "visita")
public class Visita {
    
    @Id
    @Column (name = "visita_id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID visitaId;

    @Column (name = "data")
    private Instant data;

    @Column (name = "descricao")
    private String descricao;

    @Column (name = "fotos")
    private String fotos;

    @ManyToOne
    @JoinColumn(name = "obra_id")
    private Obra obra;

    @ManyToOne
    @JoinColumn(name = "engenheiro_id")
    private Engenheiro engenheiro;

    public Visita() {
    }

    public Visita(UUID visitaId, Instant data, String descricao, String fotos) {
        this.visitaId = visitaId;
        this.data = data;
        this.descricao = descricao;
        this.fotos = fotos;
    }

    public UUID getVisitaId() {
        return visitaId;
    }

    public void setVisitaId(UUID visitaId) {
        this.visitaId = visitaId;
    }

    public Instant getData() {
        return data;
    }

    public void setData(Instant data) {
        this.data = data;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getFotos() {
        return fotos;
    }

    public void setFotos(String fotos) {
        this.fotos = fotos;
    }

    public Obra getObra() {
        return obra;
    }

    public void setObra(Obra obra) {
        this.obra = obra;
    }

    public Engenheiro getEngenheiro() {
        return engenheiro;
    }

    public void setEngenheiro(Engenheiro engenheiro) {
        this.engenheiro = engenheiro;
    }

}
