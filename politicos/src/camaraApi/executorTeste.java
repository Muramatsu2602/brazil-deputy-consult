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

public class executorTeste {
    
    public static void main(String args[]) throws JSONException{
        
        camaraApi x = new camaraApi();
        System.out.println("aa"+x.getInfo());
        JSONObject my_obj = new JSONObject(x.getInfo());
        String dados = my_obj.getString("dados");
        System.out.println("asc" + dados);
        JSONArray uau = my_obj.getJSONArray("dados");
        System.out.println("(" + 0 + ") " + uau.get(0));
       JSONObject obj = new JSONObject(uau.get(0).toString());
        System.out.println("nome do gloriosissimo cidadao: " + obj.getString("nome"));
         
        
}
}
