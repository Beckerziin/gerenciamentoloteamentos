package bancodedados.projeto.gerenciamentoloteamentos.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import bancodedados.projeto.gerenciamentoloteamentos.entity.Engenheiro;

@Repository
public interface EngenheiroRepository extends JpaRepository<Engenheiro,UUID>{
    
}
