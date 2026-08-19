package com.henriquedeoliveira_dev.sistema_agenda_spring.exception;

public class ContatoNaoExisteException extends RuntimeException {
    public ContatoNaoExisteException(String message) {
        super(message);
    }
}
