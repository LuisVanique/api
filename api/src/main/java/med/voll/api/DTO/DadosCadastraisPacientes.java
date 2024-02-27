package med.voll.api.DTO;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastraisPacientes(
		@NotNull
		@NotBlank
		String nome,
		
		@NotNull
		@NotBlank
		@Email
		String email,
		@NotNull
		@NotBlank
		String telefone,
		
		@NotBlank
		@NotNull
		String cpf,
		
		@Valid
		@NotNull
		DadosEndereco endereco
		) {

}
