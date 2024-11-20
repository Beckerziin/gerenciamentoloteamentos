package bancodedados.projeto.gerenciamentoloteamentos.controller;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bancodedados.projeto.gerenciamentoloteamentos.controller.DTO.StatusLoteDTO;
import bancodedados.projeto.gerenciamentoloteamentos.entity.StatusLote;
import bancodedados.projeto.gerenciamentoloteamentos.service.StatusLoteService;

@RestController
@RequestMapping("/statuslote")
public class StatusLoteController {

    private StatusLoteService statusLoteService;

    public StatusLoteController(StatusLoteService statusLoteService) {
        this.statusLoteService = statusLoteService;
    }

    @PostMapping
    public ResponseEntity<StatusLote> createStatusLote (@RequestBody StatusLoteDTO statusLoteDTO){
        var statusLoteId = statusLoteService.createStatusLote(statusLoteDTO);

        return ResponseEntity.created(URI.create("/statuslote/" + statusLoteId.toString())).build();
    }

    @GetMapping("/{statusLoteId}")
    public ResponseEntity<StatusLote> getStatusLotebyId(@PathVariable("statusLoteId") String statusLoteId){
        var statusLote = statusLoteService.getStatusLoteById(statusLoteId);
        if(statusLote.isPresent()){
            return ResponseEntity.ok(statusLote.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping(" ")
    public ResponseEntity<List<StatusLote>> listStatusLote() {
        var statusLote = statusLoteService.listStatusLote();

        return ResponseEntity.ok(statusLote);
    }

    @PutMapping("/{statusLoteId}")
    public ResponseEntity<Void> updateStatusLoteById(@PathVariable("statusLoteId") String statusLoteId,
    @RequestBody StatusLoteDTO statusLoteDTO) {
        statusLoteService.updateStatusLoteById(statusLoteId,statusLoteDTO);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{statusLoteId}")
    public ResponseEntity<Void> deleteById(@PathVariable("statusLoteId") String statusLoteId){
        statusLoteService.deleteById(statusLoteId);
        return ResponseEntity.noContent().build();
    }
    
}
