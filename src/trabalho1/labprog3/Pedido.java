/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho1.labprog3;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Marcus
 */
public class Pedido {
    private int codigo;
    private List<Item> itens;
    private Date inicio;
    private Date fim;
    private boolean status;
    private double total;
    public Pedido() {
        this.itens = new ArrayList<>();
        
    }
    public Pedido(int codigo, Date inicio){
        this.codigo = codigo;
        this.itens = new ArrayList<>();
        this.inicio = inicio;
        this.status=true;
        this.total = 0;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Date getInicio() {
        return inicio;
    }

    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }

    public Date getFim() {
        return fim;
    }

    public void setFim(Date fim) {
        this.fim = fim;
    }

    public List<Item> getItens() {
        return itens;
    }

    public void setItens(List<Item> itens) {
        this.itens = itens;
    }
    public String imprimeItens(){
        SimpleDateFormat s = new SimpleDateFormat("HH:mm:ss");
        String valor="";
        s.setLenient(false);
        String dataFormatada = s.format(this.getInicio());
        valor+="Inicio: "+dataFormatada;
        if(this.getFim()!=null){
            String finalFormatado = s.format(this.getFim());
            valor+= "   Fim: " + finalFormatado +"\n";
        }else{
            valor+="\n";
        }
        for (Item item : itens) {
            valor+= item.toString() + "\n";
        }
        
        if(total>0){
            DecimalFormat formato = new DecimalFormat();
            formato.setMaximumFractionDigits(2);
            formato.setMinimumFractionDigits(2);
            valor+="Total Pedido: " + formato.format(this.getTotal());
        }
        
        return valor;
    }
    @Override
    public String toString() {
        String retorno = "Pedido "+ this.getCodigo();
        if(this.status){
            retorno+= " (aberto)";
        }else{
            retorno+=" (fechado)";
        }
        return  retorno;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double valor) {
        this.total = valor;
    }
    public void calculaPreco(){
        this.total = 0;
        for(Item item: itens){
            this.total+= item.getPreco()*item.getQuantidade();
        }
        
    }
}
