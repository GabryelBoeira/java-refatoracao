package br.com.alura;

import br.com.alura.command.CadastrarAbrigoCommand;
import br.com.alura.command.ConsultarAbrigoCommand;
import br.com.alura.command.ConsultarPetsCommand;
import br.com.alura.command.ImportarPetsAbrigoCommand;
import br.com.alura.executor.CommandExecutor;

import java.util.Scanner;

public class AdopetConsoleApplication {

    public static void main(String[] args) {
        CommandExecutor executor = new CommandExecutor();
        System.out.println("##### BOAS VINDAS AO SISTEMA ADOPET CONSOLE #####");
        try {
            int opcaoEscolhida = 0;
            while (opcaoEscolhida != 5) {
                exibirMenu();

                String textoDigitado = new Scanner(System.in).nextLine();
                opcaoEscolhida = Integer.parseInt(textoDigitado);

                switch (opcaoEscolhida) {
                    case 1 -> executor.executeCommand(new ConsultarAbrigoCommand());
                    case 2 -> executor.executeCommand(new CadastrarAbrigoCommand());
                    case 3 -> executor.executeCommand(new ConsultarPetsCommand());
                    case 4 -> executor.executeCommand(new ImportarPetsAbrigoCommand());
                    case 5 -> {
                        System.out.println("Finalizando o programa...");
                        System.exit(0);
                    }
                    default -> {
                        System.out.println("NÚMERO INVÁLIDO!");
                        opcaoEscolhida = 0;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void exibirMenu() {
        System.out.println("\nDIGITE O NÚMERO DA OPERAÇÃO DESEJADA:");
        System.out.println("1 -> Listar abrigos cadastrados");
        System.out.println("2 -> Cadastrar novo abrigo");
        System.out.println("3 -> Listar pets do abrigo");
        System.out.println("4 -> Importar pets do abrigo");
        System.out.println("5 -> Sair");
    }

}
