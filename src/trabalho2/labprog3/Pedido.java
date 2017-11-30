/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho2.labprog3;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Marcus
 */
public class Pedido {
    private int codigo;
    private List<Item> itens;
    private Calendar inicio;
    private Calendar fim;
    private boolean status;
    private double total;
    public Pedido() {
        this.itens = new ArrayList<>();
        
    }
    public Pedido(int codigo, Calendar inicio){
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

    public Calendar getInicio() {
        return inicio;
    }

    public void setInicio(Calendar inicio) {
        this.inicio = inicio;
    }

    public Calendar getFim() {
        return fim;
    }

    public void setFim(Calendar fim) {
        this.fim = fim;
    }

    public List<Item> getItens() {
        return itens;
    }

    public void setItens(List<Item> itens) {
        this.itens = itens;
    }
    public String imprimeData(Calendar data){
        if(data == null) System.out.println("Nulo");
        System.out.println("Entrou     "+ data.getTime());
        String dataFormatada =data.get(Calendar.DATE)+"/"
                +data.get(Calendar.MONTH) + "/"
                +data.get(Calendar.YEAR)+ " "
                +data.get(Calendar.HOUR)+":"
                +data.get(Calendar.MINUTE)+":"+
                data.get(Calendar.SECOND);
        return dataFormatada;
    }
    public String imprimeItens(){
        String valor="";
        
        String dataFormatada = this.getInicio().get(Calendar.HOUR)+":"
                +this.getInicio().get(Calendar.MINUTE)+":"+
                this.getInicio().get(Calendar.SECOND);
        valor+="Inicio: "+dataFormatada;
        if(this.getFim()!=null){
            String finalFormatado = this.getFim().get(Calendar.HOUR)+":"
                +this.getFim().get(Calendar.MINUTE)+":"+
                this.getFim().get(Calendar.SECOND);
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
