/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package camaraApi;

/**
 *
 * @author ra1757036
 */
public class Deputados {
    private String id;
    private String uri;
    private String nome;
    private String siglaPartido;
    private String uriPartido;
    private String siglaUf;
    private String idLegislatura;
    private String urlFoto;
    private String email;
    
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
        this.id = urlFoto;
    }
    
      public String getEmail(){
        return this.email;
    }
        public void setEmail(String email){
        this.email = email;
    }
}
