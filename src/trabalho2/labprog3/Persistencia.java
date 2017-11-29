/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho2.labprog3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author Marcus
 */
public class Persistencia {
    
    void escreverArquivo(List<Mesa> mesas) throws IOException{
        FileWriter arq = new FileWriter("dados.txt");
        PrintWriter gravaArq = new PrintWriter(arq);
        gravaArq.println(mesas.size()+" Mesas");
        for(Mesa m:mesas){
            gravaArq.println("Mesa "+m.getNumero());
            gravaArq.println(m.getPedidos().size()+ " Pedidos");
            for(Pedido p:m.getPedidos()){
                if(p.getFim()==null){
                    gravaArq.println(p.getCodigo()+ " "+ p.imprimeData(p.getInicio()) + " " + p.isStatus() + " "+ p.getFim());
                }else{
                    gravaArq.println(p.getCodigo()+ " "+ p.getInicio().getTime() + " " + p.isStatus() + " "+ p.imprimeData(p.getFim()));
                }
                
                gravaArq.println(p.getItens().size()+ " Itens");
                for(Item i:p.getItens()){
                    gravaArq.println(i.getNome()+ " "+ i.getQuantidade() + " " + i.getPreco());
                }


            }

        }
        arq.close();
        
        
    }
    List<Mesa> lerArquivo() throws FileNotFoundException, IOException, ParseException{
        FileReader arq = new FileReader("dados.txt");
        BufferedReader lerArq = new BufferedReader(arq);
        String linha = lerArq.readLine();
        String dados[] = linha.split(" ");
        int num_mesas = Integer.parseInt(dados[0]);
        List<Mesa> mesas = new ArrayList<>();
        for(int i=0; i<num_mesas; i++){
            linha = lerArq.readLine();
            dados= linha.split(" ");
            Mesa m = new Mesa(Integer.parseInt(dados[1]));
            linha = lerArq.readLine();
            dados = linha.split(" ");
            int num_pedidos= Integer.parseInt(dados[0]);
            for(int j=0; j<num_pedidos;j++){
                SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                formato.setLenient(false);
                linha = lerArq.readLine();
                dados = linha.split(" ");
                int codigo = Integer.parseInt(dados[0]);
                String data = dados[1]+ " "+dados[2]; 
                System.out.println(data);
                Calendar inicio = Calendar.getInstance();
                inicio.setTime(formato.parse(data));
                boolean status = Boolean.parseBoolean(dados[3]);
                Calendar fim = Calendar.getInstance();
                if(status){
                    fim = null;
                }else{
                    String datafim = dados[4]+ " "+dados[5];
                    fim.setTime(formato.parse(datafim));
                }
                linha = lerArq.readLine();
                dados = linha.split(" ");
                int num_itens = Integer.parseInt(dados[0]);
                Pedido p = new Pedido(codigo, inicio);
                for(int k=0; k< num_itens; k++){
                    linha = lerArq.readLine();
                    dados = linha.split(" ");
                    p.getItens().add(new Item(dados[0], Integer.parseInt(dados[1]), Float.parseFloat(dados[2])));
                    
                }
                m.getPedidos().add(p);
            }
            
            
            
            
            mesas.add(m);
//            escreverArquivo(mesas);
        }
        return mesas;
    }
}
