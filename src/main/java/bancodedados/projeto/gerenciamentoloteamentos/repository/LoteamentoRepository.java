package bancodedados.projeto.gerenciamentoloteamentos.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import bancodedados.projeto.gerenciamentoloteamentos.entity.Loteamento;

@Repository
public interface LoteamentoRepository extends JpaRepository<Loteamento,UUID> {

}
