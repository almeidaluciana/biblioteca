package ads.ifce.biblioteca_ifce.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// DTO usado para receber dados da API referentes ao livro
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LivroDTO {
    private String nome;
    private int ano;
    private String autor;
}
