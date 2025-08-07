import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.print("Digite o valor do limite do Cartão de crédito: ");
        double valorDoLimite = scan.nextDouble();
        CartaoDeCredito cartao = new CartaoDeCredito(valorDoLimite);
        int contador = 0;
        while (true) {
            System.out.println("Fatura atual: " + cartao.getFaturaAtual());
            System.out.println(" ");
            System.out.print("Digite o nome do Produto: ");
            String nomeDoProduto = scan.next();
            System.out.println(" ");
            System.out.print("Digite o valor do produto: ");
            double valorDoProduto = scan.nextDouble();
            Produto produto = new Produto(nomeDoProduto, valorDoProduto);
            if (cartao.getLimite() >= produto.getValor()) {
                cartao.efetuarCompra(produto);
                cartao.listarCompras();

                contador++;

            } else {
                System.out.println("Não foi possível realizar a compra, limite menor que o valor do produto.");
                cartao.listarCompras();
                System.out.println("Fatura atual: " + cartao.getFaturaAtual());
                break;
            }

        }

    }
}
