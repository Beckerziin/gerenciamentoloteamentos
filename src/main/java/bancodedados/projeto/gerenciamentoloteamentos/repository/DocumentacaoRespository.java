package bancodedados.projeto.gerenciamentoloteamentos.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import bancodedados.projeto.gerenciamentoloteamentos.entity.Documentacao;

@Repository
public interface DocumentacaoRespository extends JpaRepository<Documentacao, UUID>{
    
}
