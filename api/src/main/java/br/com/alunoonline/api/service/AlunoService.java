
package br.com.alunoonline.api.service;

import br.com.alunoonline.api.model.Aluno;  
import br.com.alunoonline.api.repository.AlunoRepository;
import java.util.Optional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service 
public class AlunoService {
    
    @Autowired  
    AlunoRepository alunoRepository;

    // CREATE -> POST -> Salvar Novo Aluno
    public void criarAluno(Aluno aluno){
        alunoRepository.save(aluno); // Insert into aluno...
    }

    // READ -> Get (FindAll) -> Listar todos
    public List<Aluno> listarTodosAlunos(){
        return alunoRepository.findAll(); // SELECT * FROM aluno
    }

    // READ -> Get (FindById) -> Buscar por Id
    public Optional<Aluno> buscarAlunoPorId(Long id){
        return alunoRepository.findById(id); // SELECT * FROM aluno WHERE id = ?
    }

    // UPDATE -> PUT ou PATCH -> Atualizar por Id
    public void atualizarAlunoPorId(Long id, Aluno aluno){
        Optional<Aluno> alunoDoBanco = buscarAlunoPorId(id);

        if(alunoDoBanco.isEmpty()){
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Aluno não encontrado!");
        }

        Aluno alunoParaEditar = alunoDoBanco.get();
        alunoParaEditar.setNome(aluno.getNome());
        alunoParaEditar.setCpf(aluno.getCpf());
        alunoParaEditar.setEmail(aluno.getEmail());

        alunoRepository.save(alunoParaEditar);  // UPDATE aluno SET ...
    }

    // DELETE -> DELETE -> Deletar por Id
    public void deletarAlunoPorId(Long id){
        alunoRepository.deleteById(id);  
    }
}
