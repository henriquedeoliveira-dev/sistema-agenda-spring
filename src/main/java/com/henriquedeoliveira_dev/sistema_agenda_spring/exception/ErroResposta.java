package com.henriquedeoliveira_dev.sistema_agenda_spring.exception;

import java.time.LocalDateTime;

public class ErroResposta {
    private LocalDateTime timestamp;
    private int status;
    private String erro;
    private String mensagem;

    public ErroResposta(int status, String erro, String mensagem) {
        this.timestamp = LocalDateTime.now();
        this.status = status;
        this.erro = erro;
        this.mensagem = mensagem;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public int getStatus() {
        return status;
    }

    public String getErro() {
        return erro;
    }

    public String getMensagem() {
        return mensagem;
    }
}
