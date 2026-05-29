package ads.ifce.biblioteca_ifce.controllers;

import ads.ifce.biblioteca_ifce.dto.LivroDTO;
import ads.ifce.biblioteca_ifce.models.Livro;
import ads.ifce.biblioteca_ifce.services.LivroService;
// Classe usada para controlar resposta HTTP
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Diz que essa classe é um controller REST
@RestController
@CrossOrigin(origins = "*")
// Define rota principal
@RequestMapping("/livro")
public class LivroController {
    // Service da aplicação
    private final LivroService service;

    // Injeção de dependência
    public LivroController(LivroService service) {
        this.service = service;
    }

    // Endpoint GET
    @GetMapping
    public ResponseEntity<List<Livro>> listar() {
        // Chama a camada service
        List<Livro> livros = service.listar();
        // Retorna lista de livros
        return ResponseEntity.ok(livros);
    }

    // Endpoint GET por ID
    @GetMapping("/{id}")
    public ResponseEntity<Livro> buscarPorId(@PathVariable Long id) { // Pega valor da URL
        // Chama a camada service
        Livro livro = service.buscarPorId(id);
        // Retorna livro encontrado
        return ResponseEntity.ok(livro);
    }

    // Endpoint POST
    @PostMapping
    public ResponseEntity<Livro> criar(@Valid @RequestBody LivroDTO dto) { // Converte JSON para objeto Java
        // Chama camada service
        Livro livro = service.criar(dto);

        // Retorna HTTP 201 Created
        return ResponseEntity
                .status(201)
                .body(livro);
    }

    // Endpoint PUT
    @PutMapping("/{id}")
    public ResponseEntity<Livro> alterar(
            // Pega ID da URL
            @PathVariable Long id,
            // Converte JSON para objeto Java
            @RequestBody LivroDTO dto) {

        // Chama a camada de service
        Livro livro = service.alterar(id, dto);
        // Atualiza livro
        return ResponseEntity.ok(livro);
    }

    // Endpoint DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) { // Pega ID da URL
        // Deleta o livro
        service.deletar(id);
        // Retorna HTTP 204 No Content
        return ResponseEntity.noContent().build();
    }
}

