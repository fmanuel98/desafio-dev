package fmanuel98.github.com.backend.domain.entities;

import javax.persistence.*;

import lombok.Data;
import lombok.Value;

@Value
@Entity
public class Pessoa {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String nome;
  private String cpf;
}
