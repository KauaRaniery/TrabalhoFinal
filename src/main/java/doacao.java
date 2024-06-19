import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

public class doacao {

    private static Scanner entrada = new Scanner(System.in);
    private static FileWriter arquivoSaida;
    private static calculoDoacoes doacoes = new calculoDoacoes(); 

    private static ArrayList<String> dadosDoacao = new ArrayList<String>(); 

    private static void exibirMenu() {
        escreverNoArquivo("------------------ MENU DOAÇÕES  -------------------");
        escreverNoArquivo("1. Doar");
        escreverNoArquivo("2. Consultar Doações");
        escreverNoArquivo("Digite sua opção: ");
    }

    public static void main(String[] args) {
        try {
            arquivoSaida = new FileWriter("respostas.txt");
        } catch (IOException e) {
            System.out.println("Erro ao criar arquivo de saída: " + e.getMessage());
            System.exit(1);
        }

        int opcao;
        do {
            exibirMenu();
            opcao = entrada.nextInt();

            switch (opcao) {
                case 1:
                    doar();
                    break;
                case 2:
                    consultarDoacoes();
                    break;
                case 3:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 3);

        entrada.close();

        try {
            arquivoSaida.close();
        } catch (IOException e) {
            System.out.println("Erro ao fechar arquivo de saída: " + e.getMessage());
        }
    }

    private static void doar() {
        Scanner entrada = new Scanner(System.in);

        System.out.print("Digite o valor da doação: ");
        double valorDoacao = entrada.nextDouble();
        doacoes.adicionarDoacao(valorDoacao);

        System.out.print("Digite o CEP: ");
        String cep = entrada.next();

        dadosDoacao.add(String.valueOf(valorDoacao)); 
        dadosDoacao.add(cep); 

        escreverNoArquivo("Doação realizada com sucesso!");
        escreverNoArquivo("Valor Doado: R$ " + valorDoacao);
        escreverNoArquivo("CEP: " + cep);

        entrada.close();
    }

    private static void consultarDoacoes() {
        if (dadosDoacao.isEmpty()) {
            escreverNoArquivo("Não há doações cadastradas.");
        } else {
            escreverNoArquivo("\n Doações Cadastradas:");
            for (int i = 0; i < dadosDoacao.size(); i += 2) {
                escreverNoArquivo("Valor Doado: R$ " + dadosDoacao.get(i));
                escreverNoArquivo("CEP: " + dadosDoacao.get(i + 1));
                escreverNoArquivo("-------------------------");
            }

            System.out.println("\n**Resumo das Doações:**");
            System.out.println("Total Doado: R$ " + doacoes.obterTotalDoado());
            System.out.println("Número de Doações: " + doacoes.obterNumeroDoacoes());
            System.out.println("Média de Doação: R$ " + doacoes.obterMediaDoacoes());
        }
    }

    private static void escreverNoArquivo(String texto) {
        try {
            arquivoSaida.write(texto + "\n");
        } catch (IOException e) {
            System.out.println("Erro ao escrever no arquivo: " + e.getMessage());
        }
    }
}