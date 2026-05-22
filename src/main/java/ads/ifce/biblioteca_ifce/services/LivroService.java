package ads.ifce.biblioteca_ifce.services;

import ads.ifce.biblioteca_ifce.dto.LivroDTO;
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

    public Livro criar(LivroDTO dto) {
        Livro livro = new Livro();

        livro.setNome(dto.getNome());
        livro.setAno(dto.getAno());
        livro.setAutor(dto.getAutor());

        return repository.save(livro);
    }

    public Livro alterar(Long id, LivroDTO dto) {

        Livro livro = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Livro não encontrado"));

        livro.setNome(dto.getNome());
        livro.setAno(dto.getAno());
        livro.setAutor(dto.getAutor());

        return repository.save(livro);
    }

    public void deletar(Long id) {
        Livro livro = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Livro não encontrado"));

        repository.delete(livro);
    }
}
