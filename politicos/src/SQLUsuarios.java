// Importa os pacotes necessários

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;//DefaulTableModel
//vetor
import java.util.*;

public class SQLUsuarios extends JFrame implements ActionListener, MouseListener, KeyListener {

    // Bloco 1 - Objetos da Janela
    private DefaultTableModel modelo;
    private JTable tabela;
    private JScrollPane grade;

    private JButton btnovo;
    private JButton btAlterar;

    private JButton btExcluir;
    private JButton btSalvar;
    private JButton btCancelar;
    private JButton btSair;

    //campos da tabela-tipo banco sql
    private JLabel lbpktipo;
    private JLabel lbtipo;

    private JTextField cxpktipo;
    private JTextField cxtipo;

    private String xpktipo, xtipo;

    //botao alterar dados
    private int linhaltera;

    private BancoUsuarios banUsu;

    public void leGradeSql() {
        ArrayList vetor;
        vetor = new ArrayList();
        try {
            banUsu.connect();///conecta
            vetor = banUsu.pegadados();//pega todos os campos
            if (vetor.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Tabela vazia tipo!!!");
                return;
            } else {
                for (int j = 0; j < vetor.size(); j++) {
                    xpktipo = "" + vetor.get(j);
                    j++;
                    xtipo = "" + vetor.get(j);
                    String linha[] = {xpktipo, xtipo};
                    modelo.addRow(linha);
                }//for
            }
            banUsu.disconnect();//desconecta		
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null,
                    "Erro na leitura tabela tipo:" + erro);
        }
    }/////legrade

    public void keyPressed(KeyEvent e) {
    }
//Invoked when a key has been pressed.

    public void keyReleased(KeyEvent e) {
        int line = tabela.getSelectedRow();
        cxpktipo.setText(tabela.getValueAt(line, 0) + "");
        cxtipo.setText(tabela.getValueAt(line, 1) + "");
    }
//Invoked when a key has been released.

    public void keyTyped(KeyEvent e) {
    }
//Invoked when a key has been typed.

    public void mouseClicked(MouseEvent e) {
    }
//Invoked when the mouse button has been clicked (pressed and released) on a component.

    public void mouseEntered(MouseEvent e) {
    }
//Invoked when the mouse enters a component.

    public void mouseExited(MouseEvent e) {
    }
//Invoked when the mouse exits a component.

    public void mousePressed(MouseEvent e) {
    }
//Invoked when a mouse button has been pressed on a component.

    public void mouseReleased(MouseEvent e) {
        int line = tabela.getSelectedRow();
        cxpktipo.setText(tabela.getValueAt(line, 0) + "");
        cxtipo.setText(tabela.getValueAt(line, 1) + "");
    }
//Invoked when a mouse button has been released on a component.

    public void habilitaTudo(boolean logico, int tlimpa) {
        if (tlimpa == 1) {
            limpaTudo();///ideia do Vitor
        }
        cxpktipo.setEnabled(logico);
        cxtipo.setEnabled(logico);

        btnovo.setEnabled(!logico);
        btAlterar.setEnabled(!logico);
        btExcluir.setEnabled(!logico);
        tabela.setEnabled(!logico);

        btSalvar.setEnabled(logico);
        btCancelar.setEnabled(logico);

    }

    public void limpaTudo() {
        cxpktipo.setText("");
        cxtipo.setText("");
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == btSair) {
            dispose();
        }

        if (ae.getSource() == btnovo) {
            habilitaTudo(true, 1);
            cxtipo.setEditable(true);
            cxtipo.grabFocus();
            linhaltera = -1;///novo cadastro
            return;
        }//bt novo

        if (ae.getSource() == btAlterar) {
            linhaltera = tabela.getSelectedRow();
            if (linhaltera == -1)//menus um
            {
                JOptionPane.showMessageDialog(null,
                        "Selecione uma linha, por favor...");
                return;
            }
            habilitaTudo(true, 2);
            cxpktipo.setEditable(false);
            cxpktipo.setText(tabela.getValueAt(linhaltera, 0) + "");
            cxtipo.setText(tabela.getValueAt(linhaltera, 1) + "");
            //tras tudo para caixas texto	
            cxtipo.grabFocus();
            return;
        }///bt alterar

        if (ae.getSource() == btExcluir) {///excluir
            int linex = tabela.getSelectedRow();
            if (linex == -1)///menos um
            {
                JOptionPane.showMessageDialog(null,
                        "Escolha uma linha....",
                        "Excluindo", -1);
                return;
            }
            if (JOptionPane.showConfirmDialog(null,
                    "Excluir linha:" + tabela.getValueAt(linex, 1),
                    "Excluindo", 0) == 0)//sim=0 nao=1
            {
                banUsu.connect();
                banUsu.setId("" + tabela.getValueAt(linex, 0));
                banUsu.excluir();
                banUsu.disconnect();
                modelo.removeRow(linex);
                limpaTudo();
            }
            return;
        }////bt excluir

        if (ae.getSource() == btSalvar)//////salvar
        {

            if (cxtipo.getText().length() == 0) {
                cxtipo.grabFocus();
                return;
            }///////////

            if (linhaltera == -1)///botao novo
            { //nova linha na grade
                banUsu.connect();
                banUsu.setTipo(cxtipo.getText());
                banUsu.incluir();
                //cxpktipo.setText(banUsu.retornaUltimo());
                banUsu.disconnect();
                String linha[] = {cxpktipo.getText(), cxtipo.getText()};
                modelo.addRow(linha);//coloca na grade
            } else///botao alterar
            {
                banUsu.connect();
                banUsu.setId(cxpktipo.getText());
                banUsu.setTipo(cxtipo.getText());
                banUsu.alterar();
                banUsu.disconnect();
                tabela.setValueAt(cxpktipo.getText(), linhaltera, 0);
                tabela.setValueAt(cxtipo.getText(), linhaltera, 1);
            }
            habilitaTudo(false, 1);
            return;
        }///////////salvar botao

        if (ae.getSource() == btCancelar) {
            habilitaTudo(false, 2);
            return;
        }//CANCELA
    }///actionperformed	
