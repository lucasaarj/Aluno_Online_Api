
package br.com.alunoonline.api.controller;

import br.com.alunoonline.api.model.Aluno;
import br.com.alunoonline.api.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController


@RequestMapping("/alunos")  // URL base: /alunos 
public class AlunoController {
    
    @Autowired
    AlunoService alunoService;

    // Criar aluno -> POST
    @PostMapping // POST /Aluno
    @ResponseStatus(HttpStatus.CREATED) // Retorna 201 CREATED
    public void criarAluno(@RequestBody Aluno aluno) { //Receber dados de POST, PUT, PATCH; Converter JSON → objeto Java
        alunoService.criarAluno(aluno);
    }

    // Listar todos os alunos -> Get 200 OK
    @GetMapping                      // GET /alunos
    @ResponseStatus(HttpStatus.OK)
    public List<Aluno> listarTodosAlunos() {
        return alunoService.listarTodosAlunos();
    }
    
    // Buscar aluno por ID -> Get 200 OK
    @GetMapping("/{id}") // GET /Aluno/{id}
    @ResponseStatus(HttpStatus.OK) // Retorna 201
    public Optional<Aluno> buscarAlunoPorId(@PathVariable Long id) { //Usado no Spring para pegar valores que vêm na URL.
        return alunoService.buscarAlunoPorId(id);
    }

    // Atualizar um aluno por id -> PUT ou PATCH -> 204 NO CONTENT
    @PutMapping("/{id}")              // PUT /alunos/1
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizarAlunoPorId(@PathVariable Long id, @RequestBody Aluno aluno) {
        alunoService.atualizarAlunoPorId(id, aluno);
    }    
    
    // Deletar um aluno por id -> DELETE -> 204 NO CONTENT
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarPorId(@PathVariable Long id) {
    alunoService.deletarAlunoPorId(id); 
}
}
