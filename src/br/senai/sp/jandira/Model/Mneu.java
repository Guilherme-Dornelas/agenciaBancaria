package br.senai.sp.jandira.Model;

import java.util.Scanner;

public class Mneu {

    Scanner scanner  = new Scanner(System.in);
    Cliente referenciaCliente = new Cliente();
    Conta referencaConta = new Conta();
    public  void executarMenu(){

        boolean exit = false;

        while (!exit) {
            System.out.println("/--//-/-//-/-//-/ Mneu .././././../././../././.");
            System.out.println("1 cadastrar Cliente");
            System.out.println("2 Gerar Conta");
            System.out.println("3 Consultar saldo");
            System.out.println("4 Realizar um saque");
            System.out.println("5 Realizar Deposito");
            System.out.println("6 Realizar tranferencia");
            System.out.println("7 sair");
            System.out.println(";/;/;/./,././/;/,/.//,././,//././/,././;//.l..;");

            int optionUser = scanner.nextInt();

            switch (optionUser) {
                case 1:
                    Cliente cliente = new Cliente();
                    cliente.cadastrarCliente();
                    referenciaCliente.adicionarList(cliente);
                    break;
                case 2:
                    Conta conta = new Conta();

                    System.out.println("informe o cpf do cliente: ");
                    long cpfCliente = scanner.nextLong();

                   Cliente clienteConta = referenciaCliente.pesquisarCliente(cpfCliente);

                   if (clienteConta != null){
                       referencaConta.gerarConta(clienteConta);
                       referencaConta.adicionarContaList(conta);
                       System.out.println("conta gerada com sucesso !");
                   }else {
                       System.out.println("Cliente nao cadastrado");
                   }
                case 3:
                    System.out.println("informe o cpf");
                    long cpfSaldo = scanner.nextLong();
                    scanner.nextLine();
                    referencaConta.pesquisarConta(cpfSaldo);
                    Conta contaSaldo = referencaConta.pesquisarConta(cpfSaldo);
                    if (contaSaldo != null){
                        contaSaldo.consultarSaldo();
                    }else {
                        System.out.println("o cliente nao tem uma conta");
                    }
                    break;
                case 4:
                    System.out.println("informe o cpf do cliente!");
                    long cpfSaque = scanner.nextLong();
                    Conta contaSaque = referencaConta.pesquisarConta(cpfSaque);

                    if (contaSaque != null){
                        System.out.println("informe quanto deseja sacar");
                        double valorSaque = scanner.nextDouble();


                        contaSaque.realizarSaque(valorSaque);
                    }else {
                        System.out.println("conta nao encontrada");
                    }

                    break;
                case 5:
                    System.out.println("informe o cpf: ");
                    long cpfDeposito = scanner.nextLong();
                     Conta contaDeposito = referencaConta.pesquisarConta(cpfDeposito);

                     if (contaDeposito != null){
                         System.out.println("informe o valor para deposito: ");
                         double valorDeposito = scanner.nextDouble();
                         contaDeposito.realizarDeposito(valorDeposito);
                     }else {
                         System.out.println("o cliente nao tem conta...");
                     }


                    break;
                case 6:
                    System.out.println("Infome o seu CPF: ");
                    long cpfUser = scanner.nextLong();

                    System.out.println("Informe o CPF que deseja transferir: ");
                    long cpfTransferencia = scanner.nextLong();

                    Conta contaUser = referencaConta.pesquisarConta(cpfUser);
                    Conta contaTransferencia = referencaConta.pesquisarConta(cpfTransferencia);

                    if ( contaUser != null && contaTransferencia != null ){
                        referencaConta.realizarTransferencia(contaUser, contaTransferencia);

                    } else {
                        System.out.println("Verifique os CPF´s informados...");
                    }

                    break;

                case 7:
                    exit = true;
                    break;
                default:
                    System.out.println("obrigado por utilizar nosso banco !");
            }
        }
    }
}
