package ads.ifce.biblioteca_ifce.controllers;

import ads.ifce.biblioteca_ifce.dto.LivroDTO;
import ads.ifce.biblioteca_ifce.models.Livro;
import ads.ifce.biblioteca_ifce.services.LivroService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livro")
public class LivroController {

    private final LivroService service;

    public LivroController(LivroService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Livro>> listar() {
        List<Livro> livros = service.listar();
        return ResponseEntity.ok(livros);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Livro> buscarPorId(@PathVariable Long id) {
        Livro livro = service.buscarPorId(id);
        return ResponseEntity.ok(livro);
    }

    @PostMapping
    public ResponseEntity<Livro> criar(@RequestBody LivroDTO dto) {

        Livro livro = service.criar(dto);

        return ResponseEntity
                .status(201)
                .body(livro);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Livro> alterar(@PathVariable Long id,
                                         @RequestBody LivroDTO dto) {
        Livro livro = service.alterar(id, dto);
        return ResponseEntity.ok(livro);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}

