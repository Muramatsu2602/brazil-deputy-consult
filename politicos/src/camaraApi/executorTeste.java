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
import org.json.JSONException;
import java.util.Scanner;
import java.util.List;

public class executorTeste {
    
    public static void main(String args[]) throws JSONException{
        
        String pesquisa = "pt";
        /*try (Scanner sc1 = new Scanner(System.in)) {
            pesquisa = sc1.next();
        }*/
        List<Discurso> y = Capi.mostraDiscursos("204536");
        for(int x = 0; x < y.size() ; x++){
            System.out.println(y.get(x).getDataHoraFim() + "\n");
        }
}////main
}//executorTeste
