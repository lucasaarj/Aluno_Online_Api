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

@NoArgsConstructor // Gera o contrutor vazio -> Evita código repetitivo (boilerplate)

@AllArgsConstructor // Gera o construtor com todos os campos

@Data // Gera os getters, Setters, ToString (Transformar o objeto em texto), equals (Serve para comparar dois objetos pelo conteúdo, não pela referência)

@Table(name = "professor") // Nome da tabela no banco de dados

@Entity // "Esta classe é uma tabela no banco de dados!"
public class Professor {
    @Id // Campo é a chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String email;

    private String cpf;
}
