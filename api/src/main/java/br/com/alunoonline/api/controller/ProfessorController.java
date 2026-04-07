/**
 * O controller serve para endpoints REST. Ele recebe as requisições HTTP (GET, POST, PUT, DELETE), chama o Service apropriado, e devolve a resposta. É aqui que definimos as URLs (endpoints) da API.
 */
package br.com.alunoonline.api.controller;

import br.com.alunoonline.api.model.Professor;
import br.com.alunoonline.api.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController

// @RequestMapping no Spring Framework serve para mapear requisições HTTP (da web) para classes ou métodos específicos do seu Controller.

@RequestMapping("/professor")  // URL base: /professor 
public class ProfessorController {
    
    @Autowired
    ProfessorService professorService;

    // Criar Professor -> POST
    @PostMapping // POST /professor
    @ResponseStatus(HttpStatus.CREATED) // Retorna 201 CREATED
    public void criarProfessor(@RequestBody Professor professor) { //Receber dados de POST, PUT, PATCH; Converter JSON → objeto Java
        professorService.criarProfessor(professor);
    }

    // Listar todos os Professores -> Get 200 OK
    @GetMapping                      // GET /professor
    @ResponseStatus(HttpStatus.OK)
    public List<Professor> listarTodosProfessores() {
        return professorService.listarTodosProfessores();
    }
    
    // Buscar professor por ID -> Get 200 OK
    @GetMapping("/{id}") // GET /professor/{id}
    @ResponseStatus(HttpStatus.OK) // Retorna 201
    public Optional<Professor> buscarProfessorPorId(@PathVariable Long id) { //Usado no Spring para pegar valores que vêm na URL.
        return professorService.buscarProfessorPorId(id);
    }

    // Atualizar um professor por id -> PUT ou PATCH -> 204 NO CONTENT
    @PutMapping("/{id}")              // PUT /professor/1
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizarProfessorPorId(@PathVariable Long id, @RequestBody Professor professor) {
        professorService.atualizarProfessorPorId(id, professor);

    }
    
    // Deletar um professor por id -> DELETE -> 204 NO CONTENT
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarPorId(@PathVariable Long id) {
    professorService.deletarAlunoPorId(id);
    
    
    }
}
