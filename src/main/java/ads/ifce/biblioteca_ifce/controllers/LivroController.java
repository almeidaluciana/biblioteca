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

    @PutMapping("/{id}")
    public Livro atualizarLivro (@PathVariable Long id, @RequestBody Livro livroAtualizado){
        for (Livro livro : livros){
            if (livro.getId().equals(id)){
                livro.setNome(livroAtualizado.getNome());
                livro.setAno(livroAtualizado.getAno());
                livro.setAutor(livroAtualizado.getAutor());
                return livro;
            }
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public String deletarLivro(@PathVariable Long id){
        for (Livro livro : livros){
            if (livro.getId().equals(id)){
                livros.remove(livro);
                return "Livro removido com sucesso!";
            }
        }
        return "Livro não encontrado";
    }
}
