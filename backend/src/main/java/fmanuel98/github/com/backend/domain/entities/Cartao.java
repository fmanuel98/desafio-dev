package fmanuel98.github.com.backend.domain.entities;

import java.math.BigDecimal;

import javax.persistence.*;

import lombok.Data;
import lombok.Value;

@Value
@Entity
public class Cartao {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String numero;
  @ManyToOne(optional = false,cascade = CascadeType.ALL)
  private Pessoa pessoa;
}
