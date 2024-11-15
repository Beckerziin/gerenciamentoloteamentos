package bancodedados.projeto.gerenciamentoloteamentos.entity;

import java.util.UUID;

import jakarta.persistence.Embeddable;


@Embeddable
public class LoteadoraSocioId {
    
    private UUID loteadoraId;

    private UUID socioId;

    public LoteadoraSocioId() {
    }

    public LoteadoraSocioId(UUID loteadoraId, UUID socioId) {
        this.loteadoraId = loteadoraId;
        this.socioId = socioId;
    }

    public UUID getLoteadoraId() {
        return loteadoraId;
    }

    public void setLoteadoraId(UUID loteadoraId) {
        this.loteadoraId = loteadoraId;
    }

    public UUID getSocioId() {
        return socioId;
    }

    public void setSocioId(UUID socioId) {
        this.socioId = socioId;
    }
}
