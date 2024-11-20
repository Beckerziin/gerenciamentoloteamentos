package bancodedados.projeto.gerenciamentoloteamentos.repository;

import bancodedados.projeto.gerenciamentoloteamentos.entity.LoteadoraSocioId;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import bancodedados.projeto.gerenciamentoloteamentos.entity.LoteadoraSocio;

@Repository
public interface LoteadoraSocioRepository extends JpaRepository<LoteadoraSocio,LoteadoraSocioId> {

}
