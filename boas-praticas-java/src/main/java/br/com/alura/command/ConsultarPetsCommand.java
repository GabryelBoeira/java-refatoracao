package br.com.alura.command;

import br.com.alura.client.ClientHttpConfiguration;
import br.com.alura.executor.Command;
import br.com.alura.service.AbrigoService;
import br.com.alura.service.PetService;

import java.io.IOException;

public class ConsultarPetsCommand implements Command {

    @Override
    public void execute() {
        try {
            ClientHttpConfiguration clientHttp = new ClientHttpConfiguration();
            PetService petService = new PetService(clientHttp);

            petService.listarPetsAbrigo();
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("ConsultarPetsCommand()", e);
        }
    }
}
