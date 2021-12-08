import java.sql.Date;
import java.util.Objects;

public class Carro {
    private int Id;
    private String nome;
    private String marca;
    private String anodomodelo;

    public Carro(int Id, String nome, String marca, String anodomodelo) {
        this.Id = Id;
        this.nome = nome;
        this.marca = marca;
        this.anodomodelo = anodomodelo;

    }

    public int getId() {
        return this.Id;
    }

    public void setId(int id) {
        this.Id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getmarca() {
        return this.marca;
    }

    public void setmarca(String marca) {
        this.marca = marca;
    }

    public String getanodomodelo() {
        return this.anodomodelo;
    }

    public void setanodomodelo(String anodomodelo) {
        this.anodomodelo = anodomodelo;
    }

    public Carro id(int id) {
        setId(id);
        return this;
    }

    public Carro nome(String nome) {
        setNome(nome);
        return this;
    }

    public Carro marca(String marca) {
        setmarca(marca);
        return this;
    }

    public Carro anodomodelo(String anodomodelo) {
        setanodomodelo(anodomodelo);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Carro)) {
            return false;
        }
     Carro carro = (Carro) o;
        return Id == carro.Id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, nome, marca, anodomodelo);
    }

    @Override
    public String toString() {
        return "" +
            "\n  id:'" + getId() + "'" +
            "\n  nome:'" + getNome() + "'" +
            "\n  marca:'" + getmarca() + "'" +
            "\n  anodomodelo:'" + getanodomodelo() + "'" ;
    }
}
