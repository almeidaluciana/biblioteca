package ads.ifce.biblioteca_ifce.controllers;

import ads.ifce.biblioteca_ifce.models.Livro;
import ads.ifce.biblioteca_ifce.services.LivroService;
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
    public List<Livro> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public Livro buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    public Livro criar(@RequestBody Livro livro) {
        return service.criar(livro);
    }

    @PutMapping("/{id}")
    public Livro alterar(@PathVariable Long id,
                         @RequestBody Livro livro) {

        return service.alterar(id, livro);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}

