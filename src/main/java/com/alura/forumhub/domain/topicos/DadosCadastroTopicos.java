package com.alura.forumhub.domain.topicos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DadosCadastroTopicos(

        @NotBlank
        String titulo,

        @NotBlank
        String mensagem,

        @NotNull
        LocalDateTime data_de_criacao,

        @NotBlank
        String estado_do_topico,

        @NotNull
        String autor,

        @NotBlank
        String curso) {
}
