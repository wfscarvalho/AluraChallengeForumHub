package com.alura.forumhub.domain.topicos;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizarTopico(@NotNull Long id, String titulo, String mensagem) {
}
