/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho1.labprog3;

import java.text.DecimalFormat;

/**
 *
 * @author Marcus
 */
public class Item {
    private String nome;
    private int quantidade;
    private double preco;
    public Item(String nome, int quantidade, double preco) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.preco = preco;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        DecimalFormat formato = new DecimalFormat();
        formato.setMaximumFractionDigits(2);
        formato.setMinimumFractionDigits(2);
        return this.getQuantidade() + "  " + this.getNome()+ "   R$" +formato.format(this.preco);
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
    
}
