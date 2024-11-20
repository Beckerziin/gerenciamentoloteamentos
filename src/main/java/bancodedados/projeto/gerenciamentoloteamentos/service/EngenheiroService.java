package bancodedados.projeto.gerenciamentoloteamentos.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import bancodedados.projeto.gerenciamentoloteamentos.controller.DTO.CreateEngenheiroDTO;
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
        createEngenheiroDTO.nome(),
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
}
