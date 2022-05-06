package fmanuel98.github.com.backend.domain.services;

import fmanuel98.github.com.backend.domain.entities.Cartao;
import fmanuel98.github.com.backend.domain.entities.Pessoa;
import fmanuel98.github.com.backend.domain.entities.TipoTransacao;
import org.springframework.stereotype.Service;

import fmanuel98.github.com.backend.domain.entities.Transacao;
import fmanuel98.github.com.backend.domain.repositories.TransacaoRepositories;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TransacaoService {
    private final TransacaoRepositories repository;

    @Transactional
    public void salvar(List<Transacao> transacoes) {
        repository.saveAll(transacoes);
    }

    public List<Transacao> toTransacao(List<String> transasoes) {
        return transasoes.stream().map(t -> {
            var nome = t.substring(48, 62).stripTrailing();
            var cpf = t.substring(19, 30);
            var pessoa = new Pessoa(0L, nome, cpf);
            var numero = t.substring(30, 42);
            var cartao = new Cartao(0L, numero, pessoa);
            var tipo = Arrays.stream(TipoTransacao.values()).filter(e -> e.getTipo() == Integer.parseInt(t.substring(0, 1))).findFirst().orElse(TipoTransacao.DEBITO);
            var data = t.substring(1, 9);
            var hora = t.substring(42, 48);
            var estabelecimento = t.substring(62).stripTrailing();
            var valor = t.substring(9, 19);
            var transacao = new Transacao(tipo, estabelecimento, LocalDate.now(), LocalTime.now(), cartao, new BigDecimal(valor));
            return transacao;

        }).collect(Collectors.toList());
    }
}
