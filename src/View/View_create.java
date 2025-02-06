package View;

import Model.Card_Info;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class View_create {
    ArrayList<Card_Info> info;
    View_Main mai;
    public JFrame frame;
    JLabel h_label;

    JPanel panel;

    JLabel[] label;
    public JTextField[] text;
    public JButton[] buttons;

    public View_create(ArrayList<Card_Info> info) {
        this.info =info;
        frame = new JFrame("Create");
        h_label = new JLabel("Create Card");
        label = new JLabel[] {new JLabel("아이디:"), new JLabel("비밀번호")};
        text = new JTextField[] {new JTextField() , new JTextField()};
        buttons = new JButton[] {new JButton("생성"), new JButton("취소")};
        mai = new View_Main();
        panel =new JPanel();

        panel =  new JPanel(new FlowLayout(FlowLayout.CENTER, 20 ,10));
        h_label.setBounds(125,25,300,30);
        for(int i =0 ; i< label.length;i++){
            label[i].setBounds(50, (100* (i+1)),80,30);
        }
        for(int i =0 ; i< text.length;i++){
            text[i].setBounds(200, (100* (i+1)),200,30);
        }
        buttons[0].setBounds(150,300,80,30);
        buttons[1].setBounds(250,300,80,30);

    }
    public void show() {
        for(int i =0 ; i<label.length;i++){
            frame.add(label[i]);
        }
        for(int i =0 ; i<text.length; i++){
            frame.add(text[i]);
        }
        frame.add(h_label);
        h_label.setFont(new Font(Font.MONOSPACED,Font.BOLD,25));
        frame.add(buttons[0]);
        frame.add(buttons[1]);
        frame.setLocation(250,200);
        frame.add(panel,BorderLayout.SOUTH);
        frame.setSize(500,400);
        frame.setLayout(null);

        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
