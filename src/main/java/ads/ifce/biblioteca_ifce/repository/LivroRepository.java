package ads.ifce.biblioteca_ifce.repository;

import ads.ifce.biblioteca_ifce.models.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro, Long> {
}
