import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class CartaoDeCredito {
    private double limite;
    private double faturaAtual;
    private List<Produto> compras;

    public CartaoDeCredito(double limite) {
        this.limite = limite;
        this.faturaAtual = 0.0; // começa com zero
        this.compras = new ArrayList<>();
    }

    /*
     * public void setFaturaAtual(double faturaAtual) {
     * this.faturaAtual = faturaAtual;
     * }
     */

    public double getFaturaAtual() {
        return this.faturaAtual;
    }

    public double getLimite() {
        return this.limite;
    }

    public boolean efetuarCompra(Produto p) {
        if (this.limite >= p.getValor()) {
            this.limite = this.limite - p.getValor();
            this.faturaAtual = this.faturaAtual + p.getValor();
            this.compras.add(p);
            return true;
        }
        System.out.println("Não foi possível realizar a compra, limite menor que o valor do produto.");
        return false;
    }

    public void listarCompras() {
        Collections.sort(this.compras);
        for (Produto p : this.compras) {
            System.out.println(p);
        }
    }

}
