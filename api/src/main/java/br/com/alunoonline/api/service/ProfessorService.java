/**
 * Esta classe ficam as regras de negócio
 * 
 * Acontece a lógica de: validações, cálculos, decisões. 
 */
package br.com.alunoonline.api.service;

import br.com.alunoonline.api.model.Professor;  
import br.com.alunoonline.api.repository.ProfessorRepository;
import java.util.Optional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service // Esta Classe é um Service
public class ProfessorService {
    
    @Autowired // Usado para injeção de dependência.
    ProfessorRepository professorRepository;

    // CREATE -> POST -> Salvar Novo Professor
    public void criarProfessor(Professor professor){
        professorRepository.save(professor); // Insert into professor...
    }

    // READ -> Get (FindAll) -> Listar todos os Professores
    public List<Professor> listarTodosProfessores(){
        return professorRepository.findAll(); // SELECT * FROM professor
    }

    // READ -> Get (FindById) -> Buscar por Id
    public Optional<Professor> buscarProfessorPorId(Long id){
        return professorRepository.findById(id); // SELECT * FROM professor WHERE id = ?
    }

    // UPDATE -> PUT ou PATCH -> Atualizar por Id
    public void atualizarProfessorPorId(Long id, Professor professor){
        Optional<Professor> professorDoBanco = buscarProfessorPorId(id);

        if(professorDoBanco.isEmpty()){
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Professor não encontrado!");
        }

        Professor professorParaEditar = professorDoBanco.get();
        professorParaEditar.setNome(professor.getNome());
        professorParaEditar.setCpf(professor.getCpf());
        professorParaEditar.setEmail(professor.getEmail());

        professorRepository.save(professorParaEditar);  // UPDATE professor SET ...
    }

    // DELETE -> DELETE -> Deletar por Id
    public void deletarAlunoPorId(Long id){
        professorRepository.deleteById(id);  
    }
    
}
