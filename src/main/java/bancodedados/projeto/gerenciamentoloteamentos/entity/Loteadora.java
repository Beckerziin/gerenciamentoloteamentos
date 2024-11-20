package bancodedados.projeto.gerenciamentoloteamentos.entity;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "loteadora")
public class Loteadora {
    
    @Id
    @Column (name = "loteadora_id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID loteadoraId;
    
    @Column (name = "nome")
    private String nome;

    @Column (name = "email")
    private String email;

    @Column (name = "senha")
    private String senha;

    @Column (name = "cnpj")
    private String cnpj;
    
    @Column (name = "endereco")
    private String endereco;

    @Column (name = "telefone")
    private String telefone;

    @Column (name = "foto")
    private String foto;

    @CreationTimestamp
    private Instant creationTimeStamp;

    @UpdateTimestamp
    private Instant updateTimeStamp;

    @OneToMany(mappedBy = "loteadora")
    private List<Loteamento> loteamentos;

    @OneToMany(mappedBy = "loteadora")
    private List<LoteadoraSocio> loteadoraSocios;

    public Loteadora() {
    }

    public Loteadora(UUID loteadoraId, String nome, String email, String senha, String cnpj, String endereco,
            String telefone, String foto, Instant creationTimeStamp, Instant updateTimeStamp) {
        this.loteadoraId = loteadoraId;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.cnpj = cnpj;
        this.endereco = endereco;
        this.telefone = telefone;
        this.foto = foto;
        this.creationTimeStamp = creationTimeStamp;
        this.updateTimeStamp = updateTimeStamp;
    }

    public UUID getLoteadoraId() {
        return loteadoraId;
    }

    public void setLoteadoraId(UUID loteadoraId) {
        this.loteadoraId = loteadoraId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public Instant getCreationTimeStamp() {
        return creationTimeStamp;
    }

    public void setCreationTimeStamp(Instant creationTimeStamp) {
        this.creationTimeStamp = creationTimeStamp;
    }

    public Instant getUpdateTimeStamp() {
        return updateTimeStamp;
    }

    public void setUpdateTimeStamp(Instant updateTimeStamp) {
        this.updateTimeStamp = updateTimeStamp;
    }

    public List<Loteamento> getLoteamentos() {
        return loteamentos;
    }

    public void setLoteamentos(List<Loteamento> loteamentos) {
        this.loteamentos = loteamentos;
    }

    public List<LoteadoraSocio> getLoteadoraSocios() {
        return loteadoraSocios;
    }

    public void setLoteadoraSocios(List<LoteadoraSocio> loteadoraSocios) {
        this.loteadoraSocios = loteadoraSocios;
    }

}
