package banco;


import java.sql.*;
import javax.swing.*;
import java.util.*; //arraylist
import java.util.Random;

public class BancoUsuarios {

    private int bdid;
    private String bdtipo;
    private String fsql;
    private String url, usuario, senha_banco, drive;
    private Connection con;
    private ResultSet rs;
    private PreparedStatement pstmt;
    private Statement stmt;
    // CAMPOS DA TABELA
    private Usuario user;

    public BancoUsuarios(Usuario user) {
        bdid = 0;
        bdtipo = "";
        fsql = "";
        con = null;
        usuario = "postgres";
        senha_banco = "postgres";
        drive = "org.postgresql.Driver";
        url = "jdbc:postgresql://localhost:5432/PoliticosJava";
        this.user = user;
       
        //url="jdbc:postgresql://200.145.153.163:5432/banco73b2017";  
    }

    public BancoUsuarios() {
        bdid = 0;
        bdtipo = "";
        fsql = "";
        con = null;
        usuario = "postgres";
        senha_banco = "postgres";
        drive = "org.postgresql.Driver";
        url = "jdbc:postgresql://localhost:5432/PoliticosJava";
        Usuario u = new Usuario();
        this.user = u;
    }

    // METODOS BANCO - USuario
    public void incluir()//pkchave (chamada,turma)
    {
        
        fsql = "INSERT INTO usuarios ("
                + "id_usuario,"
                + "nome,"
                + "cpf,"
                //+ "dt_nasc,"
                + "email,"
                + "senha,"
                + "ideologia,"
                + "status) "
                + "VALUES (?,?,?,?,?,?,?)";
        try {
            pstmt = con.prepareStatement(fsql);
            
            
            pstmt.setString(1, this.user.getIdUsuario());
            pstmt.setString(2, this.user.getNome());
            pstmt.setString(3, this.user.getCpf());
            pstmt.setString(4, this.user.getEmail());
            pstmt.setString(5, this.user.getSenha());
            pstmt.setString(6, this.user.getIdeologia());
            pstmt.setInt(7,this.user.getStatus());

            //pstmt.setString(1, this.dt_nasc);
            pstmt.execute();
            pstmt.close();
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null,
                    "Erro na inclusao tabela Usuarios:" + erro);
        }
    }

    public void excluir() {
        fsql = "DELETE FROM usuarios where id_usuario=?;";
        try {
            pstmt = con.prepareStatement(fsql);
            pstmt.setString(1, this.user.getIdUsuario());
            pstmt.execute();
            pstmt.close();
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null,
                    "Erro na exclusao:" + erro);
        }
    }

    // enviar id_usuario via parametro das funcoes?
    public void alterar() {
      
        fsql = "UPDATE usuarios SET"
                + " nome=?"
                + ", cpf=?"
                //+ ", dt_nasc=" + this.dt_nasc
                + ", email=?"
                + ", ideologia=?"
                + "where id_usuario=?;";
        try {
            pstmt = con.prepareStatement(fsql);

            //pstmt.setString(1,bdnome);
           
            pstmt.setString(1, this.user.getNome());
            pstmt.setString(2, this.user.getCpf());
            pstmt.setString(3, this.user.getEmail());
            pstmt.setString(4, this.user.getIdeologia());
            pstmt.setString(5, this.user.getIdUsuario());

            pstmt.execute();
            pstmt.close();
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null,
                    "Erro na alteracao tabela Usuarios:" + erro);
        }
    }

    public void connect() {
        try {
            Class.forName(drive);
            con = DriverManager.getConnection(url, usuario, senha_banco);
            //JOptionPane.showMessageDialog(null,"ok");
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null,
                    "Erro na conexao:" + erro);
        }
    }//conectyyyyyy

    public void disconnect() {
        try {
            con.close();
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null,
                    "Erro na desconexao:" + erro);
        }
    } ///////////desconecta

    public List<Usuario> pegaDados() {
        
     List<Usuario> dados = new ArrayList<>();
     System.out.println(dados);
        fsql = "SELECT * FROM usuarios WHERE status=1;";
        try {
           this.stmt = con.createStatement();
            this.rs = stmt.executeQuery(fsql);
            while (rs.next()) {
                /*
                 bdid = rs.getInt("id_usuario");
                 bdtipo = rs.getString("tipo"); // ??
                 dados.add(bdid);
                 dados.add(bdtipo);
                 */

                this.user.setIdUsuario(rs.getString("id_usuario"));
                this.user.setNome( rs.getString("nome"));
                this.user.setCpf(rs.getString("cpf"));
                this.user.setEmail(rs.getString("email"));
                //this.dt_nasc = rs.getString("dt_nasc");
                this.user.setSenha(rs.getString("senha"));
                this.user.setIdeologia(rs.getString("ideologia"));
                this.user.setStatus(rs.getInt("status"));
                dados.add(this.user);
                
                this.user = null;
                this.user = new Usuario();
            }///while
            stmt.close();
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null,
                    "Erro na leitura:" + erro);
        }
       
     
       return dados;
    }//pegadados

    public Usuario procura(String id) {
        
        fsql = "SELECT * FROM usuarios WHERE id_usuario=? AND status=1;";
        try {
            pstmt = con.prepareStatement(fsql);
            pstmt.setString(1, id);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                this.user = null;
                this.user = new Usuario();
                
                 this.user.setIdUsuario(rs.getString("id_usuario"));
                this.user.setNome( rs.getString("nome"));
                this.user.setCpf(rs.getString("cpf"));
                this.user.setEmail(rs.getString("email"));
                this.user.setSenha(rs.getString("senha"));
                this.user.setIdeologia(rs.getString("ideologia"));
                this.user.setStatus(rs.getInt("status"));
                
                return this.user;
            }
            pstmt.close();
        } catch (Exception erroi) {
            JOptionPane.showMessageDialog(null,
                    " Erro procura do id_usuario (" + id + ")-->" + erroi);
        }
        return null;
    }//procura 

    /*
     // CONSULTAR FOTO DO SITE (tipo seria um campo especifico de la, se refere a tipo de aluno no caso)
    
     public String pegatipo(String id)
     {
     fsql="Select * from tabela2 where id=?";
     try{pstmt = con.prepareStatement(fsql);
     int idd=Integer.parseInt(id);
     pstmt.setInt(1, idd);
     rs=pstmt.executeQuery();
     if(rs.next())
     { return rs.getString("tipo");
     }    
     pstmt.close();    
     }    catch(Exception erroi)
     {
     JOptionPane.showMessageDialog(null,
     " Erro procura:"+erroi);
     }
     return "vazio";
     }//procura 
     */
    public String retorna() {
        String volta = "";
        fsql = "SELECT * FROM usuarios WHERE status=1;";
        try {
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            // executa
            rs = stmt.executeQuery(fsql);
            if (rs.last()) {
                volta = rs.getString("id_usuario");
                //JOptionPane.showMessageDialog(null,"ultimo"+volta);

                return volta;
            }
        } catch (Exception erroi) {
            JOptionPane.showMessageDialog(null,
                    " Erro leitura :" + erroi);
        }
        return volta;
    }

    /*
    
     // TAVA LA NO CODIGO DELE
    
     public static void main(String oi[]) {
     bancotipo b2 = new bancotipo();
     b2.connect();
     b2.setNome("tipocti bauru");
     b2.incluir();
     b2.disconnect();
     }*/
    // ENCAPSULAMENTO
    public void setId(String c) {
        bdid = Integer.parseInt(c);
    }

    public void setTipo(String n) {
        bdtipo = n;
    }

    public int getId() {
        return bdid;
    }

    public String getTipo() {
        return bdtipo;
    }
    
     public Usuario login(String email, String senha) {

        fsql = "SELECT * FROM usuarios WHERE email=? AND senha=? AND status=1;";
        try {
            pstmt = con.prepareStatement(fsql);
            pstmt.setString(1, email);
            pstmt.setString(2, senha);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                this.user = null;
                this.user = new Usuario();

                this.user.setIdUsuario(rs.getString("id_usuario"));
                this.user.setNome(rs.getString("nome"));
                this.user.setCpf(rs.getString("cpf"));
                this.user.setEmail(rs.getString("email"));
                this.user.setSenha(rs.getString("senha"));
                this.user.setIdeologia(rs.getString("ideologia"));
                this.user.setStatus(rs.getInt("status"));
                
                pstmt.close();
                return this.user;
            } else {
                pstmt.close();
                return null;
            }
        } catch (Exception erroi) {
            JOptionPane.showMessageDialog(null,
                    " Erro procura do email (" + email + ")-->" + erroi);
        }
        return null;
    }//login 
     
      public void alterarSenha() {
      
        fsql = "UPDATE usuarios SET"
                + " senha=?"
                + "where id_usuario=?;";
        try {
            pstmt = con.prepareStatement(fsql);           
            pstmt.setString(1, this.user.getSenha());
            pstmt.setString(2, this.user.getIdUsuario());

            pstmt.execute();
            pstmt.close();
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null,
                    "Erro na alteracao de senha do Usuario:" + erro);
        }
    }
}// CLASS
