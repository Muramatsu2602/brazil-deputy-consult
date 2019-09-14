/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.extensions.*;
import net.sf.jasperreports.view.JasperViewer;

import java.sql.*;
import java.util.*;
import java.awt.*;
import javax.swing.*;

import java.lang.*;
import java.io.*;

/**
 *
 * @author ra1757036
 */
public class RelatorioUsuario {

    private static Connection con;
    private static Statement stmt;
    private static ResultSet rs;

    public static void main(String ararar[]) {

        JasperReport jasperR;
        JasperPrint jasperP;
        JRResultSetDataSource jrRS;
        Map parametros;

        try {
            Class.forName(DRIVERBANCO);
            con = DriverManager.getConnection(URL, USUARIO, SENHA);
            stmt = con.createStatement();

            // TUDO AQUI  GERAR UM ARQUIVO TIPO PDF    		
            rs = stmt.executeQuery("Select * from Alunos");

            /* implementação da interface JRDataSource para DataSource ResultSet */
            jrRS = new JRResultSetDataSource(rs);
            parametros = new HashMap();

            jasperR = JasperCompileManager.compileReport("report1.jrxml");

            jasperP = JasperFillManager.fillReport(jasperR, parametros, jrRS);

            JasperExportManager.exportReportToPdfFile(jasperP, "saida.pdf");

            //Executa o relatório
            try {
                Process process = Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + "saida.pdf");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
//TUDO AQUI E PARA GERAR UM ARQUIVO JASPERVIEW

            rs = stmt.executeQuery("Select * from Alunos");
            jrRS = new JRResultSetDataSource(rs);
            parametros = new HashMap();

            JasperPrint impressao = JasperFillManager.fillReport("report1.jasper", parametros, jrRS);
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
