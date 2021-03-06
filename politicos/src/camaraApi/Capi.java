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
    public static ArrayList<String> getPartidos() throws JSONException{
     /*   CapiConexao dados_camara;
        dados_camara = new CapiConexao();
        JSONObject my_obj = new JSONObject(dados_camara.getPartidos());
        JSONArray array_partidos;
        try{array_partidos = my_obj.getJSONArray("dados");}
        catch(JSONException e){array_partidos = null; System.exit(1);}
        JSONObject obj;*/
        ArrayList<String> siglas = new ArrayList<>();
        CapiConexao dados_camara;
        dados_camara = new CapiConexao();
        JSONObject my_obj = new JSONObject(dados_camara.getInfo());
        JSONArray array_deputados = my_obj.getJSONArray("dados");
        JSONObject obj;
        List<Deputado> dep = new ArrayList<>();
        String sigla;
         for(int x = 0; x<array_deputados.length(); x++){
          //  System.out.println("(" + x + ") " + array_deputados.get(x));
            obj = new JSONObject(array_deputados.get(x).toString());
            dep.add(new Deputado(obj));
        }//for
        for(int x = 0; x<dep.size(); x++){
          /* System.out.println("(" + x + ") " + array_deputados.get(x));
            obj = new JSONObject(array_deputados.get(x).getString("siglas"));
            System.out.println(array_deputados.get(x).toString());
            sigla = obj.getString("sigla");*/
            sigla = dep.get(x).getSiglaPartido();
            siglas.add(sigla);
        }//for
        
        return removeDuplicates(siglas);
    } 
   public static <T> ArrayList<T> removeDuplicates(ArrayList<T> list) 
    { 
  
        // Create a new ArrayList 
        ArrayList<T> newList = new ArrayList<T>(); 
  
        // Traverse through the first list 
        for (T element : list) { 
  
            // If this element is not present in newList 
            // then add it 
            if (!newList.contains(element)) { 
                   System.out.println(element);
                newList.add(element); 
            } 
        } 
  
        // return the new list 
        return newList; 
    }  
    public static List<Discurso> mostraDiscursos(String id) throws JSONException {
        CapiConexao dados_camara;
        dados_camara = new CapiConexao();
        JSONObject my_obj = new JSONObject(dados_camara.getInfo(id+"/discursos?ordenarPor=dataHoraInicio&ordem=ASC"));
        JSONArray array_discursos;
        try{array_discursos = my_obj.getJSONArray("dados");}
        catch(JSONException e){array_discursos = null; System.exit(1);}
        JSONObject obj;
        List<Discurso> dis = new ArrayList<>();

        for(int x = 0; x<array_discursos.length(); x++){
          //  System.out.println("(" + x + ") " + array_deputados.get(x));
            obj = new JSONObject(array_discursos.get(x).toString());
            dis.add(new Discurso(obj));
        }//for
        return dis;
    }////mostraDiscursos
    
     public static Deputado pesquisaDeputadoEspecifico(String id) throws JSONException{
        CapiConexao dados_camara;
        dados_camara = new CapiConexao();
        JSONObject my_obj = new JSONObject(dados_camara.getInfo(id));
        JSONObject deputado_info;
        try{deputado_info = my_obj.getJSONObject("dados");}
        catch(JSONException e){deputado_info = null; System.exit(1);}
        Deputado dep = new Deputado(deputado_info);
        return dep;
    }////pesquisaDeputadoEspecifico
}//executorTeste
