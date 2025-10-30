package br.com.bassi.trabalho_facu_lp1.controller;

import br.com.bassi.trabalho_facu_lp1.dto.LocalDTO;
import br.com.bassi.trabalho_facu_lp1.dto.response.LocalResponseDTO;
import br.com.bassi.trabalho_facu_lp1.service.LocalService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/locais")
@RequiredArgsConstructor
public class LocalController {

    private final LocalService localService;

    @PostMapping
    public ResponseEntity<LocalDTO> criarLocal(@RequestBody @Valid LocalDTO localDTO) {
        var criado = localService.criarLocal(localDTO);
        return ResponseEntity.created(URI.create("/locais/" + criado.nome())).body(criado);
    }

    @GetMapping
    public ResponseEntity<List<LocalResponseDTO>> listarLocais() {
        return ResponseEntity.ok(localService.listarLocais());
    }

    @GetMapping("/{id}")
    public ResponseEntity<LocalResponseDTO> buscarLocal(@PathVariable Long id) {
        return localService.buscarLocal(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarLocal(@PathVariable Long id) {
        localService.deletarLocal(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<LocalDTO> editarLocal(@PathVariable Long id, @RequestBody @Valid LocalDTO localDTO) {
        var atualizado = localService.editarLocal(id, localDTO);
        return ResponseEntity.ok(atualizado);
    }
}
