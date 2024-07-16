package com.alura.forumhub.domain.topicos;

import com.alura.forumhub.domain.topicos.validacoes.ValidadorDuplicidadeDeTopico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FeedDeTopicos {
    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private List<ValidadorDuplicidadeDeTopico> validadores;

    public DadosDetalhamentoTopico criar(DadosCadastroTopicos dados){

    }
}
