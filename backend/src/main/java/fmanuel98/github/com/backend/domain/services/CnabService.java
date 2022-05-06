package fmanuel98.github.com.backend.domain.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class CnabService {

    public List<String> processarCnabFile(MultipartFile cnbaFIle) {
        armazenar(cnbaFIle);
        Path cnabFile = getArquivoPath(cnbaFIle.getOriginalFilename());
        List<String> transasoes = new ArrayList();

        try (BufferedReader leitor = Files.newBufferedReader(cnabFile)) {
            String linha = null;
            while ((linha = leitor.readLine()) != null) {
                transasoes.add(linha);
            }
            remover(cnbaFIle.getOriginalFilename());
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }
        return transasoes;
    }

    private void armazenar(MultipartFile cnbaFIle) {
        try {
            NovoArquivoCnab novaFoto = NovoArquivoCnab.builder().
                    inputStream(cnbaFIle.getInputStream()).
                    nomeAquivo(cnbaFIle.getOriginalFilename()).build();

            Path arquivoPath = getArquivoPath(novaFoto.getNomeAquivo());

            FileCopyUtils.copy(novaFoto.getInputStream(),
                    Files.newOutputStream(arquivoPath));
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }

    private void remover(String nomeArquivo) {
        try {
            Path arquivoPath = getArquivoPath(nomeArquivo);
            Files.deleteIfExists(arquivoPath);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }

    private Path getArquivoPath(String nomeArquivo) {
        return Paths.get(System.getenv("PWD")).resolve(Path.of(nomeArquivo));
    }
}
