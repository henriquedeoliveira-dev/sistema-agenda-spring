package com.henriquedeoliveira_dev.sistema_agenda_spring.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ContatoNaoExisteException.class)
    public ResponseEntity<ErroResposta> tratarContatoNaoExiste(ContatoNaoExisteException e) {
        ErroResposta erro = new ErroResposta(
                HttpStatus.NOT_FOUND.value(),
                "Recurso não encontrado",
                e.getMessage()
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
    }
    @ExceptionHandler(AgendaCheiaException.class)
    public ResponseEntity<ErroResposta> tratarAgendaCheia(AgendaCheiaException e) {
        ErroResposta erro = new ErroResposta(
                HttpStatus.BAD_REQUEST.value(),
                "Limite de agenda atingido",
                e.getMessage()
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
    }
    @ExceptionHandler(ListaVaziaException.class)
    public ResponseEntity<ErroResposta> tratarListaVazia(ListaVaziaException e) {
        ErroResposta erro = new ErroResposta(
                HttpStatus.NOT_FOUND.value(),
                "Lista vazia",
                e.getMessage()
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
    }
}
