package ads.ifce.biblioteca_ifce.services;

import ads.ifce.biblioteca_ifce.models.Livro;
import ads.ifce.biblioteca_ifce.repository.LivroRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivroService {

    private final LivroRepository repository;

    public LivroService(LivroRepository repository) {
        this.repository = repository;
    }

    public List<Livro> listar() {
        return repository.findAll();
    }

    public Livro buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Livro não encontrado"));
    }

    public Livro criar(Livro livro) {
        return repository.save(livro);
    }

    public Livro alterar(Long id, Livro livroAtualizado) {

        Livro livro = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Livro não encontrado"));

        livro.setNome(livroAtualizado.getNome());
        livro.setAno(livroAtualizado.getAno());
        livro.setAutor(livroAtualizado.getAutor());

        return repository.save(livro);
    }

    public void deletar(Long id) {
        Livro livro = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Livro não encontrado"));

        repository.delete(livro);
    }
}
