package bancodedados.projeto.gerenciamentoloteamentos.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import bancodedados.projeto.gerenciamentoloteamentos.controller.DTO.CreateSocioDTO;
import bancodedados.projeto.gerenciamentoloteamentos.controller.DTO.UpdateSocioDTO;
import bancodedados.projeto.gerenciamentoloteamentos.entity.Socio;
import bancodedados.projeto.gerenciamentoloteamentos.repository.SocioRepository;

@Service
public class SocioService {
    
    private SocioRepository socioRepository;


    public SocioService(SocioRepository socioRepository) {
        this.socioRepository = socioRepository;
    }


    public UUID createSocio(CreateSocioDTO createSocioDTO){

        //DTO -> ENTITY
        var entity = new Socio(UUID.randomUUID(),
            createSocioDTO.nome(),
            createSocioDTO.senha(),
            createSocioDTO.email(),
            createSocioDTO.cpf(),
            createSocioDTO.telefone());

        var socioSaved =  socioRepository.save(entity);

        return socioSaved.getSocioId();
    }

    public Optional<Socio> getSocioById(String socioId){
        return socioRepository.findById(UUID.fromString(socioId));
    }

    public List<Socio> listSocios(){
        return socioRepository.findAll();
    }

    public void updateSocioById(String socioId,UpdateSocioDTO updateSocioDTO){
        var id = UUID.fromString(socioId);
        var socioEntity = socioRepository.findById(id);

        if(socioEntity.isPresent()){
            var socio = socioEntity.get();
            if(updateSocioDTO.nome() != null){
                socio.setNome(updateSocioDTO.nome());
            }

            if(updateSocioDTO.senha() != null){
                socio.setSenha(updateSocioDTO.senha());
            }
            if(updateSocioDTO.telefone() != null){
                socio.setTelefone(updateSocioDTO.telefone());
            }
            socioRepository.save(socio);
        }
    }

    public void deleteById(String socioId){
        var id = UUID.fromString(socioId);
        var socioExists = socioRepository.existsById(id);

        if(socioExists){
            socioRepository.deleteById(id);
        }

    }
}
