package ads.ifce.biblioteca_ifce.repository;

// Importa a entidade Livro
import ads.ifce.biblioteca_ifce.models.Livro;
// Importa o JpaRepository
import org.springframework.data.jpa.repository.JpaRepository;

// Repository responsável por acessar o banco de dados
public interface LivroRepository extends JpaRepository<Livro, Long> {
    /*
        O Spring cria automaticamente:

        save()
        findAll()
        findById()
        delete()
        etc.
     */
}
