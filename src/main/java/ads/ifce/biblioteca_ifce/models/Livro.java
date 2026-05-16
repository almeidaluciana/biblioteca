package ads.ifce.biblioteca_ifce.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Livro {
    private Long id;
    private String nome;
    private int ano;
    private String autor;
}
