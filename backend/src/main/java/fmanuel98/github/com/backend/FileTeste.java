package fmanuel98.github.com.backend;

import fmanuel98.github.com.backend.domain.entities.Cartao;
import fmanuel98.github.com.backend.domain.entities.Pessoa;
import fmanuel98.github.com.backend.domain.entities.TipoTransacao;
import fmanuel98.github.com.backend.domain.entities.Transacao;
import jdk.dynalink.linker.LinkerServices;
import org.springframework.util.FileCopyUtils;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FileTeste {

    public static void main(String[] args) {
        List<String> transasoes = new ArrayList();
        Path arquivo = Paths.get(System.getenv("PWD"), "CNABTeste.txt");
        try (BufferedReader leitor = Files.newBufferedReader(arquivo)) {
            String linha = null;
            while ((linha = leitor.readLine()) != null) {
                transasoes.add(linha);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());

        }
        //System.out.println("Donos " + transasoes.stream().map(t -> t.substring(48, 62)).collect(Collectors.toList()).toString());
        //System.out.println("CPF "+transasoes.stream().map(t -> t.substring(19,30)).collect(Collectors.toList()).toString());
        //System.out.println("Tipo de transacao "+transasoes.stream().map(t -> ).collect(Collectors.toList()).toString());
        //System.out.println("Data "+transasoes.stream().map(t -> t.substring(1,9)).collect(Collectors.toList()).toString());
        //System.out.println("Valor "+transasoes.stream().map(t -> t.substring(9,19)).collect(Collectors.toList()).toString());
        //System.out.println("Cartao "+transasoes.stream().map(t -> t.substring(30,42)).collect(Collectors.toList()).toString());
        //System.out.println("Hora " + transasoes.stream().map(t -> t.substring(42, 48)).collect(Collectors.toList()).toString());
        //System.out.println("estabele " + transasoes.stream().map(t -> t.substring(62)).collect(Collectors.toList()).toString());



    }
}