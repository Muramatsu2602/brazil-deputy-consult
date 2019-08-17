
import java.sql.*;
import javax.swing.*;
import java.util.*; //arraylist

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
    private int id_usuario;
    private String nome;
    private int cpf;
    //private String dt_nasc;
    private String email;
    private String senha;
    private String ideologia;
    private int status;

    public BancoUsuarios() {
        bdid = 0;
        bdtipo = "";
        fsql = "";
        con = null;
        usuario = "postgres";
        senha_banco = "a";
        drive = "org.postgresql.Driver";
        url = "jdbc:postgresql://localhost:5432/politicos";
        //url="jdbc:postgresql://200.145.153.163:5432/banco73b2017";  
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

            pstmt.setInt(1, this.id_usuario);
            pstmt.setString(2, this.nome);
            pstmt.setInt(3, this.cpf);
            pstmt.setString(4, this.email);
            pstmt.setString(5, this.senha);
            pstmt.setString(6, this.ideologia);
            pstmt.setInt(7, this.status);

            //pstmt.setString(1, this.dt_nasc);
            pstmt.execute();
            pstmt.close();
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null,
                    "Erro na inclusao tabela Usuarios:" + erro);
        }
    }

    public void excluir() {
        fsql = "DELETE FROM usuarios where id_usuario=" + this.id_usuario + ";";
        try {
            pstmt = con.prepareStatement(fsql);
            pstmt.setInt(1, bdid);
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
                + ", senha=?"
                + ", ideologia=?"
                + "where id=?;";
        try {
            pstmt = con.prepareStatement(fsql);

            //pstmt.setString(1,bdnome);
            pstmt.setString(1, this.nome);
            pstmt.setInt(2, this.cpf);
            pstmt.setString(3, this.email);
            pstmt.setString(4, this.senha);
            pstmt.setString(5, this.ideologia);
            pstmt.setInt(6, this.id_usuario);

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

    public ArrayList pegadados() {
        ArrayList dados;
        dados = new ArrayList();
        fsql = "SELECT * FROM usuarios AND status=1;";
        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery(fsql);
            while (rs.next()) {
                /*
                 bdid = rs.getInt("id_usuario");
                 bdtipo = rs.getString("tipo"); // ??
                 dados.add(bdid);
                 dados.add(bdtipo);
                 */

                this.id_usuario = rs.getInt("id_usuario");
                this.nome = rs.getString("nome");
                this.cpf = rs.getInt("cpf");
                this.email = rs.getString("email");
                //this.dt_nasc = rs.getString("dt_nasc");
                this.senha = rs.getString("senha");
                this.ideologia = rs.getString("ideologia");
                this.status = rs.getInt("status");
                dados.add(this.id_usuario);
                dados.add(this.nome);
                dados.add(this.cpf);
                dados.add(this.email);
                //dados.add(this.dt_nasc);
                dados.add(this.senha);
                dados.add(this.ideologia);
                dados.add(this.status);

            }///while	
            stmt.close();
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null,
                    "Erro na leitura:" + erro);
        }
        return dados;
    }//pegadados

    public boolean procura(String id) {
        fsql = "SELECT * FROM usuarios WHERE id_usuario=? AND status=1;";
        try {
            pstmt = con.prepareStatement(fsql);
            int idd = Integer.parseInt(id);
            pstmt.setInt(1, idd);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                return true;//achou
            }
            pstmt.close();
        } catch (Exception erroi) {
            JOptionPane.showMessageDialog(null,
                    " Erro procura do id_usuario (" + id + ")-->" + erroi);
        }
        return false;
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
}// CLASS
