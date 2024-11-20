package bancodedados.projeto.gerenciamentoloteamentos.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import bancodedados.projeto.gerenciamentoloteamentos.controller.DTO.StatusLoteDTO;
import bancodedados.projeto.gerenciamentoloteamentos.entity.StatusLote;
import bancodedados.projeto.gerenciamentoloteamentos.repository.StatusLoteRepository;

@Service
public class StatusLoteService {

    private StatusLoteRepository statusLoteRepository;

    public StatusLoteService(StatusLoteRepository statusLoteRepository) {
        this.statusLoteRepository = statusLoteRepository;
    }

    public UUID createStatusLote(StatusLoteDTO statusLoteDTO){

        //DTO -> ENTITY
        var entity = new StatusLote(UUID.randomUUID(),
            statusLoteDTO.descricao());

        var statusLoteSaved =  statusLoteRepository.save(entity);

        return statusLoteSaved.getStatusLoteId();
    }

    public Optional<StatusLote> getStatusLoteById(String statusLoteId){
        return statusLoteRepository.findById(UUID.fromString(statusLoteId));
    }

    public List<StatusLote> listStatusLote(){
        return statusLoteRepository.findAll();
    }
    
    public void updateStatusLoteById(String statusLoteId,StatusLoteDTO statusLoteDTO){
        var id = UUID.fromString(statusLoteId);
        var statusLoteEntity = statusLoteRepository.findById(id);

        if(statusLoteEntity.isPresent()){
            var statusLote = statusLoteEntity.get();
            if(statusLoteDTO.descricao() != null){
                statusLote.setDescricao(statusLoteDTO.descricao());

            statusLoteRepository.save(statusLote);
            }
        }
    }

    public void deleteById(String statusLoteId){
        var id = UUID.fromString(statusLoteId);
        var statusLoteExists = statusLoteRepository.existsById(id);

        if(statusLoteExists){
            statusLoteRepository.deleteById(id);
        }

    }

}
