import java.util.InputMismatchException;
import java.util.Scanner;

public class TesteCartao {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int contador = 0;
        boolean sair = false;
        while (!sair) {
            try {
                System.out.println("Digite o limite para o cartão de crédito: ");
                double valorDoLimite = scanner.nextDouble();
                scanner.nextLine(); // Limpa o enter
                if (valorDoLimite > 0) {
                    CartaoDeCredito cartao = new CartaoDeCredito(valorDoLimite);
                    int contadorOpcoes = 0;
                    while (true) {
                        System.out.println("Digite uma das opção abaixo: ");
                        System.out.println("===============================");
                        System.out.println("===  Opção 1 para continuar ===");
                        System.out.println("===  Opção 2 para sair      ===");
                        System.out.println("===============================");
                        String entrada = scanner.nextLine();
                        int opcao;
                        try {
                            opcao = Integer.parseInt(entrada); // tenta converter para número
                            if (opcao == 1) {
                                System.out.print("Digite o nome do produto: ");
                                String nomeDoProduto = scanner.nextLine(); // limpa o Enter pendente, Lê a linha inteira
                                                                           // até
                                                                           // o
                                                                           // Enter
                                // Verifica se tem pelo menos uma letra (a-z ou A-Z)
                                if (nomeDoProduto.matches(".*[a-zA-Z].*")) {
                                    System.out.print("Digite o valor do produto: ");
                                    String valorTexto = scanner.nextLine();

                                    try {
                                        double valorDoProduto = Double.parseDouble(valorTexto);
                                        if (valorDoProduto > 0) {
                                            Produto produto = new Produto(nomeDoProduto, valorDoProduto);
                                            cartao.efetuarCompra(produto);
                                            cartao.listarCompras();
                                            contadorOpcoes++;
                                        } else {
                                            System.out.println("Valor inválido. O valor deve ser maior que zero.");
                                            contadorOpcoes++;
                                        }
                                    } catch (NumberFormatException e) {
                                        System.out.println(
                                                "Entrada inválida. Digite um número válido (use ponto para decimais, ex: 49.99).");
                                        contadorOpcoes++;
                                    }

                                } else {
                                    System.out.println(
                                            "Nome inválido. O nome do produto deve conter letras. Tente novamente.");
                                    contadorOpcoes++;
                                }
                            } else if (opcao == 2) {
                                System.out.println("Encerrando menu de compras...");
                                sair = true;
                                break; // sai do menu interno
                            } else {
                                System.out.println("Digite apenas as opções disponveis no painel de compras: 1 ou 2.");
                                System.out.println(" ");
                                cartao.listarCompras();
                                contadorOpcoes++;
                            }

                        } catch (NumberFormatException e) {
                            // TODO: handle exception
                            System.out.println("Só é possível digitar as opções presentes no painel...");
                            System.out.println(" ");
                            cartao.listarCompras();
                        }
                    }
                } else {
                    System.out.println("Limite tem que ser maior que 0...");
                    contador++;
                }

            } catch (InputMismatchException e) {
                System.out.println("Só é possível digitar números para incluir o limite...");
                scanner.nextLine(); // Limpa a entrada inválida
                contador++;
            }

        }

    }

}
