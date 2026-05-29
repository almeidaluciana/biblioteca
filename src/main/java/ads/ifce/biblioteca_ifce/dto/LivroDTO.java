package ads.ifce.biblioteca_ifce.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
    @NotBlank(message = "O nome do livro é obrigatório")
    private String nome;
    @NotNull(message = "O ano é obrigatório")
    @Min(value = 1, message = "O ano deve ser maior que zero")
    private int ano;
    @NotBlank(message = "O autor é obrigatório")
    private String autor;
    @NotBlank(message = "A imagem é obrigatória")
    private String imagem;
}
