import java.sql.*;
import javax.swing.*;
import java.util.*; //arraylist
  
public class BancoUsuarios {
  private int bdid;
    private String bdtipo;
    private String fsql;
    private String url, usuario, senha, drive;
    private Connection con;
    private ResultSet rs;
    private PreparedStatement pstmt;
    private Statement stmt;
    
    public BancoUsuarios()
    { bdid=0; bdtipo="politicos";
      fsql="";
      con=null;
      usuario="postgres";
      senha="sqladmin";
      drive="org.postgresql.Driver";
      url="jdbc:postgresql://localhost:5432/politicos";
      //url="jdbc:postgresql://200.145.153.163:5432/banco73b2017";  
    }
  
   public void setId(String c)
    {  bdid=Integer.parseInt(c); }	
    	
    public void setTipo(String n)	
    { bdtipo=n; }	
    	
    public int getId()
    { return bdid; }
    		
    public String getTipo()
    { return bdtipo;  }		  
}
