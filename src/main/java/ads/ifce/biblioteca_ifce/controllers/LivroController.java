package ads.ifce.biblioteca_ifce.controllers;

import ads.ifce.biblioteca_ifce.models.Livro;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/livro")
public class LivroController {
    private List<Livro> livros = new ArrayList<>();
    @PostMapping
    public Livro cadastrar(@RequestBody Livro livro){
        livros.add(livro);
        return livro;
    }

    @GetMapping
    public List<Livro> listarLivros(){
        return livros;
    }
}
