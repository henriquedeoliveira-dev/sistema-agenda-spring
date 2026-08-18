package com.henriquedeoliveira_dev.sistema_agenda_spring.service;

import com.henriquedeoliveira_dev.sistema_agenda_spring.model.Contato;
import com.henriquedeoliveira_dev.sistema_agenda_spring.repository.ContatoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContatoService {

    private final ContatoRepository repository;

    public ContatoService(ContatoRepository contatoRepository) {
        this.repository = contatoRepository;
    }
    public Contato salvar(Contato contato) {
        return repository.save(contato);
    }
    public List<Contato> listarTodos() {
        return repository.findAll();
    }
    public Contato buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Contato não encontrado com o ID: " + id));
    }
    public List<Contato> buscarPorNome(String nome) {
        return repository.findByNomeContainingIgnoreCase(nome);
    }
    public Contato atualizar(Long id, Contato contatoAtualizado) {
        Contato contatoExistente = buscarPorId(id);

        contatoExistente.setNome(contatoAtualizado.getNome());
        contatoExistente.setTelefone(contatoAtualizado.getTelefone());
        contatoExistente.setEmail(contatoAtualizado.getEmail());

        return repository.save(contatoExistente);
    }
    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Contato não encontrado para exclusão");
        }
        repository.deleteById(id);
    }
}
