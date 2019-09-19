/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco;

/**
 *
 * @author pedro
 */
public class Favorito {
    // ENCAPSULAMENTO

    private String id_favorito;
    private String nome;
    private String usuario_id;
    private String deputado_id;
    private String partido;
    private int status;
    private String estado; // TESTAR PRIMEIRO SEM ELA

    public Favorito() {
        this.id_favorito = "";
        this.deputado_id = "";
        this.nome = "";
        this.usuario_id = "";
        this.partido = "";
        this.estado = "";
        this.status = 0;
    }

    public Favorito(String id_deputado, String nome, String usuario_id, String partido, String estado, int status) {
        this.id_favorito = "";
        this.deputado_id = id_deputado;
        this.nome = nome;
        this.usuario_id = usuario_id;
        this.partido = partido;
        this.estado = estado;
        this.status = 0;

    }
  

      
    public String getIdFavorito() {
        return id_favorito;
    }

    public void setIdFavorito(String id_favorito) {
        this.id_favorito = id_favorito;
    }


    public String getDeputadoId() {
        return deputado_id;
    }

    public void setDeputadoId(String deputado_id) {
        this.deputado_id = deputado_id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUsuarioId() {
        return usuario_id;
    }

    public void setUsuarioId(String usuario_id) {
        this.usuario_id = usuario_id;
    }

    public String getPartido() {
        return partido;
    }

    public void setPartido(String partido) {
        this.partido = partido;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
