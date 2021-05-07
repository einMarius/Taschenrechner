package me.marius.main;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame {

    private JPanel contentPane;

    private JPanel Rechner;
    private JTextField TextFieldZahl1;
    private JTextField TextFieldZahl2;
    private JButton GeteiltButton;
    private JButton PlusButton;
    private JButton MinusButton;
    private JButton MalButton;
    private JTextField TextFieldErgebnis;
    private JLabel Zahl1;
    private JLabel Zahl2;
    private JLabel Ergebnis;
    private JButton exitButton;

    public static void main(String[] args){
        JFrame frame = new JFrame("Taschenrechner");
        frame.setContentPane(new Main().Rechner);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public Main(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(300, 200, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder( 5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        try{
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }catch (Exception e){
        }

        PlusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculate("+");
            }
        });
        MinusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculate("-");
            }
        });
        MalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculate("*");
            }
        });
        GeteiltButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculate("/");
            }
        });
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    public void calculate(String o){

        int z1 = 0;
        int z2 = 0;
        int erg = 0;

        try {
            z1 = Integer.parseInt(TextFieldZahl1.getText());
            z2 = Integer.parseInt(TextFieldZahl2.getText());
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Bitte nur ganzzahlige Werte!", "Fehler", JOptionPane.ERROR_MESSAGE);
        }

        if (o.equals("+")) {
            erg = z1 + z2;
        } else if (o.equals("-")) {
            erg = z1 - z2;
        } else if (o.equals("*")) {
            erg = z1 * z2;
        } else if (o.equals("/")) {
            if(!(z2 == 0))
                erg = z1 / z2;
            else
                JOptionPane.showMessageDialog(null, "DU WIRST JETZT STERBEN", "Fehler", JOptionPane.ERROR_MESSAGE);
        }

        String ergebnis = String.valueOf(erg);

        TextFieldErgebnis.setText(ergebnis);
    }
}
