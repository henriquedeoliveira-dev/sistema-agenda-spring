package com.henriquedeoliveira_dev.sistema_agenda_spring.exception;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ErroResposta {
    private final LocalDateTime timestamp;
    private final int status;
    private final String erro;
    private final String mensagem;

    public ErroResposta(int status, String erro, String mensagem) {
        this.timestamp = LocalDateTime.now();
        this.status = status;
        this.erro = erro;
        this.mensagem = mensagem;
    }
}
