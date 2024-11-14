package bancodedados.projeto.gerenciamentoloteamentos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import bancodedados.projeto.gerenciamentoloteamentos.entity.Loteadora;

import java.util.UUID;

@Repository
public interface LoteadoraRepository extends JpaRepository<Loteadora, UUID>{
    
}
