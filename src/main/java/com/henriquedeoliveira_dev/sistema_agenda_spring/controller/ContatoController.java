package com.henriquedeoliveira_dev.sistema_agenda_spring.controller;

import com.henriquedeoliveira_dev.sistema_agenda_spring.model.Contato;
import com.henriquedeoliveira_dev.sistema_agenda_spring.service.ContatoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contatos")
@Tag(name = "Contatos", description = "Endpoints para gerenciamento da agenda de contatos")
public class ContatoController {
    private final ContatoService contatoService;

    public ContatoController(ContatoService contatoService) {
        this.contatoService = contatoService;
    }

    @PostMapping
    @Operation(summary = "salva contato")
    public ResponseEntity<Contato> salvar(@Valid @RequestBody Contato contato) {
        Contato novoContato = contatoService.salvar(contato);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoContato);
    }

    @GetMapping
    @Operation(summary = "lista todos os contatos")
    public ResponseEntity<List<Contato>> listarTodos() {
        return ResponseEntity.ok(contatoService.listarTodos());
    }

    @GetMapping("/{id}")
    @Operation(summary = "busca contato por ID")
    public ResponseEntity<Contato> buscarPorId(@PathVariable Long id) {
        Contato contato = contatoService.buscarPorId(id);
        return ResponseEntity.ok(contato);
    }

    @GetMapping("/busca")
    @Operation(summary = "busca contato por nome")
    public ResponseEntity<List<Contato>> buscarPorNome(@RequestParam String nome) {
        return ResponseEntity.ok(contatoService.buscarPorNome(nome));
    }

    @PutMapping("/{id}")
    @Operation(summary = "atualiza um contato")
    public ResponseEntity<Contato> atualizar(@PathVariable Long id, @Valid @RequestBody Contato novoContato) {
        Contato contatoSalvo = contatoService.atualizar(id, novoContato);
        return ResponseEntity.ok(contatoSalvo);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "remove um contato pelo ID")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        contatoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
