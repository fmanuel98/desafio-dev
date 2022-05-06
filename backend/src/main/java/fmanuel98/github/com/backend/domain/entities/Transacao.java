package fmanuel98.github.com.backend.domain.entities;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.OffsetDateTime;

import javax.persistence.*;

import lombok.Getter;
import lombok.ToString;
import lombok.Value;
import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;


@Getter
@ToString
@Entity
public class Transacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private TipoTransacao tipoTransacao;
    private String local;
    private LocalDate data;
    private LocalTime hora;
    @ManyToOne(optional = false,cascade = CascadeType.ALL)
    private Cartao cartao;
    private BigDecimal valor;

    public Transacao() {
    }

    public Transacao(TipoTransacao tipoTransacao, String local, LocalDate data, LocalTime hora, Cartao cartao, BigDecimal valor) {
        this.tipoTransacao = tipoTransacao;
        this.local = local;
        this.data = data;
        this.hora = hora;
        this.cartao = cartao;
        this.valor = valor;
    }

}
