/**
 * Essa classe é uma interface que herda de JpaRepository.
 */
package br.com.alunoonline.api.repository;

import br.com.alunoonline.api.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long>{
  /**
   * Mesmo estando vazia visualmente, por herdar de JpaRepository, a sua interface ganha dezenas de      * métodos prontos para manipular o banco de dados sem que você precise escrever nenhuma linha de SQL. * Alguns dos métodos que já vêm "de brinde" são:
   * save(aluno): Insere um novo aluno no banco ou atualiza um existente.
   * findAll(): Retorna uma lista com todos os alunos cadastrados.
   * findById(id): Busca um aluno específico pela sua chave primária.
   * deleteById(id): Remove um aluno do banco de dados usando o ID.
  **/  
}
