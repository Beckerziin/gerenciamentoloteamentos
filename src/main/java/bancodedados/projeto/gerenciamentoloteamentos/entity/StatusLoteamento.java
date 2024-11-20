package bancodedados.projeto.gerenciamentoloteamentos.entity;

import java.util.List;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table (name = "status_loteamento")
public class StatusLoteamento {
    
    @Id
    @Column (name = "status_loteamento_id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID statusLotementoId;

    @OneToMany(mappedBy = "statusLoteamento")
    private List<Loteamento> lotementos;

    private String descricao;

    public StatusLoteamento() {
    }

    public StatusLoteamento(UUID statusLotementoId, List<Loteamento> lotementos, String descricao) {
        this.statusLotementoId = statusLotementoId;
        this.lotementos = lotementos;
        this.descricao = descricao;
    }

    public UUID getStatusLotementoId() {
        return statusLotementoId;
    }

    public void setStatusLotementoId(UUID statusLotementoId) {
        this.statusLotementoId = statusLotementoId;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Loteamento> getLotementos() {
        return lotementos;
    }

    public void setLotementos(List<Loteamento> lotementos) {
        this.lotementos = lotementos;
    }

}
