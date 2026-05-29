package ads.ifce.biblioteca_ifce.services;

import ads.ifce.biblioteca_ifce.dto.LivroDTO;
import ads.ifce.biblioteca_ifce.models.Livro;
import ads.ifce.biblioteca_ifce.repository.LivroRepository;
import org.springframework.stereotype.Service;

import java.util.List;

// Diz ao Spring que essa classe é uma camada de regra de negócio
@Service
public class LivroService {
    // Repository usado para acessar banco
    private final LivroRepository repository;

    /*
        Injeção de dependência via construtor

        O Spring cria automaticamente o repository
        e injeta aqui.
     */
    public LivroService(LivroRepository repository) {
        this.repository = repository;
    }

    // Lista todos os livros
    public List<Livro> listar() {
        // Busca todos os livros no banco
        return repository.findAll();
    }

    // Busca livro por id
    public Livro buscarPorId(Long id) {
        // Busca no banco
        return repository.findById(id)
                // Se não encontrar lança erro
                .orElseThrow(() -> new RuntimeException("Livro não encontrado"));
    }

    // Metodo responsável por salvar livro
    public Livro criar(LivroDTO dto) {
        // Cria novo objeto Livro
        Livro livro = new Livro();

        // Atribui dados do DTO para o objeto livro criado
        livro.setNome(dto.getNome());
        livro.setAno(dto.getAno());
        livro.setAutor(dto.getAutor());

        // Salva no banco
        return repository.save(livro);
    }

    // Atualiza livro
    public Livro alterar(Long id, LivroDTO dto) {

        // Busca livro existente
        Livro livro = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Livro não encontrado"));

        // Atualiza dados
        livro.setNome(dto.getNome());
        livro.setAno(dto.getAno());
        livro.setAutor(dto.getAutor());

        // Salva atualização
        return repository.save(livro);
    }

    // Deleta livro
    public void deletar(Long id) {
        // Busca livro
        Livro livro = repository.findById(id)
                // Se não encontrar lança erro
                .orElseThrow(() -> new RuntimeException("Livro não encontrado"));

        // Remove do banco
        repository.delete(livro);
    }
}
