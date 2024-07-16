package com.alura.forumhub.domain.topicos;

import com.alura.forumhub.domain.usuario.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity(name = "Topico")
@Table(name = "topicos")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String titulo;
    private String mensagem;
    private LocalDateTime data_de_criacao;
    private String estado_do_topico;
    private String autor;
    private String curso;
    private boolean ativo;


    public Topico(DadosCadastroTopicos dadosCadastroTopicos) {
        this.titulo = dadosCadastroTopicos.titulo();
        this.mensagem = dadosCadastroTopicos.mensagem();
        this.data_de_criacao = dadosCadastroTopicos.data_de_criacao();
        this.estado_do_topico = dadosCadastroTopicos.estado_do_topico();
        this.autor = dadosCadastroTopicos.autor();
        this.curso = dadosCadastroTopicos.curso();
        this.ativo = true;

    }

    public void Excluir(Long id) {
        this.ativo = false;
    }

    public void atualizarInformacoes(DadosAtualizarTopico dados) {
        if (dados.titulo()!= null){
            this.titulo = dados.titulo();

        }
        if (dados.mensagem()!= null){
            this.mensagem = dados.mensagem();
        }

    }
}
