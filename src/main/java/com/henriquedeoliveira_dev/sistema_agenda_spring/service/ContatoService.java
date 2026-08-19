package com.henriquedeoliveira_dev.sistema_agenda_spring.service;

import com.henriquedeoliveira_dev.sistema_agenda_spring.exception.AgendaCheiaException;
import com.henriquedeoliveira_dev.sistema_agenda_spring.exception.ContatoNaoExisteException;
import com.henriquedeoliveira_dev.sistema_agenda_spring.exception.ListaVaziaException;
import com.henriquedeoliveira_dev.sistema_agenda_spring.model.Contato;
import com.henriquedeoliveira_dev.sistema_agenda_spring.repository.ContatoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContatoService {
    private static final long LIMITE_MAXIMO_CONTATOS = 2;
    private final ContatoRepository repository;

    public ContatoService(ContatoRepository contatoRepository) {
        this.repository = contatoRepository;
    }
    public Contato salvar(Contato contato) {
        if (repository.count() >= LIMITE_MAXIMO_CONTATOS) {
            throw new AgendaCheiaException("Não é possível adicionar novos contatos, pois a agenda está cheia!");
        }
        return repository.save(contato);
    }
    public List<Contato> listarTodos() {
        List<Contato> contatos = repository.findAll();
        if (contatos.isEmpty()) {
            throw new ListaVaziaException("Não foi encontrado nenhum contato na agenda!");
        }
        return contatos;
    }
    public Contato buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ContatoNaoExisteException("Contato não encontrado com o ID: " + id));
    }
    public List<Contato> buscarPorNome(String nome) {
        List<Contato> contato = repository.findByNomeContainingIgnoreCase(nome);
        if (contato.isEmpty()) {
            throw new ContatoNaoExisteException("O contato " + nome + " não foi encontrado!");
        }
        return contato;
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
            throw new ContatoNaoExisteException("Contato não encontrado para exclusão");
        }
        repository.deleteById(id);
    }
}
