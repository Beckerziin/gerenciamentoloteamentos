package bancodedados.projeto.gerenciamentoloteamentos.controller;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bancodedados.projeto.gerenciamentoloteamentos.entity.Loteadora;
import bancodedados.projeto.gerenciamentoloteamentos.service.LoteadoraService;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping("/loteadora")
public class LoteadoraController {

    private LoteadoraService loteadoraService;

    public LoteadoraController(LoteadoraService loteadoraService) {
        this.loteadoraService = loteadoraService;
    }

    @PostMapping
    public ResponseEntity<Loteadora> createLoteadora (@RequestBody CreateLoteadoraDTO createLoteadoraDTO){
        var loteadoraId = loteadoraService.createLoteadora(createLoteadoraDTO);

        return ResponseEntity.created(URI.create("/loteadora/" + loteadoraId.toString())).build();
    }

    @GetMapping("/{loteadoraId}")
    public ResponseEntity<Loteadora> getLoteadoraById(@PathVariable("loteadoraId") String loteadoraId){
        var loteadora = loteadoraService.getLoteadoraById(loteadoraId);
        if(loteadora.isPresent()){
            return ResponseEntity.ok(loteadora.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping(" ")
    public ResponseEntity<List<Loteadora>> listLoteadoras() {
        var loteadoras = loteadoraService.listLoteadoras();

        return ResponseEntity.ok(loteadoras);
    }

    @PutMapping("/{loteadoraId}")
    public ResponseEntity<Void> updateLoteadoraById(@PathVariable("loteadoraId") String loteadoraId,
    @RequestBody UpdateLoteadoraDTO updateLoteadoraDTO) {
        loteadoraService.updateLoteadoraById(loteadoraId,updateLoteadoraDTO);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{loteadoraId}")
    public ResponseEntity<Void> deleteById(@PathVariable("loteadoraId") String loteadoraId){
        loteadoraService.deleteById(loteadoraId);
        return ResponseEntity.noContent().build();
    }
    
}
