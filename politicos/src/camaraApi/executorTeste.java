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
 
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONArray;
import java.util.Scanner;


public class executorTeste {
    
    public static void main(String args[]) throws JSONException{
        
        
    
        String pesquisa;
        try (Scanner sc1 = new Scanner(System.in)) {
            pesquisa = sc1.next();
        }
        
        camaraApi dados_camara = new camaraApi();
        JSONObject my_obj = new JSONObject(dados_camara.getInfo());
        JSONArray array_deputados = my_obj.getJSONArray("dados");
        JSONObject obj;
        Deputado dep = new Deputado();
        System.out.println("aa"+dados_camara.getInfo());
        
        for(int x = 0; x<array_deputados.length(); x++){
          //  System.out.println("(" + x + ") " + array_deputados.get(x));
            obj = new JSONObject(array_deputados.get(x).toString());
            System.out.println("nome do gloriosissimo cidadao: " + obj.getString("nome"));
            if(obj.getString("nome").toLowerCase().contains(pesquisa.toLowerCase())){
              dep = new Deputado(obj);
              break;
            }
        }
        
        System.out.println("\n\nINFO DEP:\n" +
                            "id - " +dep.getId() + "\n" +
                           "nome - " +dep.getNome() + "\n"  +                  
                           "id legis - " +dep.getIdLegislatura()+ "\n" + 
                           "sigla partido - " +dep.getSiglaPartido()+ "\n" + 
                           "foto - " +dep.getUrlFoto()+ "\n" + 
                           "Sigla uf - " +dep.getSiglaUf() + "\n" + 
                           "uri partido - " +dep.getUriPartido());
        
       
         
        
}
}
