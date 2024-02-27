package med.voll.api.DTO;

import jakarta.validation.constraints.NotNull;
import med.voll.api.medico.Endereco;

public record DadosAtualizacaoPaciente(
		@NotNull
		Long id,

		String nome, 
		
		String telefone,
		
		DadosEndereco endereco
		
		) {

}
