package bancodedados.projeto.gerenciamentoloteamentos.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity
@Table(name = "lotadora_socio")
public class LoteadoraSocio {
    
    @EmbeddedId
    private LoteadoraSocioId id;

    @ManyToOne
    @MapsId("loteadoraId")
    @JoinColumn(name = "loteadora_id")
    private Loteadora loteadora;

    @ManyToOne
    @MapsId("socioId")
    @JoinColumn(name = "socio_id")
    private Socio socio;

    public LoteadoraSocio() {
    }

    public LoteadoraSocio(LoteadoraSocioId id, Loteadora loteadora, Socio socio) {
        this.id = id;
        this.loteadora = loteadora;
        this.socio = socio;
    }

    public LoteadoraSocioId getId() {
        return id;
    }

    public void setId(LoteadoraSocioId id) {
        this.id = id;
    }

    public Loteadora getLoteadora() {
        return loteadora;
    }

    public void setLoteadora(Loteadora loteadora) {
        this.loteadora = loteadora;
    }

    public Socio getSocio() {
        return socio;
    }

    public void setSocio(Socio socio) {
        this.socio = socio;
    }


    
}
