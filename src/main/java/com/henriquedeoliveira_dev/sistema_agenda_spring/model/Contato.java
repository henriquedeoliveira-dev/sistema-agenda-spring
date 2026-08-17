package com.henriquedeoliveira_dev.sistema_agenda_spring.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Contatos")
@Data
@NoArgsConstructor

public class Contato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O campo nome não pode ser vazio!")
    @Size(max = 150, message = "O campo nome não pode ser maior que 150 caracteres!")
    @Column(nullable = false, length = 150)
    private String nome;

    @NotBlank(message = "O campo telefone não pode ser vazio!")
    @Size(max = 20, message = "O campo telefone não pode ser maior que 20 caracteres!")
    @Column(nullable = false, length = 20)
    private String telefone;

    @NotBlank(message = "O campo email não pode ser vazio!")
    @Email(message = "insira um endereço de email válido!")
    @Size(max = 255, message = "O campo email não pode ser maior que 255 caracteres!")
    @Column(nullable = false, length = 255)
    private String email;
}
