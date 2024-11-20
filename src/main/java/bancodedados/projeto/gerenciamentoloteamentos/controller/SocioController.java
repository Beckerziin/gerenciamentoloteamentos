package bancodedados.projeto.gerenciamentoloteamentos.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bancodedados.projeto.gerenciamentoloteamentos.controller.DTO.CreateSocioDTO;
import bancodedados.projeto.gerenciamentoloteamentos.controller.DTO.UpdateSocioDTO;
import bancodedados.projeto.gerenciamentoloteamentos.entity.Socio;
import bancodedados.projeto.gerenciamentoloteamentos.service.SocioService;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/socio")
public class SocioController {

    private SocioService socioService;

    public SocioController(SocioService socioService) {
        this.socioService = socioService;
    }

    @PostMapping
    public ResponseEntity<Socio> createSocio (@RequestBody CreateSocioDTO createSocioDTO){
        var socioId = socioService.createSocio(createSocioDTO);

        return ResponseEntity.created(URI.create("/socio/" + socioId.toString())).build();
    }

    @GetMapping("/{socioId}")
    public ResponseEntity<Socio> getSociobyId(@PathVariable("socioId") String socioId){
        var socio = socioService.getSocioById(socioId);
        if(socio.isPresent()){
            return ResponseEntity.ok(socio.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping(" ")
    public ResponseEntity<List<Socio>> listSocios() {
        var socios = socioService.listSocios();

        return ResponseEntity.ok(socios);
    }
    
    @PutMapping("/{socioId}")
    public ResponseEntity<Void> updateSocioById(@PathVariable("socioId") String socioId,
    @RequestBody UpdateSocioDTO updateSocioDTO) {
        socioService.updateSocioById(socioId,updateSocioDTO);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{socioId}")
    public ResponseEntity<Void> deleteById(@PathVariable("socioId") String socioId){
        socioService.deleteById(socioId);
        return ResponseEntity.noContent().build();
    }
}
