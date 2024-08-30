package br.com.alura.command;

import br.com.alura.client.ClientHttpConfiguration;
import br.com.alura.executor.Command;
import br.com.alura.service.AbrigoService;

import java.io.IOException;

public class ConsultarAbrigoCommand implements Command {

    @Override
    public void execute() {
        try {
            ClientHttpConfiguration clientHttp = new ClientHttpConfiguration();
            AbrigoService abrigoService = new AbrigoService(clientHttp);

            abrigoService.consultarAbrigo();
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("ConsultarAbrigoCommand()", e);
        }
    }
}
