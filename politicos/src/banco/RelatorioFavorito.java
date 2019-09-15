/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author ra1757036
 */
public class RelatorioFavorito {

    private static Connection con;
    private static Statement stmt;
    private static ResultSet rs;

    public void relatorioFavorito(String id) {

        System.out.println("ID: " + id);

        JasperReport jasperR;
        JasperPrint jasperP;
        JRResultSetDataSource jrRS;
        Map parametros;

        try {

            String usuario = "postgres";
            String senha_banco = "postgres";
            String drive = "org.postgresql.Driver";
            String url = "jdbc:postgresql://localhost:5432/PoliticosJava";

            Class.forName(
                    "org.postgresql.Driver");
            con = DriverManager.getConnection(url, usuario, senha_banco);
            stmt = con.createStatement();

            String sql = "Select * from favoritos WHERE usuario_id ='" + id + "';";

// TUDO AQUI  GERAR UM ARQUIVO TIPO PDF    		
            rs = stmt.executeQuery(sql);

            // implementação da interface JRDataSource para DataSource ResultSet 
            jrRS = new JRResultSetDataSource(rs);
            parametros = new HashMap();
            //         parametros.put("usuario_id", id);

            jasperR = JasperCompileManager.compileReport("C:\\politicosJava\\reportFavoritos.jrxml");

            jasperP = JasperFillManager.fillReport(jasperR, parametros, jrRS);

            JasperExportManager.exportReportToPdfFile(jasperP, "reportUsuarios.pdf");

            //Executa o relatório
            try {
                Process process = Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + "reportUsuarios.pdf");
            } catch (IOException ex) {
                ex.printStackTrace();
            }

//TUDO AQUI E PARA GERAR UM ARQUIVO JASPERVIEW
            rs = stmt.executeQuery(sql);
            System.out.println("sql: " + sql);
            jrRS = new JRResultSetDataSource(rs);
            parametros = new HashMap();
            //  parametros.put("usuario_id", id);

            JasperPrint impressao = JasperFillManager.fillReport("C:\\politicosJava\\reportFavoritos.jasper", parametros, jrRS);
            //exibe o resultado
            JasperViewer viewer = new JasperViewer(impressao, true);

            viewer.show();

            //fechando o banco
            con.close();

            stmt.close();

        }//try
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERRO relatorio=" + e.getMessage());

        }//catch

    }	//main
}
