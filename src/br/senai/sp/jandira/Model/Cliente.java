package br.senai.sp.jandira.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cliente {

private String nome;
private long cpf, rg, telefone;

private  int valorTransferencia;

List<Cliente> lisCliente = new ArrayList<>();

Scanner scanner = new Scanner(System.in);

public void cadastrarCliente(){

    System.out.println("informe se Nome: ");
    nome = scanner.next();
    System.out.println("informe seu cpf :");
    cpf = scanner.nextLong();
    System.out.println("informe seu rg: ");
    rg = scanner.nextLong();
    System.out.println("informe seu telefone: ");
    telefone = scanner.nextLong();
    scanner.nextLine();
}

public String getNome(){
    return nome;
}
public void setNome(String nome){
   this.nome = nome;
}

public long getCpf(){
    return  cpf;
}

public void setRg(long rg) {
        this.rg = rg;
    }

    public long getRg(){
      return rg;
    }

    public void setCpf(long cpf) {
        this.cpf = cpf;
    }

    public long getTelefone() {
        return telefone;
    }

    public void setTelefone(long telefone) {
        this.telefone = telefone;
    }

    // dar o get no saldo!

    public void adicionarList(Cliente cliente){
      lisCliente.add(cliente);
    }

    public  void listarClientes(){
    for (Cliente cliente :lisCliente){
        System.out.println(cliente.getNome());
    }
    }

    public Cliente pesquisarCliente(long cpf){
        for (Cliente cliente : lisCliente){
            long cpfCliente = cliente.getCpf();

            if (cpfCliente == cpf){
                return cliente;
            }
        }
        return null;
    }

    // codigo o valor da transferencia!
    public void realizarTranferencia(Conta conta){
        System.out.println("feature in development");
    }

}
