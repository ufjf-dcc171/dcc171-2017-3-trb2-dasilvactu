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
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
            gravaArq.println(m.getPedidos().size()+ " Pedidos");
            for(Pedido p:m.getPedidos()){
                gravaArq.println(p.getCodigo()+ " "+ p.getInicio() + " " + p.isStatus() + " "+ p.getFim());
                gravaArq.println(p.getItens().size()+ " Itens");
                for(Item i:p.getItens()){
                    gravaArq.println(i.getNome()+ " "+ i.getQuantidade() + " " + i.getPreco());
                }
                
                
            }
                      
        }
        arq.close();
        
        
    }
    void lerArquivo() throws FileNotFoundException, IOException, ParseException{
        FileReader arq = new FileReader("dados.txt");
        BufferedReader lerArq = new BufferedReader(arq);
        String linha = lerArq.readLine();
        String dados[] = linha.split(" ");
        int num_mesas = Integer.parseInt(dados[0]);
        List<Mesa> mesas = new ArrayList<>();
        for(int i=0; i<num_mesas; i++){
            Mesa m = new Mesa(i+1);
            linha = lerArq.readLine();
            dados = linha.split(" ");
            int num_pedidos= Integer.parseInt(dados[0]);
            for(int j=0; j<num_pedidos;j++){
                SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                linha = lerArq.readLine();
                dados = linha.split(" ");
                int num_itens = Integer.parseInt(dados[0]);
                linha = lerArq.readLine();
                dados = linha.split(" ");
                int codigo = Integer.parseInt(dados[0]);
                String data = dados[1]+ " "+dados[2] + " "+ dados[3] + " " + dados[4] + " "+ dados[5] + " "+ dados[6]; 
                Date inicio = formato.parse(data);
                boolean status = Boolean.parseBoolean(dados[7]);
                Date fim;
                if(status){
                    fim = null;
                }else{
                    String datafim = dados[8]+ " "+dados[9] + " "+ dados[10] + " " + dados[11] + " "+ dados[12] + " "+ dados[13];
                    fim = formato.parse(datafim);
                }
                Pedido p = new Pedido(codigo, inicio);
            }
            
            
            
            
            mesas.add(m);
            
        }
    }
}
