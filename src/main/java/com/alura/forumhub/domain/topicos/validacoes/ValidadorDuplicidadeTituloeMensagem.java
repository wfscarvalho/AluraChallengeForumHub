package com.alura.forumhub.domain.topicos.validacoes;

import com.alura.forumhub.domain.ValidacaoException;
import com.alura.forumhub.domain.topicos.DadosCadastroTopicos;
import com.alura.forumhub.domain.topicos.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("Valida duplicidade Titulo e mensagem")
public class ValidadorDuplicidadeTituloeMensagem  implements ValidadorDuplicidadeDeTopico{

    @Autowired
    private TopicoRepository repository;

    @Override
    public void validar(DadosCadastroTopicos dados) {
        var outroTopico = repository.existsByMensagemAndTitulo(dados.mensagem(),dados.titulo());
        System.out.println(outroTopico);
        if (outroTopico){
            throw new ValidacaoException("Topico já existe");
        }
    }
}
