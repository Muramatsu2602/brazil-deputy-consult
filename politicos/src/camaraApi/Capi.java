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
import org.json.JSONObject;
import org.json.JSONArray;
import java.util.ArrayList;
import java.util.List;


public class Capi {
 
    public static List<Deputado> mostraDeputados() throws JSONException {
        CapiConexao dados_camara;
        dados_camara = new CapiConexao();
        JSONObject my_obj = new JSONObject(dados_camara.getInfo());
        JSONArray array_deputados = my_obj.getJSONArray("dados");
        JSONObject obj;
        List<Deputado> dep = new ArrayList<>();

        for(int x = 0; x<array_deputados.length(); x++){
          //  System.out.println("(" + x + ") " + array_deputados.get(x));
            obj = new JSONObject(array_deputados.get(x).toString());
            dep.add(new Deputado(obj));
        }//for
        return dep;
    }////mostraDeputados()
    public static List<Deputado> pesquisaDeputados(String op, String pesquisa, List<Deputado> dep){
       
         List<Deputado> result = new ArrayList<>();
        for(int x = 0; x < dep.size(); x++){
              if(op.equals("id")){//se a pesquisa for por id
                 if( dep.get(x).getId().equals(pesquisa))
                   result.add(dep.get(x));
              }
                 if(op.equals("nome")){//se a pesquisa for por nome
                     if( dep.get(x).getNome().toLowerCase().contains(pesquisa.toLowerCase()))
                      result.add(dep.get(x)); 
                 }      
                 if(op.equals("partido")){//se a pesquisa for por partido
                      if( dep.get(x).getSiglaPartido().toLowerCase().equals(pesquisa.toLowerCase()))
                      result.add(dep.get(x)); 
                  }       
        }            
            
        return result;
    }////pesquisaDeputados
    
    public static List<Discurso> mostraDiscursos(String id) throws JSONException {
        CapiConexao dados_camara;
        dados_camara = new CapiConexao();
        JSONObject my_obj = new JSONObject(dados_camara.getInfo(id+"/discursos?ordenarPor=dataHoraInicio&ordem=ASC"));
        JSONArray array_deputados;
        try{array_deputados = my_obj.getJSONArray("dados");}
        catch(JSONException e){array_deputados = null; System.exit(1);}
        JSONObject obj;
        List<Discurso> dis = new ArrayList<>();

        for(int x = 0; x<array_deputados.length(); x++){
          //  System.out.println("(" + x + ") " + array_deputados.get(x));
            obj = new JSONObject(array_deputados.get(x).toString());
            dis.add(new Discurso(obj));
        }//for
        return dis;
    }////mostraDiscursos
}//executorTeste
