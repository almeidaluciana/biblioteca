package ads.ifce.biblioteca_ifce.models;

// Importa as anotações do JPA
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

// Importa as anotações do Lombok
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// Diz ao Spring e ao JPA que essa classe representa uma tabela no banco
@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Livro {
    // Define que o atributo id é a chave primária da tabela
    @Id
    // Define que o id será gerado automaticamente pelo banco
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private int ano;
    private String autor;
}
