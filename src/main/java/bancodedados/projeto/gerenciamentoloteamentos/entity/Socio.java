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
public class Socio {
    
    @Id
    @Column (name = "socio_id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID socioId;

    @Column (name = "nome")
    private String nome;

    @Column (name = "senha")
    private String senha;

    @Column (name = "email")
    private String email;

    @Column (name = "cpf")
    private String cpf;

    @Column (name = "telefone")
    private String telefone;

    @OneToMany(mappedBy = "socio")
    private List<LoteadoraSocio> loteadoraSocios;

    public Socio() {
    }

    public Socio(UUID socioId, String nome, String senha, String email, String cpf, String telefone,
            List<LoteadoraSocio> loteadoraSocios) {
        this.socioId = socioId;
        this.nome = nome;
        this.senha = senha;
        this.email = email;
        this.cpf = cpf;
        this.telefone = telefone;
        this.loteadoraSocios = loteadoraSocios;
    }

    public UUID getSocioId() {
        return socioId;
    }

    public void setSocioId(UUID socioId) {
        this.socioId = socioId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public List<LoteadoraSocio> getLoteadoraSocios() {
        return loteadoraSocios;
    }

    public void setLoteadoraSocios(List<LoteadoraSocio> loteadoraSocios) {
        this.loteadoraSocios = loteadoraSocios;
    }
}
