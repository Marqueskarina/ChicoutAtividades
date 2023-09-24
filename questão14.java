package br.edu.uniaeso;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class questao14 
{
    class ContaBancaria implements Serializable {
    private static final long serialVersionUID = 1L; // Número de versão da serialização
    private String nomeTitular;
    private double saldo;

    public ContaBancaria(String nomeTitular, double saldo) {
        this.nomeTitular = nomeTitular;
        this.saldo = saldo;
    }

    // Getters e setters

    public String getNomeTitular() {
        return nomeTitular;
    }

    public void setNomeTitular(String nomeTitular) {
        this.nomeTitular = nomeTitular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}

public static class AtualizarContaBancaria {
    public static void main(String[] args) {
        // Carregar o objeto serializado da classe ContaBancaria do arquivo "conta.dat"
        ContaBancaria conta = null;
        try (FileInputStream fileIn = new FileInputStream("conta.dat");
             ObjectInputStream objectIn = new ObjectInputStream(fileIn)) {
            conta = (ContaBancaria) objectIn.readObject();
            System.out.println("Conta carregada: " + conta.getNomeTitular() + ", Saldo: " + conta.getSaldo());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        // Atualizar o saldo da conta
        if (conta != null) {
            conta.setSaldo(conta.getSaldo() + 1000.0); // Adicionando 1000 ao saldo (por exemplo)
        }

        // Serializar o objeto atualizado de volta ao arquivo "conta.dat"
        try (FileOutputStream fileOut = new FileOutputStream("conta.dat");
             ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {
            objectOut.writeObject(conta);
            System.out.println("Conta atualizada e salva: " + conta.getNomeTitular() + ", Saldo: " + conta.getSaldo());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
}