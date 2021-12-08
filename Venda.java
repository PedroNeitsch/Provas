public class Venda {
    public static void main(String[] args) {
        Cliente cliente = new Cliente("Fulano", "0201020201", 21, 193929, 40028922);

        cliente.adicionarCarro("UNO", "FIAT", "azul");

        Carro carro = new Carro("Celta", "GM", "preto");

        cliente.adicionarCarro(carro);

    } 
}
