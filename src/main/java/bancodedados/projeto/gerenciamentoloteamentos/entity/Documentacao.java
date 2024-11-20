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
@Table
public class Documentacao {
     
    @Id
    @Column (name = "documentacao_id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID documentacaoId;

    @ManyToOne
    @JoinColumn(name = "loteamento_id")
    private Loteamento loteamento;

    @Column (name = "tipo")
    private String tipo;

    @Column (name = "data_emisssao")
    private Instant dataEmissao;

    @Column (name = "data_vencimento")
    private Instant dataVencimento;

    @Column (name = "arquivo")
    private String arquivo;

    public Documentacao(UUID documentacaoId, Loteamento loteamento, String tipo, Instant dataEmissao,
            Instant dataVencimento, String arquivo) {
        this.documentacaoId = documentacaoId;
        this.loteamento = loteamento;
        this.tipo = tipo;
        this.dataEmissao = dataEmissao;
        this.dataVencimento = dataVencimento;
        this.arquivo = arquivo;
    }

    public Documentacao() {
    }

    public UUID getDocumentacaoId() {
        return documentacaoId;
    }

    public void setDocumentacaoId(UUID documentacaoId) {
        this.documentacaoId = documentacaoId;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Instant getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(Instant dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public Instant getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Instant dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public String getArquivo() {
        return arquivo;
    }

    public void setArquivo(String arquivo) {
        this.arquivo = arquivo;
    }

    public Loteamento getLoteamento() {
        return loteamento;
    }

    public void setLoteamento(Loteamento loteamento) {
        this.loteamento = loteamento;
    }
    
}
