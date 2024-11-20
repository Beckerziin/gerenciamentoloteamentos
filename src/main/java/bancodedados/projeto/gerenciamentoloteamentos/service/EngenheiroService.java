package bancodedados.projeto.gerenciamentoloteamentos.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import bancodedados.projeto.gerenciamentoloteamentos.controller.DTO.CreateEngenheiroDTO;
import bancodedados.projeto.gerenciamentoloteamentos.controller.DTO.UpdateEngenheiroDTO;
import bancodedados.projeto.gerenciamentoloteamentos.entity.Engenheiro;
import bancodedados.projeto.gerenciamentoloteamentos.repository.EngenheiroRepository;

@Service
public class EngenheiroService {
    
    private EngenheiroRepository engenheiroRepository;

    public EngenheiroService(EngenheiroRepository engenheiroRepository) {
        this.engenheiroRepository = engenheiroRepository;
    }

    public UUID createEngenheiro(CreateEngenheiroDTO createEngenheiroDTO){

        //DTO -> ENTITY
        var entity = new Engenheiro(UUID.randomUUID(),
        null, createEngenheiroDTO.nome(),
        createEngenheiroDTO.email(),
        createEngenheiroDTO.telefone(),
        createEngenheiroDTO.cpf(),
        createEngenheiroDTO.crea());

        var engenheiroSaved =  engenheiroRepository.save(entity);

        return engenheiroSaved.getEngenheiroId();
    }

    public Optional<Engenheiro> getEngenheiroById(String engenheiroId){
        return engenheiroRepository.findById(UUID.fromString(engenheiroId));
    }

    public List<Engenheiro> listEngenheiros(){
        return engenheiroRepository.findAll();
    }

    public void updateEngenheirpById(String engenheiroId,UpdateEngenheiroDTO updateEngenheiroDTO){
        var id = UUID.fromString(engenheiroId);
        var engenheiroEntity = engenheiroRepository.findById(id);

        if(engenheiroEntity.isPresent()){
            var engenheiro = engenheiroEntity.get();
            if(updateEngenheiroDTO.nome() != null){
                engenheiro.setNome(updateEngenheiroDTO.nome());
            }

            if(updateEngenheiroDTO.email() != null){
                engenheiro.setEmail(updateEngenheiroDTO.email());
            }

            if(updateEngenheiroDTO.telefone() != null){
                engenheiro.setTelefone(updateEngenheiroDTO.telefone());
            }

            if(updateEngenheiroDTO.cpf() != null){
                engenheiro.setCpf(updateEngenheiroDTO.cpf());
            }

            if(updateEngenheiroDTO.crea() != null){
                engenheiro.setCrea(updateEngenheiroDTO.crea());
            }

            engenheiroRepository.save(engenheiro);
        }
    }

    public void deleteById(String engenheiroId){
        var id = UUID.fromString(engenheiroId);
        var engenheiroExists = engenheiroRepository.existsById(id);

        if(engenheiroExists){
            engenheiroRepository.deleteById(id);
        }

    }
}
