package ads.ifce.biblioteca_ifce.controllers;

import ads.ifce.biblioteca_ifce.models.Livro;
import ads.ifce.biblioteca_ifce.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livro")
public class LivroController {
    @Autowired
    private LivroRepository repository;

    @PostMapping
    public Livro cadastrar(@RequestBody Livro livro){
        return repository.save(livro);
    }

    @GetMapping
    public List<Livro> listarLivros(){
        return repository.findAll();
    }

    @PutMapping("/{id}")
    public Livro atualizarLivro (@PathVariable Long id, @RequestBody Livro livroAtualizado){
        Livro livro = repository.findById(id).orElse(null);
        if (livro != null){
            livro.setNome(livroAtualizado.getNome());
            livro.setAno(livroAtualizado.getAno());
            livro.setAutor(livroAtualizado.getAutor());

            return repository.save(livro);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public String deletarLivro(@PathVariable Long id){
        repository.deleteById(id);
        return "Livro removido com sucesso!";
    }
}
