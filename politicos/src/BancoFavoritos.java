
import java.sql.*;
import javax.swing.*;
import java.util.*; //arraylist

public class BancoFavoritos {

    private int bdid;
    private String bdtipo;
    private String bdNome;
    private String fsql;
    private String url, usuario, senha_banco, drive;
    private Connection con;
    private ResultSet rs;
    private PreparedStatement pstmt;
    private Statement stmt;

    // CAMPOS DA TABELA
    private int id_favoritos;
    private String nome;
    private int usuario_id;
    private int deputado_id;
    private String partido;
    private String foto; // TESTAR PRIMEIRO SEM ELA

    public BancoFavoritos() {
        bdid = 0;
        bdtipo = "";
        fsql = "";
        con = null;
        usuario = "postgres";
        senha_banco = "sqladmin";
        drive = "org.postgresql.Driver";
        url = "jdbc:postgresql://localhost:5432/politicos";
        //url="jdbc:postgresql://200.145.153.163:5432/banco73b2017";  
    }

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

    // METODOS BANCO - USuario
    public void incluir()//pkchave (chamada,turma)
    {
        fsql = "INSERT INTO favoritos ("
                + "id_favoritos,"
                + "nome,"
                + "usuario_id,"
                + "deputado_id,"
                + "partido,"
                + "foto"
                + ")"
                + "VALUES ("
                + this.id_favoritos
                + "," + this.nome
                + "," + this.usuario_id
                + "," + this.deputado_id
                + "," + this.partido
                + "," + this.foto
                + ")";
        try {
            pstmt = con.prepareStatement(fsql);
            pstmt.setString(1, bdtipo);

            pstmt.execute();
            pstmt.close();
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null,
                    "Erro na inclusao tabela Favoritos:" + erro);
        }
    }

    public void excluir() {
        fsql = "DELETE FROM favoritos where id_favoritos=" + this.id_favoritos + ";";
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
        fsql = "UPDATE favoritos SET"
                + " nome=" + this.nome
                + ", partido=" + this.partido
                + ", foto=" + this.foto
                + "where id=" + this.id_favoritos + ";";
        try {
            pstmt = con.prepareStatement(fsql);

            //pstmt.setString(1,bdnome);
            pstmt.setString(1, this.bdtipo);
            pstmt.setInt(2, bdid);
            pstmt.execute();
            pstmt.close();
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null,
                    "Erro na alteracao tabela Favoritos:" + erro);
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
        fsql = "SELECT * FROM favoritos";
        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery(fsql);
            while (rs.next()) {
                /*
                 bdid = rs.getInt("id_favoritos");
                 bdtipo = rs.getString("tipo"); // ?? --> campo da tabela
                 dados.add(bdid);
                 dados.add(bdtipo);*/

                this.id_favoritos = rs.getInt("id_favoritos");
                this.nome = rs.getString("nome");
                this.deputado_id = rs.getInt("deputado_id");
                this.partido = rs.getString("partido");
                this.foto = rs.getString("foto");
                
                dados.add(id_favoritos);
                dados.add(nome);
                dados.add(deputado_id);
                dados.add(partido);
                dados.add(foto);

                /*
                 private String nome;
                 private int usuario_id;
                 private int deputado_id;
                 private String partido;
                 private String foto; // 
                 */
            }///while	
            stmt.close();
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null,
                    "Erro na leitura:" + erro);
        }
        return dados;
    }//pegadados

    public boolean procura(String id) {
        fsql = "SELECT * FROM usuarios WHERE id_favoritos=" + id + ";";
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
                    " Erro procura do id_favoritos (" + id + ")-->" + erroi);
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
        fsql = "SELECT * FROM favoritos";
        try {
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            // executa
            rs = stmt.executeQuery(fsql);
            if (rs.last()) {
                volta = rs.getString("id_favoritos");
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
}// CLASS