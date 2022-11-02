package Programa;

import utils.Utils;

public class Conta {
	private static int countConta = 1;
	private int numberConta;
	private Usuario usuario;
	private Double balance = 0.0;

	public Conta(Usuario usuario) {
		this.numberConta = countConta;
		this.usuario = usuario;
		countConta += 1;
	}

	public int getNumberConta() {
		return numberConta;
	}

	public void setNumberConta(int numberConta) {
		this.numberConta = numberConta;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public String toString() {
		return "\nNumero Conta: " + getNumberConta() + "\nNome: " + this.usuario.getNome() + "\nCPF: "
				+ this.usuario.getCpf() + "\nEmail: " + this.usuario.getEmail() + "\n Saldo: "
				+ Utils.doubleToString(getBalance()) + "\n";
	}

	public void depositBalance(Double value) {
		if (value > 0) {
			setBalance(getBalance() + value);
			System.out.println("Seu saldo foi depósitado com sucesso!");
		} else {
			System.out.println("Erro ao depositar! Entre em contato com a agência!");
		}
	}

	public void takeBalance(Double value) {
		if (value > 0 && getBalance() >= value) {
			setBalance(getBalance() - value);
			System.out.println("Saque de: " + value + "feito com sucesso");
		} else {
			System.out.println("Erro ao sacar! Entre em contato com a agência!");
		}
	}

	public void transferBalance(Conta accountTransfer, Double value) {
		if (value > 0 && getBalance() >= value) {
			setBalance(getBalance() - value);
			accountTransfer.balance = accountTransfer.getBalance() + value;
			System.out.println("Transferência realizada com sucesso!");
		} else {
			System.out.println("Erro ao transferir! Entre em contato com a agência!");
		}
	}

}
