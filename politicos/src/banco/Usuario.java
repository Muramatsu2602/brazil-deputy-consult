/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco;

// CAMPOS DA TAB




public class Usuario {

    private String id_usuario;
    private String nome;
    private String cpf;
    private String email;
    private String senha;
    private String ideologia;
    private int status;

    Usuario() {
        this.id_usuario = "";
        this.nome = "";
        this.cpf = "";
        this.email = "";
        this.senha = "";
        this.ideologia = "";
        this.status = 0;
    }

    Usuario(String id_usuario, String nome, String cpf, String email, String senha, String ideologia, boolean status) {

        this.id_usuario = id_usuario;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.senha = senha;
        this.ideologia = ideologia;
        this.status = 1;

    }

    public String getIdUsuario() {
        return this.id_usuario;
    }

    public void setIdUsuario(String id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return this.senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getIdeologia() {
        return this.ideologia;
    }

    public void setIdeologia(String ideologia) {
        this.ideologia = ideologia;
    }

    public int getStatus() {
        return this.status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

}
