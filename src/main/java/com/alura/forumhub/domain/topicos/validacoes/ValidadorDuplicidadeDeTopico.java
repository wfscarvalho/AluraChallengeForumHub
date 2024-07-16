package com.alura.forumhub.domain.topicos.validacoes;

import com.alura.forumhub.domain.topicos.DadosCadastroTopicos;

public interface ValidadorDuplicidadeDeTopico {

    void validar (DadosCadastroTopicos dados);
}
