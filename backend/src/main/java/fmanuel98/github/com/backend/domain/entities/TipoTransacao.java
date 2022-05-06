package fmanuel98.github.com.backend.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TipoTransacao {
  DEBITO(1, "Entrada", "+"),
  BOlETO(2, "Saída", "-"),
  FINANCIAMENTO(3, "Entrada", "+"),
  CREDITO(4, "Saida", "-"),
  RECEBIMENTO_EMPRESTIMO(5, "Entrada", "+"),
  VENDAS(6, "Entrada", "+"),
  RECEBIMENTO_TED(7, "ENTRADA", "+"),
  RECEBIMENTODOC(8, "Entrada", "+"),
  ALUGUEL(9, "Entrada", "+");

  private int tipo;
  private String descricao;
  private String sinal;

}
