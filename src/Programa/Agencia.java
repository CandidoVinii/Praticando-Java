package Programa;

import java.util.ArrayList;
import java.util.Scanner;

public class Agencia {

	static Scanner input = new Scanner(System.in);
	static ArrayList<Conta> accountsBank;

	public static void main(String[] args) {
		accountsBank = new ArrayList<Conta>();
		operations();
	}

	public static void operations() {
		System.out.println("------------------------------------------------------");
		System.out.println("-------------Bem vindos a nossa Agência---------------");
		System.out.println("------------------------------------------------------");
		System.out.println("***** Selecione uma operação que deseja realizar *****");
		System.out.println("------------------------------------------------------");
		System.out.println("|   Opção 1 - Criar conta   |");
		System.out.println("|   Opção 2 - Depositar     |");
		System.out.println("|   Opção 3 - Sacar         |");
		System.out.println("|   Opção 4 - Transferir    |");
		System.out.println("|   Opção 5 - Listar        |");
		System.out.println("|   Opção 6 - Sair          |");

		int operation = input.nextInt();

		switch (operation) {
		case 1:
			createAccount();
			break;
		case 2:
			deposit();
			break;
		case 3:
			takeOut();
			break;
		case 4:
			transfer();
			break;
		case 5:
			list();
			break;
		case 6:
			System.out.println("Deslogado do sistema.");
			System.exit(0);

		default:
			System.out.println("Opção inválida!");
			operations();
			break;
		}
	}

	public static void createAccount() {
		System.out.println("\nNome: ");
		String nome = input.next();

		System.out.println("\nCPF: ");
		String cpf = input.next();

		System.out.println("\nEmail: ");
		String email = input.next();


		Usuario usuario = new Usuario(nome, cpf, email);

		Conta conta = new Conta(usuario);

		accountsBank.add(conta);
		System.out.println("Conta criada com sucesso");

		operations();
	}

	private static Conta foundAccount(int accountNumber) {
		Conta conta = null;
		if (accountsBank.size() > 0) {
			for (Conta c : accountsBank) {
				if (c.getNumberConta() == accountNumber) {					
					conta = c;
				}
			}
		}
		return conta;
	}

	public static void deposit() {
		System.out.println("Número da conta: ");
		int accountNumber = input.nextInt();

		Conta conta = foundAccount(accountNumber);

		if (conta != null) {
			System.out.println("Qual valor quer depositar?");
			Double valueDeposit = input.nextDouble();
			conta.depositBalance(valueDeposit);
			System.out.println("Valor depositado com sucesso");
		} else {
			System.out.println("Conta não encontrada");
		}
		operations();
	}

	public static void takeOut() {
		System.out.println("Número da conta: ");
		int accountNumber = input.nextInt();

		Conta conta = foundAccount(accountNumber);

		if (conta != null) {
			System.out.println("Qual valor quer sacar?");
			Double valueTake = input.nextDouble();
			conta.takeBalance(valueTake);
		} else {
			System.out.println("Conta não encontrada");
		}
		operations();
	}

	public static void transfer() {
		System.out.println("Número da conta do remetente: ");
		int accountNumber = input.nextInt();

		Conta conta = foundAccount(accountNumber);
		if (conta != null) {
			System.out.println("Número da conta do destinário");
			int accountNumberReceive = input.nextInt();

			Conta receiveAccount = foundAccount(accountNumberReceive);
			if (receiveAccount != null) {
				System.out.println("Valor da transferência: ");
				Double value = input.nextDouble();

				conta.transferBalance(receiveAccount, value);
			}else {
				System.out.println("A conta para deposito não foi encontrada");
			}
		} else {
			System.out.println("A conta para transferência não foi encontrada");
		}
		operations();
	}

	public static void list() {
		if (accountsBank.size() > 0) {
			for (Conta conta : accountsBank) {
				System.out.println(conta);
			}
		} else {
			System.out.println("Nenhuma conta cadastrada");
		}
		operations();
	}
}
