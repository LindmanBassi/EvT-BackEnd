package br.com.bassi.trabalho_facu_lp1.controller;

import br.com.bassi.trabalho_facu_lp1.dto.LocalDTO;
import br.com.bassi.trabalho_facu_lp1.dto.response.LocalResponseDTO;
import br.com.bassi.trabalho_facu_lp1.service.LocalService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/locais")
@RequiredArgsConstructor
public class LocalController {

    private final LocalService localService;

    //@PreAuthorize("!hasAuthority('VISITANTE')")
    @PostMapping
    public ResponseEntity<LocalDTO> criarLocal(@RequestBody @Valid LocalDTO localDTO) {
        var criado = localService.criarLocal(localDTO);
        return ResponseEntity.created(URI.create("/locais/" + criado.nome())).body(criado);
    }
    //@PreAuthorize("!hasAuthority('VISITANTE')")
    @GetMapping
    public ResponseEntity<List<LocalResponseDTO>> listarLocais() {
        return ResponseEntity.ok(localService.listarLocais());
    }
    //@PreAuthorize("!hasAuthority('VISITANTE')")
    @GetMapping("/{id}")
    public ResponseEntity<LocalResponseDTO> buscarLocal(@PathVariable Long id) {
        return localService.buscarLocal(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    //@PreAuthorize("!hasAuthority('VISITANTE')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarLocal(@PathVariable Long id) {
        localService.deletarLocal(id);
        return ResponseEntity.noContent().build();
    }
    //@PreAuthorize("!hasAuthority('VISITANTE')")
    @PutMapping("/{id}")
    public ResponseEntity<LocalDTO> editarLocal(@PathVariable Long id, @RequestBody @Valid LocalDTO localDTO) {
        var atualizado = localService.editarLocal(id, localDTO);
        return ResponseEntity.ok(atualizado);
    }
}
