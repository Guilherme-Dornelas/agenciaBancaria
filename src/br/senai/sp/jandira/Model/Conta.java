package br.senai.sp.jandira.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Conta {
    private  int numeroConta;
    private String agencia = "3606-xx";
    private  double saldo = 0;

    private Cliente cliente;

    Scanner scanner = new Scanner(System.in);

    List<Conta> lisCont = new ArrayList<>();


    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Conta pesquisarConta(long cpf){
        for ( Conta conta: lisCont) {
            long avaliaCpf = conta.cliente.getCpf();
            if (avaliaCpf == cpf){
                return conta;
            }
        }
         return null;
    }
    public void adicionarContaList(Conta conta){
        lisCont.add(conta);

    }

    public void gerarConta(Cliente cliente){
        System.out.println("-//- Gerando conta ----/-//-/-/-/-");

        numeroConta = (int) (Math.random()*10000);
        this.cliente = cliente;
    }
    public void realizarSaque(double valor){
        boolean validaSaque = avaliarSaque(valor);
        if (validaSaque){
            this.saldo -= valor;

        } else {
            System.out.println("impossivel realizar saque !");
        }
        System.out.println("seu saldo disponivel e de:  " + this.saldo);
    }

    public  void realizarDeposito(double valor){
        this.saldo += valor;
        System.out.println("seu saldo e de:  " + this.saldo);

    }

    public void consultarSaldo(){
        System.out.println("seu saldo e de:  " + this.saldo);
    }

    public boolean avaliarSaque( double valor){
        if (this.saldo >= valor){
            return true;
        }else {
            return false;
        }
    }

    public void realizarTransferencia(Conta contaUser, Conta contaTransferencia){

        System.out.println("Informe um valor para Transferir: ");
        double valorTransferencia = scanner.nextDouble();
        scanner.nextLine();

        double saldoConta = contaUser.getSaldo();

        if (saldoConta >= valorTransferencia){
            saldoConta -= valorTransferencia;
            contaUser.setSaldo(saldoConta);

            double saldoContaUser2 = contaTransferencia.getSaldo();
            saldoContaUser2 += valorTransferencia;
            contaTransferencia.setSaldo(saldoContaUser2);

            System.out.println("Transferência Realizada com Sucesso !");

        } else {
            System.out.println("Você não tem saldo disponivel na conta...");
        }


    }

}
