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
public class Engenheiro {
    
    @Id
    @Column (name = "engenheiro_id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID engenheiroId;

    @OneToMany(mappedBy = "engenheiro")
    private List<Visita> visitas;

    @Column (name = "nome")
    private String nome;

    @Column (name = "email")
    private String email;

    @Column (name = "cpf")
    private String cpf;

    @Column (name = "crea")
    private String crea;

    @Column (name = "telefone")
    private String telefone;

    public Engenheiro() {
    }

    public Engenheiro(UUID engenheiroId, String nome, String email, String cpf, String crea, String telefone) {
        this.engenheiroId = engenheiroId;
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.crea = crea;
        this.telefone = telefone;
    }

    public UUID getEngenheiroId() {
        return engenheiroId;
    }

    public void setEngenheiroId(UUID engenheiroId) {
        this.engenheiroId = engenheiroId;
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCrea() {
        return crea;
    }

    public void setCrea(String crea) {
        this.crea = crea;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public List<Visita> getVisitas() {
        return visitas;
    }

    public void setVisitas(List<Visita> visitas) {
        this.visitas = visitas;
    }
}
