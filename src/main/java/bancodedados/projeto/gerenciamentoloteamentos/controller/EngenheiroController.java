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

import bancodedados.projeto.gerenciamentoloteamentos.controller.DTO.CreateEngenheiroDTO;
import bancodedados.projeto.gerenciamentoloteamentos.controller.DTO.UpdateEngenheiroDTO;
import bancodedados.projeto.gerenciamentoloteamentos.entity.Engenheiro;
import bancodedados.projeto.gerenciamentoloteamentos.service.EngenheiroService;

@RestController
@RequestMapping("/engenheiro")
public class EngenheiroController {

    private EngenheiroService engenheiroService;

    public EngenheiroController(EngenheiroService engenheiroService) {
        this.engenheiroService = engenheiroService;
    }

    @PostMapping
    public ResponseEntity<Engenheiro> createEngenheiro (@RequestBody CreateEngenheiroDTO createEngenheiroDTO){
        var engenheiroId = engenheiroService.createEngenheiro(createEngenheiroDTO);

        return ResponseEntity.created(URI.create("/engenheiro/" + engenheiroId.toString())).build();
    }

    @GetMapping("/{engheiroId}")
    public ResponseEntity<Engenheiro> getEngenheiroById(@PathVariable("engheiroId") String engheiroId){
        var engenheiro = engenheiroService.getEngenheiroById(engheiroId);
        if(engenheiro.isPresent()){
            return ResponseEntity.ok(engenheiro.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping(" ")
    public ResponseEntity<List<Engenheiro>> listEngenheiros() {
        var engenheiros = engenheiroService.listEngenheiros();

        return ResponseEntity.ok(engenheiros);
    }

    @PutMapping("/{engheiroId}")
    public ResponseEntity<Void> updateEngenheiroById(@PathVariable("engheiroId") String engheiroId,
    @RequestBody UpdateEngenheiroDTO updateEngenheiroDTO) {
        engenheiroService.updateEngenheirpById(engheiroId,updateEngenheiroDTO);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{engheiroId}")
    public ResponseEntity<Void> deleteById(@PathVariable("engheiroId") String engheiroId){
        engenheiroService.deleteById(engheiroId);
        return ResponseEntity.noContent().build();
    }

}
