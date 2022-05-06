package fmanuel98.github.com.backend.api.controllers;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

import fmanuel98.github.com.backend.domain.entities.Transacao;
import fmanuel98.github.com.backend.domain.services.CnabService;
import fmanuel98.github.com.backend.domain.services.TransacaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/cnab")
@RequiredArgsConstructor
public class CnabController {
    private final CnabService cnabService;
    private final TransacaoService transacaoService;

    @PostMapping
    @ResponseStatus(CREATED)
    public void uploadCnba(@RequestPart("file") MultipartFile file) {
        List<String> transacoes = cnabService.processarCnabFile(file);
        List<Transacao> transacaosBd = transacaoService.toTransacao(transacoes);
        transacaoService.salvar(transacaosBd);
    }
}
