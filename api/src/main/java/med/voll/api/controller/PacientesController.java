package med.voll.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import med.voll.api.DTO.DadosAtualizacaoPaciente;
import med.voll.api.DTO.DadosCadastraisPacientes;
import med.voll.api.DTO.DadosListagemPacientes;
import med.voll.api.pacientes.Paciente;
import med.voll.api.pacientes.PacientesRepository;

@RestController
@RequestMapping("/pacientes")
public class PacientesController {

	@Autowired
	PacientesRepository pacientesRepository;
	
	@PostMapping
	@Transactional
	public void cadastrar(@RequestBody @Valid DadosCadastraisPacientes dados) {
		pacientesRepository.save(new Paciente(dados));
	}
	
	@GetMapping
	public Page<DadosListagemPacientes> listar(@PageableDefault(size= 10, page= 0, sort= {"nome"}) Pageable paginacao){
		return pacientesRepository.findAll(paginacao).map(DadosListagemPacientes::new);
	}
	
	@PutMapping
	@Transactional
	public void atualizar(@RequestBody @Valid DadosAtualizacaoPaciente dados) {
		var paciente = pacientesRepository.getReferenceById(dados.id());
		paciente.atulizarInformacoes(dados);
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public void excluir(@PathVariable Long id) {
		var paciente = pacientesRepository.getReferenceById(id);
		paciente.excluir();
	}
}
