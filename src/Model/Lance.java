package Model;

public class Lance {

    private double valor;
    private Produto produto;
    private Cliente cliente;
    private Data data;

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Lance(double valor, Produto produto, Cliente cliente,Data data) {
        this.valor = valor;
        this.produto = produto;
        this.cliente = cliente;
        this.data = data;
    }

    public void toStringLance(){
        cliente.toStringClienteLance();
        data.imprimirData();
        System.out.println("\nValor: "+valor);
    }

    public Lance() {
    }
}
