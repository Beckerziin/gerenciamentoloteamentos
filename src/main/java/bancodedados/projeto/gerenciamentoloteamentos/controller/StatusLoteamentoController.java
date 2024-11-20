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

import bancodedados.projeto.gerenciamentoloteamentos.controller.DTO.StatusLoteamentoDTO;
import bancodedados.projeto.gerenciamentoloteamentos.entity.StatusLoteamento;
import bancodedados.projeto.gerenciamentoloteamentos.service.StatusLoteamentoService;

@RestController
@RequestMapping("/statusloteamento")
public class StatusLoteamentoController {
    
    private StatusLoteamentoService statusLoteamentoService;

    public StatusLoteamentoController(StatusLoteamentoService statusLoteamentoService) {
        this.statusLoteamentoService = statusLoteamentoService;
    }

    @PostMapping
    public ResponseEntity<StatusLoteamento> createStatusamentoLote (@RequestBody StatusLoteamentoDTO statusLoteamentoDTO){
        var statusLoteamentoId = statusLoteamentoService.createStatusLoteamento(statusLoteamentoDTO);

        return ResponseEntity.created(URI.create("/statusloteamento/" + statusLoteamentoId.toString())).build();
    }

    @GetMapping("/{statusLoteamentoId}")
    public ResponseEntity<StatusLoteamento> getStatusLoteamentobyId(@PathVariable("statusLoteamentoId") String statusLoteamentoId){
        var statusLoteamento = statusLoteamentoService.getStatusLoteamentoById(statusLoteamentoId);
        if(statusLoteamento.isPresent()){
            return ResponseEntity.ok(statusLoteamento.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping(" ")
    public ResponseEntity<List<StatusLoteamento>> listStatusLoteamento() {
        var statusLoteamento = statusLoteamentoService.listStatusLoteamento();

        return ResponseEntity.ok(statusLoteamento);
    }

    @PutMapping("/{statusLoteamentoId}")
    public ResponseEntity<Void> updateStatusLoteamentoById(@PathVariable("statusLoteamentoId") String statusLoteamentoId,
    @RequestBody StatusLoteamentoDTO statusLoteamentoDTO) {
        statusLoteamentoService.updateStatusLoteamentoById(statusLoteamentoId,statusLoteamentoDTO);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{statusLoteamentoId}")
    public ResponseEntity<Void> deleteById(@PathVariable("statusLoteamentoId") String statusLoteamentoId){
        statusLoteamentoService.deleteById(statusLoteamentoId);
        return ResponseEntity.noContent().build();
    }
}
