import java.util.ArrayList;

public class Cliente {
    
    String nome;
    String cpf;
    int idade;
    int rg;
    int telefone;
    ArrayList<Carro> carros = new ArrayList<>();

    public Cliente(
        String nome,
        String cpf,
        int idade,
        int rg,
        int telefone
    ) {
        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
        this.rg = rg;
        this.telefone = telefone;
    }
    
    public void adicionarCarro(Carro carro) {
        this.carros.add(carro);
    }

    public void adicionarCarro(
        String modelo,
        String cpf,
        String nome
    ) {
        this.adicionarCarro(new Carro(modelo, cpf, nome));
    } 

}
