package bancodedados.projeto.gerenciamentoloteamentos.service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import bancodedados.projeto.gerenciamentoloteamentos.controller.CreateLoteadoraDTO;
import bancodedados.projeto.gerenciamentoloteamentos.controller.UpdateLoteadoraDTO;
import bancodedados.projeto.gerenciamentoloteamentos.entity.Loteadora;
import bancodedados.projeto.gerenciamentoloteamentos.repository.LoteadoraRepository;

@Service
public class LoteadoraService {
    
    private LoteadoraRepository loteadoraRepository;


    public LoteadoraService(LoteadoraRepository loteadoraRepository) {
        this.loteadoraRepository = loteadoraRepository;
    }


    public UUID createLoteadora(CreateLoteadoraDTO createLoteadoraDTO){

        //DTO -> ENTITY
        var entity = new Loteadora(UUID.randomUUID(),
            createLoteadoraDTO.nome(),
            createLoteadoraDTO.email(),
            createLoteadoraDTO.senha(),
            createLoteadoraDTO.cnpj(),
            createLoteadoraDTO.endereco(),
            createLoteadoraDTO.telefone(),
            createLoteadoraDTO.foto(),
            Instant.now(),
            null);

        var loteadoraSaved =  loteadoraRepository.save(entity);

        return loteadoraSaved.getLoteadoraId();
    }

    public Optional<Loteadora> getLoteadoraById(String loteadoraId){
        return loteadoraRepository.findById(UUID.fromString(loteadoraId));
    }

    public List<Loteadora> listLoteadoras(){
        return loteadoraRepository.findAll();
    }

    public void updateLoteadoraById(String loteadoraId,UpdateLoteadoraDTO updateLoteadoraDTO){
        var id = UUID.fromString(loteadoraId);
        var loteadoraEntity = loteadoraRepository.findById(id);

        if(loteadoraEntity.isPresent()){
            var loteadora = loteadoraEntity.get();
            if(updateLoteadoraDTO.nome() != null){
                loteadora.setNome(updateLoteadoraDTO.nome());
            }

            if(updateLoteadoraDTO.senha() != null){
                loteadora.setSenha(updateLoteadoraDTO.senha());
            }

            if(updateLoteadoraDTO.cnpj() != null){
                loteadora.setCnpj(updateLoteadoraDTO.cnpj());
            }

            if(updateLoteadoraDTO.endereco() != null){
                loteadora.setEndereco(updateLoteadoraDTO.endereco());
            }

            if(updateLoteadoraDTO.telefone() != null){
                loteadora.setTelefone(updateLoteadoraDTO.telefone());
            }

            if(updateLoteadoraDTO.foto() != null){
                loteadora.setFoto(updateLoteadoraDTO.foto());
            }

            loteadoraRepository.save(loteadora);
        }
    }

    public void deleteById(String loteadoraId){
        var id = UUID.fromString(loteadoraId);
        var loteadoraExists = loteadoraRepository.existsById(id);

        if(loteadoraExists){
            loteadoraRepository.deleteById(id);
        }

    }
}
