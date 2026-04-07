/**
 *  Representação de tabela no banco de dados.
 * Cada atributo da classe vira uma coluna na tabela.  
**/

package br.com.alunoonline.api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor 

@AllArgsConstructor 

@Data 
@Table(name = "aluno") // Nome da tabela no banco de dados

@Entity 
public class Aluno {
    
    @Id // Chave primária
    
     
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private Long id;

    private String nome;

    private String cpf;
    
    private String email;

}
