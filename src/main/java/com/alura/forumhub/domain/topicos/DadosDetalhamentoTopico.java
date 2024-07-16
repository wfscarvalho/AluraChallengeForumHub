package com.alura.forumhub.domain.topicos;

import com.alura.forumhub.domain.usuario.Usuario;

import java.time.LocalDateTime;

public record DadosDetalhamentoTopico(Long id, String titulo, String mensagem, LocalDateTime data_de_criacao, String estado_do_topico, String autor, String curso) {
    public DadosDetalhamentoTopico(Topico topico) {
        this(topico.getId(), topico.getTitulo(), topico.getMensagem(), topico.getData_de_criacao(), topico.getEstado_do_topico(), topico.getAutor(), topico.getCurso());
    }
}
