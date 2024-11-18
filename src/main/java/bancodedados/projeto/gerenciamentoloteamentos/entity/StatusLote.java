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
@Table
public class StatusLote {
    
    @Id
    @Column (name = "status_lote_id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID statusLoteId;

    @Column (name = "descricao")
    private String descricao;

    @OneToMany
    private List<Lote> lotes;

    public StatusLote() {
    }

    public StatusLote(UUID statusLoteId, String descricao) {
        this.statusLoteId = statusLoteId;
        this.descricao = descricao;
    }

    public UUID getStatusLoteId() {
        return statusLoteId;
    }

    public void setStatusLoteId(UUID statusLoteId) {
        this.statusLoteId = statusLoteId;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Lote> getLotes() {
        return lotes;
    }

    public void setLotes(List<Lote> lotes) {
        this.lotes = lotes;
    }
}
