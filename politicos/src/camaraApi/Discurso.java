/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package camaraApi;

import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Lucas
 */
public class Discurso {
    private String titulo;
    private String tipoDiscurso;
    private String dataHoraInicio;
    private String dataHoraFim;
    private String sumario;
    private String transcricao;
    
    
    Discurso(JSONObject discurso) throws JSONException{
        JSONObject faseEvento = discurso.getJSONObject("faseEvento");
        try{
            this.titulo = faseEvento.getString("titulo");
        }catch(JSONException e){
            this.titulo = "";
        }
        try{
            this.tipoDiscurso = discurso.getString("tipoDiscurso");
        }catch(JSONException e){
            this.tipoDiscurso = "";
        }
         try{
           this.dataHoraInicio = discurso.getString("dataHoraInicio");
        }catch(JSONException e){
            this.dataHoraInicio = "";
        }
         try{
             this.dataHoraFim = discurso.getString("dataHoraFim");
        }catch(JSONException e){
            this.dataHoraFim = "";
        }
         try{
            this.sumario = discurso.getString("sumario");
        }catch(JSONException e){
            this.sumario = "";
        }
         try{
              this.transcricao = discurso.getString("transcricao");
        }catch(JSONException e){
            this.transcricao = "";
        }
   
    }
    
    Discurso(){
        this.titulo = "";
        this.tipoDiscurso = "";
        this.dataHoraInicio = "";
        this.dataHoraFim = "";
        this.sumario = "";
        this.transcricao = "";
    }
    
    public String getTitulo(){
        return this.titulo;
    }
     public void setTitulo(String titulo){
        this.titulo = titulo;
    }
      public String getTipoDiscurso(){
        return this.tipoDiscurso;
    }
     public void setTipoDiscurso(String tipoDiscurso){
        this.tipoDiscurso = tipoDiscurso;
    }
      public String getDataHoraInicio(){
        return this.dataHoraInicio;
    }
     public void setDataHoraInicio(String dataHoraInicio){
        this.dataHoraInicio = dataHoraInicio;
    }
      public String getDataHoraFim(){
        return this.dataHoraFim;
    }
     public void setDataHoraFim(String dataHoraFim){
        this.dataHoraFim = dataHoraFim;
    }
      public String getSumario(){
        return this.sumario;
    }
     public void setSumario(String sumario){
        this.sumario = sumario;
    }
      public String getTranscricao(){
        return this.transcricao;
    }
     public void setTranscricao(String transcricao){
        this.transcricao = transcricao;
    }
}
