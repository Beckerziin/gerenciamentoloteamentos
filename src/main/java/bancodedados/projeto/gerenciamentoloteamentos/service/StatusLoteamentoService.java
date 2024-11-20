package bancodedados.projeto.gerenciamentoloteamentos.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import bancodedados.projeto.gerenciamentoloteamentos.controller.DTO.StatusLoteamentoDTO;
import bancodedados.projeto.gerenciamentoloteamentos.entity.StatusLoteamento;
import bancodedados.projeto.gerenciamentoloteamentos.repository.StatusLoteamentoRepository;

@Service
public class StatusLoteamentoService {
    
    private StatusLoteamentoRepository statusLoteamentoRepository;

    public StatusLoteamentoService(StatusLoteamentoRepository statusLoteamentoRepository) {
        this.statusLoteamentoRepository = statusLoteamentoRepository;
    }

    public UUID createStatusLoteamento(StatusLoteamentoDTO statusLoteamentoDTO){

        //DTO -> ENTITY
        var entity = new StatusLoteamento(UUID.randomUUID(),
            statusLoteamentoDTO.descricao());

        var statusLoteamentoSaved =  statusLoteamentoRepository.save(entity);

        return statusLoteamentoSaved.getStatusLotementoId();
    }

    public Optional<StatusLoteamento> getStatusLoteamentoById(String statusLoteamentoId){
        return statusLoteamentoRepository.findById(UUID.fromString(statusLoteamentoId));
    }

    public List<StatusLoteamento> listStatusLoteamento(){
        return statusLoteamentoRepository.findAll();
    }
    
    public void updateStatusLoteamentoById(String statusLoteamentoId,StatusLoteamentoDTO statusLoteamentoDTO){
        var id = UUID.fromString(statusLoteamentoId);
        var statusLoteamentoEntity = statusLoteamentoRepository.findById(id);

        if(statusLoteamentoEntity.isPresent()){
            var statusLoteamento = statusLoteamentoEntity.get();
            if(statusLoteamentoDTO.descricao() != null){
                statusLoteamento.setDescricao(statusLoteamentoDTO.descricao());

            statusLoteamentoRepository.save(statusLoteamento);
            }
        }
    }

    public void deleteById(String statusLoteamentoId){
        var id = UUID.fromString(statusLoteamentoId);
        var statusLoteamentoExists = statusLoteamentoRepository.existsById(id);

        if(statusLoteamentoExists){
            statusLoteamentoRepository.deleteById(id);
        }

    }
}
