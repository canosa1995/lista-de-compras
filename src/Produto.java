public class Produto implements Comparable<Produto> {
    private String descricao;
    private double valor;

    public Produto(String descricao, double valor) {
        this.descricao = descricao;
        this.valor = valor;
    }

    public double getValor() {
        return this.valor;
    }

    public String getDescricao() {
        return this.descricao;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "Nome: " + this.descricao + " - " + "Valor: " + this.valor;
    }

    @Override
    public int compareTo(Produto outro) {
        return Double.compare(this.valor, outro.valor);
    }
}
