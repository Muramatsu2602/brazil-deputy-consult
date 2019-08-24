/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



/**
 *
 * @author Lucas
*/
package camaraApi;
 
//import java.io.IOException;
import banco.BancoUsuarios;
import org.json.JSONException;
import java.util.Scanner;
import java.util.List;

public class executorTeste {
    
    public static void main(String args[]) throws JSONException{
        
        String pesquisa = "pt";
        /*try (Scanner sc1 = new Scanner(System.in)) {
            pesquisa = sc1.next();
        }*/
    
        
        
        Deputado y = Capi.pesquisaDeputadoEspecifico("204536");
        
            System.out.println(y.getCpf() + "\n");
        
}////main
}//executorTeste
