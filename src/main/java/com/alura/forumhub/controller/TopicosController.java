package com.alura.forumhub.controller;

import com.alura.forumhub.domain.topicos.DadosCadastroTopicos;
import com.alura.forumhub.domain.topicos.DadosDetalhamentoTopico;
import com.alura.forumhub.domain.topicos.Topico;
import com.alura.forumhub.domain.topicos.TopicoRepository;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import com.alura.forumhub.domain.topicos.DadosAtualizarTopico;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import com.alura.forumhub.domain.topicos.DadosListagemTopico;

@RestController
@RequestMapping("/topicos")
@SecurityRequirement(name = "forumhub")
public class TopicosController {

    @Autowired
    private TopicoRepository topicoRepository;



    @PostMapping
    @Transactional
    public ResponseEntity criarTopicos(@RequestBody @Valid DadosCadastroTopicos dadosCadastroTopicos, UriComponentsBuilder uriComponentsBuilder){
        var topico = new Topico(dadosCadastroTopicos);
        topicoRepository.save(topico);
        System.out.println("teoricamente salvou");
        var uri = uriComponentsBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhamentoTopico(topico));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemTopico>> listarTopicos(@PageableDefault(size = 10, sort = {"titulo"})Pageable pageable){
        var page = topicoRepository.findAllByAtivoTrue(pageable).map(DadosListagemTopico::new);
        System.out.println(page);
        return ResponseEntity.ok(page);

    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizarTopico dados){
        var topico = topicoRepository.getReferenceById(dados.id());
        topico.atualizarInformacoes(dados);

        return ResponseEntity.ok(new DadosDetalhamentoTopico(topico));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deletar(@PathVariable Long id){
//        PROCESSO ONDE SÓ INATIVA
//        var topico = topicoRepository.getReferenceById(id);
//        topico.Excluir(id);

        topicoRepository.deleteById(id);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    @Transactional
    public ResponseEntity detalhar (@PathVariable Long id){
        var topico = topicoRepository.getReferenceById(id);

        return ResponseEntity.ok(new DadosDetalhamentoTopico(topico));
    }
}