///////////////////construtor

    public SQLUsuarios() {
        super("Arquivo SQL- TABELA TIPO ALUNO");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        // Bloco 2 - Definição dos dados da Janela
        setLayout(null);

        getContentPane().setBackground(new Color(255, 102, 102));

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setSize(new java.awt.Dimension(866, 509));
        setLocation((screenSize.width - 866) / 2, (screenSize.height - 509) / 2);
        setResizable(false);

        // Bloco 3 - Criação dos Objetos na Janela
        modelo = new DefaultTableModel() {
            public boolean isCellEditable(int lin, int col) {
                return false;
            }
        };
        modelo.addColumn("PKTIPO");
        modelo.addColumn("TIPO Aluno(a)");

        tabela = new JTable(modelo);
        tabela.addMouseListener(this);//acao mouse
        tabela.addKeyListener(this);//acao teclado

        tabela.getTableHeader().setReorderingAllowed(false);
        tabela.getColumnModel().getColumn(0).setMaxWidth(80);
        tabela.getColumnModel().getColumn(0).setMinWidth(80);
        tabela.getColumnModel().getColumn(1).setMaxWidth(300);

        grade = new JScrollPane(tabela);
        grade.setToolTipText("Grade de dados");
        grade.setBounds(22, 18, 807, 206);//x,y,larg,alt
        add(grade);

        btnovo = new JButton("Novo");
        btnovo.setToolTipText("Incluir dados");
        btnovo.setBounds(686, 248, 100, 30);
        btnovo.addActionListener(this);
        add(btnovo);

        btAlterar = new JButton("Alterar");
        btAlterar.setToolTipText("Alterar dados");
        btAlterar.setBounds(689, 291, 100, 30);
        add(btAlterar);
        btAlterar.addActionListener(this);
        linhaltera = -1;

        btExcluir = new JButton("Excluir");
        btExcluir.setToolTipText("Excluir dados");
        btExcluir.setBounds(688, 335, 100, 30);
        add(btExcluir);
        btExcluir.addActionListener(this);

        btSalvar = new JButton("Salvar");
        btSalvar.setToolTipText("Salvar dados");
        btSalvar.setBounds(690, 380, 100, 30);
        btSalvar.setEnabled(false);
        add(btSalvar);
        btSalvar.addActionListener(this);

        btCancelar = new JButton("Cancelar");
        btCancelar.setToolTipText("Cancela operacao");
        btCancelar.setBounds(690, 427, 100, 30);
        btCancelar.setEnabled(false);
        add(btCancelar);
        btCancelar.addActionListener(this);

        btSair = new JButton("Sair");
        btSair.setToolTipText("Fechar");
        btSair.setBounds(36, 425, 100, 30);
        add(btSair);
        btSair.addActionListener(this);

        lbpktipo = new JLabel("PKTIPO:");
        lbpktipo.setBounds(44, 248, 57, 13);
        add(lbpktipo);

        lbtipo = new JLabel("TIPO:");
        lbtipo.setBounds(61, 275, 45, 15);
        add(lbtipo);

        cxpktipo = new JTextField();
        cxpktipo.setToolTipText("PK TIPO");
        cxpktipo.setBounds(102, 250, 80, 21);
        cxpktipo.setEnabled(false);
        add(cxpktipo);

        cxtipo = new JTextField();
        cxtipo.setToolTipText("Tipo Aluno(a)");
        cxtipo.setBounds(102, 275, 400, 20);
        cxtipo.setEnabled(false);
        add(cxtipo);

        habilitaTudo(false, 1);//1=limpa campos

        banUsu = new BancoUsuarios();
        leGradeSql();
        show();
    }
    
    
     public static void main(String args[]) {
        new SQLUsuarios();
    }
}
