package bancodedados.projeto.gerenciamentoloteamentos.controller;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bancodedados.projeto.gerenciamentoloteamentos.controller.DTO.CreateEngenheiroDTO;
import bancodedados.projeto.gerenciamentoloteamentos.entity.Engenheiro;
import bancodedados.projeto.gerenciamentoloteamentos.entity.Loteadora;
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

        return ResponseEntity.created(URI.create("/loteadora/" + engenheiroId.toString())).build();
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



}
