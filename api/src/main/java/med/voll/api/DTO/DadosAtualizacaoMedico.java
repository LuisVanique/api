package med.voll.api.DTO;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoMedico(
		@NotNull
		Long id,
		
		String telefone,
		
		String nome,
		
		DadosEndereco endereco
		
		) {



}
