package forms;

import camaraApi.Capi;
import camaraApi.Deputado;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.json.JSONException;


public class Menu extends javax.swing.JFrame {

    public Menu() {
      
       jTable1 = new JTable();
     
        initComponents();
    }

  private void imprimirDeputados() throws JSONException{
       
            String pesquisa = "kim";
        
       DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        
        List<Deputado> y = Capi.pesquisaDeputados("nome",pesquisa,Capi.mostraDeputados());
        String rowData[] = new String[4];
        for(int x = 0; x<y.size();x++){
             rowData[0] = y.get(x).getId();
            rowData[1] = y.get(x).getNome();
            rowData[2] = y.get(x).getSiglaPartido();
            rowData[3] = y.get(x).getSiglaPartido();
            model.addRow(rowData);
        }
  }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu4 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        button1 = new java.awt.Button();
        barra = new javax.swing.JMenuBar();
        mCadastro = new javax.swing.JMenu();
        miUsuarios = new javax.swing.JMenuItem();
        miPartidos = new javax.swing.JMenuItem();
        mFavoritos = new javax.swing.JMenu();
        miPoliticos = new javax.swing.JMenuItem();
        miIdeologia = new javax.swing.JMenuItem();
        mSobre = new javax.swing.JMenu();
        mSair = new javax.swing.JMenu();

        jMenu4.setText("jMenu4");

        jMenu3.setText("jMenu3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(800, 600));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nome", "Partido"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        button1.setLabel("button1");
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });

        barra.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        mCadastro.setText("Cadastro");

        miUsuarios.setText("Usuarios");
        miUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miUsuariosActionPerformed(evt);
            }
        });
        mCadastro.add(miUsuarios);

        miPartidos.setText("Partidos");
        mCadastro.add(miPartidos);

        barra.add(mCadastro);

        mFavoritos.setText("Favoritos");

        miPoliticos.setText("Políticos");
        mFavoritos.add(miPoliticos);

        miIdeologia.setText("Ideologia");
        mFavoritos.add(miIdeologia);

        barra.add(mFavoritos);

        mSobre.setText("Sobre");
        barra.add(mSobre);

        mSair.setText("Sair");
        barra.add(mSair);

        setJMenuBar(barra);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 649, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        button1.getAccessibleContext().setAccessibleName("Atualizar");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void miUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miUsuariosActionPerformed
        ListarUsuarios form = new ListarUsuarios();
        form.show();
    }//GEN-LAST:event_miUsuariosActionPerformed

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
        try {
            imprimirDeputados();
                  } catch (JSONException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_button1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

     
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar barra;
    private java.awt.Button button1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JMenu mCadastro;
    private javax.swing.JMenu mFavoritos;
    private javax.swing.JMenu mSair;
    private javax.swing.JMenu mSobre;
    private javax.swing.JMenuItem miIdeologia;
    private javax.swing.JMenuItem miPartidos;
    private javax.swing.JMenuItem miPoliticos;
    private javax.swing.JMenuItem miUsuarios;
    // End of variables declaration//GEN-END:variables
}
