package med.voll.api.pacientes;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import lombok.Data;
import lombok.Getter;
import med.voll.api.DTO.DadosAtualizacaoPaciente;
import med.voll.api.DTO.DadosCadastraisPacientes;
import med.voll.api.medico.Endereco;

@Table(name = "pacientes")
@Entity(name = "pacientes")
@Data
@Getter
public class Paciente {
	
	public Paciente() {
		
	}
	
	
	public Paciente(@Valid DadosCadastraisPacientes dados) {
		this.nome = dados.nome();
		this.telefone = dados.telefone();
		this.cpf = dados.cpf();
		this.email = dados.email();
		this.endereco = new Endereco(dados.endereco());
		this.ativo = 1;
	}



	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	private String telefone;
	private String cpf;
	private String email;
	@Embedded
	private Endereco endereco;
	private int ativo;
	
	
	public int isAtivo() {
		return ativo;
	}
	public void setAtivo(int ativo) {
		this.ativo = ativo;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}


	public void atulizarInformacoes(DadosAtualizacaoPaciente dados) {
		if(dados.nome() != null) {
			this.nome = dados.nome();
		}
		
		if(dados.telefone() != null) {
			this.nome = dados.nome();
		}
		
		if(dados.endereco() != null) {
			this.endereco.atualizarInformacoes(dados.endereco());
		}
		
	}
	
	public void excluir() {
		this.ativo = 0;
	}
}
