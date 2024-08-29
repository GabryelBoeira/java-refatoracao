package br.com.alura.service;

import br.com.alura.client.ClientHttpConfiguration;
import br.com.alura.domain.Abrigo;
import com.google.gson.Gson;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.http.HttpResponse;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AbrigoServiceTest {

    private ClientHttpConfiguration client = mock(ClientHttpConfiguration.class);
    private AbrigoService abrigoService = new AbrigoService(client);
    private HttpResponse<String> response = mock(HttpResponse.class);
    private Abrigo abrigo = new Abrigo("Abrigo Teste", "41999999999", "abrigo@gmail.com");

    @Test
    @DisplayName("Teste para verificar Disparo para consulta de abrigos Cadastrados")
    public void consultarAbrigoSucesso() throws IOException, InterruptedException {
        abrigo.setId(0L);
        String esperadoMensagem = "Abrigos cadastrados:";
        String esperadoIdENome = "0 - Abrigo Teste";

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(out);
        System.setOut(ps);

        when(response.body()).thenReturn("["+ new Gson().toJson(abrigo) +"]");
        when(client.dispararConsultaGet(anyString())).thenReturn(response);

        abrigoService.consultarAbrigo();

        String[] linhas = out.toString().split(System.lineSeparator());
        String resultadoMensagem = linhas[0];
        String resultadoIdENome = linhas[1];

        Assertions.assertEquals(esperadoMensagem, resultadoMensagem);
        Assertions.assertEquals(esperadoIdENome, resultadoIdENome);
    }

    @Test
    @DisplayName("Teste para verificar Disparo para consulta de abrigos SEM dados Cadastrados")
    public void consultarAbrigoSemDados() throws IOException, InterruptedException {
        String esperadoMensagem = "Nenhum abrigo cadastrado.";

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(out);
        System.setOut(ps);

        when(response.body()).thenReturn("[]");
        when(client.dispararConsultaGet(anyString())).thenReturn(response);

        abrigoService.consultarAbrigo();

        String[] linhas = out.toString().split(System.lineSeparator());
        String resultadoMensagem = linhas[0];

        Assertions.assertEquals(esperadoMensagem, resultadoMensagem);
    }

}
