package med.voll.api.pacientes;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import med.voll.api.DTO.DadosListagemPacientes;
import med.voll.api.medico.Medico;

public interface PacientesRepository extends JpaRepository<Paciente, Long>{
	
	Page<DadosListagemPacientes> findAllByAtivoTrue(Pageable paginacao);
}
