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
    private String id;
    private String uri;
    private String nome;
    private String siglaPartido;
    private String uriPartido;
    private String siglaUf;
    private String idLegislatura;
    private String urlFoto;
    private String email;
    private String municipioNascimento;
    private String escolaridade;
    private String cpf;
    
    Deputado(JSONObject deputado) throws JSONException{
       this.id = Integer.toString(deputado.getInt("id"));
       this.uri = deputado.getString("uri");
      
    
       try{
           this.nome = deputado.getString("nome");
           this.siglaPartido = deputado.getString("siglaPartido");
           this.uriPartido = deputado.getString("uriPartido");
           this.siglaUf = deputado.getString("siglaUf");
           this.idLegislatura = Integer.toString(deputado.getInt("idLegislatura"));
           this.urlFoto = deputado.getString("urlFoto");
           this.email = deputado.getString("email");
        }catch(JSONException e){
            JSONObject ultimoStatus = deputado.getJSONObject("ultimoStatus");
            this.nome = ultimoStatus.getString("nomeEleitoral");
            this.siglaPartido = ultimoStatus.getString("siglaPartido");
            this.uriPartido = ultimoStatus.getString("uriPartido");
            this.siglaUf = ultimoStatus.getString("siglaUf");
            this.idLegislatura = Integer.toString(ultimoStatus.getInt("idLegislatura"));
            this.urlFoto = ultimoStatus.getString("urlFoto");
            this.email = ultimoStatus.getString("email");
        }
       
        try{
            this.municipioNascimento = deputado.getString("municipioNascimento");
        }catch(JSONException e){
            this.municipioNascimento = "";
        }
         try{
            this.escolaridade = deputado.getString("escolaridade");
        }catch(JSONException e){
            this.escolaridade = "";
        }
         try{
            this.cpf = deputado.getString("cpf");
        }catch(JSONException e){
            this.cpf = "";
        }
    }

    Deputado() {
        this.id = "";
       this.uri = "";
       this.nome = "";
       this.siglaPartido = "";
       this.uriPartido = "";
       this.siglaUf = "";
       this.idLegislatura = "";
       this.urlFoto = "";
       this.email = "";
    }
    public String getId(){
        return this.id;
    }
    public void setId(String id){
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
    
      public String getIdLegislatura(){
        return this.idLegislatura;
    }
    public void setIdLegislatura(String idLegislatura){
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
         public String getMunicipioNascimento(){
        return this.municipioNascimento;
    }
        public void setMunicipioNascimento(String municipioNascimento){
        this.municipioNascimento = municipioNascimento;
    }
         public String getEscolaridade(){
        return this.escolaridade;
    }
        public void setEscolaridade(String escolaridade){
        this.escolaridade = escolaridade;
    }
         public String getCpf(){
        return this.cpf;
    }
        public void setCpf(String cpf){
        this.cpf = cpf;
    }
}
