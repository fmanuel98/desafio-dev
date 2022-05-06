package fmanuel98.github.com.backend.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import fmanuel98.github.com.backend.domain.entities.Transacao;

public interface TransacaoRepositories extends JpaRepository<Transacao, Long> {
}
