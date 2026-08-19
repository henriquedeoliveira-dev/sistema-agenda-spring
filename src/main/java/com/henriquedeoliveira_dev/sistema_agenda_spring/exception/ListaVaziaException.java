package com.henriquedeoliveira_dev.sistema_agenda_spring.exception;

public class ListaVaziaException extends RuntimeException {
    public ListaVaziaException(String message) {
        super(message);
    }
}
