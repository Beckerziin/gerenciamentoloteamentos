package bancodedados.projeto.gerenciamentoloteamentos.entity;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "obra")
public class Obra {
    
    @Id
    @Column (name = "obra_id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID obraId;

    @OneToOne
    @JoinColumn(name = "loteamento_id")
    private Loteamento loteamento;

    @OneToMany(mappedBy = "obra")
    private List<Visita> visitas;

    @Column (name = "data_inicio")
    private Instant dataInicio;

    @Column (name = "data_fim")
    private Instant dataFim;

    @Column (name = "progresso")
    private float progresso;

    @Column (name = "fotos")
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

    public List<Visita> getVisitas() {
        return visitas;
    }

    public void setVisitas(List<Visita> visitas) {
        this.visitas = visitas;
    }

}
