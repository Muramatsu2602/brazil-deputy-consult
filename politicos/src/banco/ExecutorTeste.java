/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco;

import banco.Usuario;
import banco.BancoUsuarios;


/**
 *
 * @author ra1757036
 */
public class ExecutorTeste {
      public static void main(String[] args) {
    Usuario user = new Usuario("3","Lucas Rufino","123","joj@gmail.com","123","esquerda",1);
    BancoUsuarios usuario= new BancoUsuarios(user);
  
    usuario.connect();
    usuario.incluir();
    usuario.disconnect();
     }
}
