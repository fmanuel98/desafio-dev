package fmanuel98.github.com.backend.domain.services;

import lombok.Builder;
import lombok.Getter;

import java.io.InputStream;

@Builder
@Getter
public class NovoArquivoCnab {
    private String nomeAquivo;
    private InputStream inputStream;
}
