/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package camaraApi;

import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author ra1757036
 */
public class Deputado {
    private int id;
    private String uri;
    private String nome;
    private String siglaPartido;
    private String uriPartido;
    private String siglaUf;
    private int idLegislatura;
    private String urlFoto;
    private String email;
    
    Deputado(JSONObject deputado) throws JSONException{
       this.id = deputado.getInt("id");
       this.uri = deputado.getString("uri");
       this.nome = deputado.getString("nome");
       this.siglaPartido = deputado.getString("siglaPartido");
       this.uriPartido = deputado.getString("uriPartido");
       this.siglaUf = deputado.getString("siglaUf");
       this.idLegislatura = deputado.getInt("idLegislatura");
       this.urlFoto = deputado.getString("urlFoto");
       this.email = deputado.getString("email");
    }

    Deputado() {
        this.id = 0;
       this.uri = "";
       this.nome = "";
       this.siglaPartido = "";
       this.uriPartido = "";
       this.siglaUf = "";
       this.idLegislatura = 0;
       this.urlFoto = "";
       this.email = "";
    }
    public int getId(){
        return this.id;
    }
    public void setId(int id){
        this.id = id;
    }
    
    public String getUri(){
        return this.uri;
    }
    public void setUri(String uri){
        this.uri = uri;
    }
    
      public String getNome(){
        return this.nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    
      public String getSiglaPartido(){
        return this.siglaPartido;
    }
    public void setSiglaPartido(String siglaPartido){
        this.siglaPartido = siglaPartido;
    }
    
      public String getUriPartido(){
        return this.uriPartido;
    }
    public void setUriPartido(String uriPartido){
        this.uriPartido = uriPartido;
    }
    
      public String getSiglaUf(){
        return this.siglaUf;
    }
    public void setSiglaUf(String siglaUf){
        this.siglaUf = siglaUf;
    }
    
      public int getIdLegislatura(){
        return this.idLegislatura;
    }
    public void setIdLegislatura(int idLegislatura){
        this.idLegislatura = idLegislatura;
    }
    
      public String getUrlFoto(){
        return this.urlFoto;
    }
        public void setUrlFoto(String urlFoto){
        this.urlFoto = urlFoto;
    }
    
      public String getEmail(){
        return this.email;
    }
        public void setEmail(String email){
        this.email = email;
    }
}
