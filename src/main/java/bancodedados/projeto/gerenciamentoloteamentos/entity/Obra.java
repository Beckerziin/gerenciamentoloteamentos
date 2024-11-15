package bancodedados.projeto.gerenciamentoloteamentos.entity;

import java.time.Instant;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "obra")
public class Obra {
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID obraId;

    @OneToOne
    @JoinColumn(name = "loteamentoId")
    private Loteamento loteamento;

    private Instant dataInicio;

    private Instant dataFim;

    private float progresso;

    private String fotos;

    public Obra() {
    }

    public Obra(UUID obraId, Instant dataInicio, Instant dataFim, float progresso, String fotos) {
        this.obraId = obraId;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.progresso = progresso;
        this.fotos = fotos;
    }

    public UUID getObraId() {
        return obraId;
    }

    public void setObraId(UUID obraId) {
        this.obraId = obraId;
    }

    public Instant getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Instant dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Instant getDataFim() {
        return dataFim;
    }

    public void setDataFim(Instant dataFim) {
        this.dataFim = dataFim;
    }

    public float getProgresso() {
        return progresso;
    }

    public void setProgresso(float progresso) {
        this.progresso = progresso;
    }

    public String getFotos() {
        return fotos;
    }

    public void setFotos(String fotos) {
        this.fotos = fotos;
    }

    public Loteamento getLoteamento() {
        return loteamento;
    }

    public void setLoteamento(Loteamento loteamento) {
        this.loteamento = loteamento;
    }

}
