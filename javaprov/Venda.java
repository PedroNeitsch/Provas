import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import com.mysql.cj.protocol.Resultset;
import com.mysql.cj.x.protobuf.MysqlxCrud.Insert;


public class Venda {
    public static void main(String[] args) {
        try{
           

            Scanner scan1 = new Scanner(System.in);
            int escolha= 0;
            int Id_carro = 0;
            int id_cliente = 0;
            String nome = "";
            String cpf = "";
            String data_nasc = "";
            int telefone = 0;
            String anodomodelo = "";
            String marca = "";

            do{
            System.out.println("+--------------------------------+");
            System.out.println("|        MENU Concessionária     |");
            System.out.println("+--------------------------------+");
            System.out.println("| [1] ->     INSERT CARRO        |");
            System.out.println("| [2] ->     UPDATE CARRO        |");
            System.out.println("| [3] ->     DELETE CARRO        |");
            System.out.println("| [4] ->     SELECT CARRO        |");
            System.out.println("| [5] ->   INSERT CLIENTE        |");
            System.out.println("| [6] ->   UPDATE CLIENTE        |");
            System.out.println("| [7] ->   DELETE CLIENTE        |");
            System.out.println("| [8] ->   SELECT CLIENTE        |");
            System.out.println("| [9] ->        SAIR             |");
            System.out.println("+--------------------------------+");
            System.out.println(" Escolha uma opção: ");
            escolha = scan1.nextInt();

                switch(escolha){
                  
                    case 1: 
                    System.out.println("+---------------------+");
                    System.out.println("|   CRIAÇÃO DE CARRO  |");
                    System.out.println("+---------------------+");
                    System.out.println("ID: ");
                    try {
                        Id_carro = scan1.nextInt();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    System.out.println("--------------------");
                    System.out.println("       NOME:       ");
                    try {
                        nome = scan1.next();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    System.out.println("--------------------");
                    System.out.println("       MARCA:        ");
                    try {
                        marca = scan1.next();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    System.out.println("--------------------");
                    System.out.println(" ANO DO MODELO:");
                    try {
                        anodomodelo = scan1.next();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    try {
                        final String url = "jdbc:mysql://localhost:3306/provajava?useTimezone=true&serverTimezone=UTC";
                        final String user = "root";
                        final String password = "";
                        Connection con = DriverManager.getConnection(url, user, password);

                    
                    PreparedStatement state = con.prepareStatement("INSERT INTO carro (id_carro, nome, marca, anodomodelo,) VALUES (?,?,?,?)", 
                    PreparedStatement.RETURN_GENERATED_KEYS);
                    state.setInt(1,Id_carro);
                    state.setString(2,nome);    
                    state.setString(3,marca);
                    state.setString(4,anodomodelo);

                    if(state.executeUpdate()>0){
                        ResultSet resultado = state.getGeneratedKeys();

                        if(resultado.next()){
                            resultado.getInt(1);
                            resultado.getString(2);
                            resultado.getString(3);
                            resultado.getString(4);
                        }
                    }
                    con.close();
                    } catch (SQLException e) {
                    System.out.println(e.getMessage());
                    }
                    break;
                    
                    case 2:

                    System.out.println("+-------------------+");
                    System.out.println("|  UPTADE DE DADOS  |");
                    System.out.println("+-------------------+");
                    System.out.println("ID: ");
                    try {
                        Id_carro = scan1.nextInt();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    System.out.println("-------------------");
                    System.out.println("       NOME:       ");
                    try {
                        nome = scan1.next();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    System.out.println("-------------------");
                    System.out.println("       MARCA:        ");
                    try {
                        marca = scan1.next();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    System.out.println("-------------------");
                    System.out.println(" ANO DO MODELO : ");
                    try {
                        anodomodelo = scan1.next();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    try {
                        final String url = "jdbc:mysql://localhost:3306/provajava?useTimezone=true&serverTimezone=UTC";
                        final String user = "root";
                        final String password = "";
                        Connection con = DriverManager.getConnection(url, user, password);

                    PreparedStatement state2 = con.prepareStatement("UPDATE carro SET nome = ?, marca = ?, anodomodelo = ? WHERE Id_carro = ?", 
                    PreparedStatement.RETURN_GENERATED_KEYS);
                    state2.setString(1,nome);
                    state2.setString(2,marca);
                    state2.setString(4,anodomodelo);
                    state2.setInt(5,Id_carro);
                     
                    if(state2.executeUpdate()>0){
                        ResultSet resultado = state2.getGeneratedKeys();

                        if(resultado.next()){
                            resultado.getInt(1);
                            resultado.getString(2);
                            resultado.getString(3);
                            resultado.getString(4);
                            resultado.getString(5);
                        }
                    }
                    con.close();
                    } catch (SQLException e) {
                    System.out.println(e.getMessage());
                    }
                    break;


                    case 3:

                    System.out.println("+----------------+");
                    System.out.println("|  DELETAR CARRO  |");
                    System.out.println("+----------------+");
                    System.out.println("ID: ");
                    try {
                        Id_carro = scan1.nextInt();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    try {
                        final String url = "jdbc:mysql://localhost:3306/provajava?useTimezone=true&serverTimezone=UTC";
                        final String user = "root";
                        final String password = "";
                        Connection con = DriverManager.getConnection(url, user, password);
                    PreparedStatement state3 = con.prepareStatement("DELETE FROM carro WHERE id_carro = ? ",
                    PreparedStatement.RETURN_GENERATED_KEYS );
                    state3.setInt(1, Id_carro);

                    if(state3.executeUpdate()>0){
                        ResultSet resultado = state3.getGeneratedKeys();

                        if(resultado.next()){
                            resultado.getInt(1);
                        }
                    }
                    con.close();
                    } catch (SQLException e) {
                    System.out.println(e.getMessage());
                    }
                    break;

                    
                    case 4:

                    System.out.println("+-------------------+");
                    System.out.println("|  SELECIONAR CARRO  |");
                    System.out.println("+-------------------+");
                    System.out.println("ID: ");
                    try {
                        Id_carro = scan1.nextInt();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    try {
                        final String url = "jdbc:mysql://localhost:3306/provajava?useTimezone=true&serverTimezone=UTC";
                        final String user = "root";
                        final String password = "";
                        Connection con = DriverManager.getConnection(url, user, password);
                    PreparedStatement state4 = con.prepareStatement("SELECT * FROM carro WHERE Id_carro = ? ",
                    PreparedStatement.RETURN_GENERATED_KEYS);
                    state4.setInt(1,Id_carro);
                    ResultSet result = state4.executeQuery();
                    while(result.next()){
                        Carro carro = new Carro(
                            result.getInt("Id_carro"),
                            result.getString("nome"),
                            result.getString("marca"),
                            result.getString("anodomodelo"));
                    System.out.println(carro);
                    }
                    con.close();
                    } catch (SQLException e) {
                    System.out.println(e.getMessage());
                    }
                    break;

                   

                    case 5:
                    System.out.println("+----------------------+");
                    System.out.println("|  CRIAÇÃO DE CLIENTE  |");
                    System.out.println("+----------------------+");
                    System.out.println("ID: ");
                    try {
                        id_cliente= scan1.nextInt();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    System.out.println("-------------------");
                    System.out.println("       NOME:       ");
                    try {
                        nome = scan1.next();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    System.out.println("-------------------");
                    System.out.println("       CPF:        ");
                    try {
                        cpf = scan1.next();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    System.out.println("-------------------");
                    System.out.println("DATA DE NASCIMENTO: ");
                    try {
                        data_nasc = scan1.next();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    System.out.println("-------------------");
                    System.out.println("    TELEFONE:      ");
                    try {
                        telefone = scan1.nextInt();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }

                    try {
                        final String url = "jdbc:mysql://localhost:3306/provajava?useTimezone=true&serverTimezone=UTC";
                        final String user = "root";
                        final String password = "";
                        Connection con = DriverManager.getConnection(url, user, password);


                    PreparedStatement state = con.prepareStatement("INSERT INTO cliente (id_cliente, nome, cpf, data_nasc, telefone) VALUES (?,?,?,?,?)", 
                    PreparedStatement.RETURN_GENERATED_KEYS);
                    state.setInt(1,id_cliente);
                    state.setString(2,nome);
                    state.setString(3,cpf);
                    state.setString(4,data_nasc);
                    state.setInt(5,telefone);

                    if(state.executeUpdate()>0){
                        ResultSet resultado = state.getGeneratedKeys();

                        if(resultado.next()){
                            resultado.getInt(1);
                            resultado.getString(2);
                            resultado.getString(3);
                            resultado.getString(4);
                            resultado.getInt(5);
                        }
                    }
                    con.close();
                    } catch (SQLException e) {
                    System.out.println(e.getMessage());
                    }
                    break;

                    case 6:
                    System.out.println("+---------------------+");
                    System.out.println("|   UPTADE DE DADOS   |");
                    System.out.println("+---------------------+");
                    System.out.println("ID: ");
                    try {
                        id_cliente = scan1.nextInt();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    System.out.println("-------------------");
                    System.out.println("       NOME:       ");
                    try {
                        nome = scan1.next();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    System.out.println("-------------------");
                    System.out.println("       CPF:        ");
                    try {
                        cpf = scan1.next();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    System.out.println("-------------------");
                    System.out.println("DATA DE NASCIMENTO: ");
                    try {
                        data_nasc = scan1.next();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    System.out.println("-------------------");
                    System.out.println("    TELEFONE:    ");
                    try {
                        telefone = scan1.nextInt();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    try {
                        final String url = "jdbc:mysql://localhost:3306/provajava?useTimezone=true&serverTimezone=UTC";
                        final String user = "root";
                        final String password = "";
                        Connection con = DriverManager.getConnection(url, user, password);

                    PreparedStatement state2 = con.prepareStatement("UPDATE cliente SET nome = ?, cpf = ?, telefone = ?, data_nasc = ? WHERE id_cliente = ?", 
                    PreparedStatement.RETURN_GENERATED_KEYS);
                    state2.setString(1,nome);
                    state2.setString(2,cpf);
                    state2.setFloat(3,telefone);
                    state2.setString(4,data_nasc);
                    state2.setInt(5,id_cliente);
                     
                    if(state2.executeUpdate()>0){
                        ResultSet resultado = state2.getGeneratedKeys();

                        if(resultado.next()){
                            resultado.getInt(1);
                            resultado.getString(2);
                            resultado.getString(3);
                            resultado.getString(4);
                            resultado.getString(5);
                        }
                    }
                    con.close();
                    } catch (SQLException e) {
                    System.out.println(e.getMessage());
                    }
                    break;

                    case 7:
                    System.out.println("+--------------------+");
                    System.out.println("|   DELETAR CLIENTE  |");
                    System.out.println("+--------------------+");
                    System.out.println("ID: ");
                    try {
                        id_cliente = scan1.nextInt();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    try {
                        final String url = "jdbc:mysql://localhost:3306/provajava?useTimezone=true&serverTimezone=UTC";
                        final String user = "root";
                        final String password = "";
                        Connection con = DriverManager.getConnection(url, user, password);
                    PreparedStatement state3 = con.prepareStatement("DELETE FROM cliente WHERE id_cliente = ? ",
                    PreparedStatement.RETURN_GENERATED_KEYS );
                    state3.setInt(1, id_cliente);

                    if(state3.executeUpdate()>0){
                        ResultSet resultado = state3.getGeneratedKeys();

                        if(resultado.next()){
                            resultado.getInt(1);
                        }
                    }
                    con.close();
                    } catch (SQLException e) {
                    System.out.println(e.getMessage());
                    }
                    break;

                    case 8:
                    System.out.println("+----------------------+");
                    System.out.println("|  SELECIONAR CLIENTE  |");
                    System.out.println("+----------------------+");
                    System.out.println("ID: ");
                    try {
                        id_cliente = scan1.nextInt();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    try {
                        final String url = "jdbc:mysql://localhost:3306/provajava?useTimezone=true&serverTimezone=UTC";
                        final String user = "root";
                        final String password = "";
                        Connection con = DriverManager.getConnection(url, user, password);
                    PreparedStatement state4 = con.prepareStatement("SELECT * FROM cliente WHERE id_cliente = ? ",
                    PreparedStatement.RETURN_GENERATED_KEYS);
                    state4.setInt(1,id_cliente);
                    ResultSet result = state4.executeQuery();
                    while(result.next()){
                        Cliente cliente = new Cliente(
                            result.getInt("id_cliente"),
                            result.getString("nome"),
                            result.getString("cpf"),
                            result.getDate("data_nasc"),
                            result.getInt("telefone")
                            );
                    System.out.println(cliente);
                    }
                    con.close();
                    } catch (SQLException e) {
                    System.out.println(e.getMessage());
                    }
                    break;

                    case 9:
                    System.out.println("\n Obrigado por usar o programa! :D ");
                    System.out.println(" TCHAU TCHAU \n");
                    break;

                }

                }while(escolha != 9);
                scan1.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
    
}