package View;

import Model.Card_Info;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;

public class View_Delete {
    ArrayList<Card_Info> info;

    public JFrame frame;
    JLabel label;

    JLabel[] labels;

    public JButton[] buttons;

    public JTextField[] textFields;

    JLabel result;

    public View_Delete(ArrayList<Card_Info> info){
        this.info = info;

        frame = new JFrame("삭제");
        label = new JLabel("삭제 화면");
        labels = new JLabel[] {new JLabel("아이디:"),new JLabel("비밀번호")};
        textFields= new JTextField[] {new JTextField(),new JTextField()};
        buttons = new JButton[] {new JButton("삭제"),new JButton("돌아가기")};
        result = new JLabel("");

        label.setBounds(125,25,300,30);

        for (int i = 0; i < labels.length; i++) {
            labels[i].setBounds(50, (100 * (i + 1)), 80, 30);
        }

        for (int i = 0; i < textFields.length; i++) {
            textFields[i].setBounds(150, (100 * (i + 1)), 200, 30);
        }

        buttons[0].setBounds(150, 250, 80, 30);
        buttons[1].setBounds(250, 250, 80, 30);
        result.setBounds(50,300,400,30);
    }
    public void show(){
        frame.setLayout(null);
        label.setFont(new Font(Font.SERIF,Font.BOLD,15));
        frame.add(label);
        for(JLabel lnl : labels) frame.add(lnl);
        for(JTextField txt: textFields) frame.add(txt);
        for(JButton btn : buttons) frame.add(btn);
        frame.add(result);

    frame.setSize(500,400);
    frame.setVisible(true);
    frame.setLocation(250,200);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void DeleteText() {
        String inputId = textFields[0].getText();
        String inputPw = textFields[1].getText();

        Iterator<Card_Info> iterator = info.iterator();
        while(iterator.hasNext()){
            Card_Info card = iterator.next();
            if(card.getId().equals(inputId) && card.getPassword().equals(inputPw)){
                iterator.remove();
                JOptionPane.showMessageDialog(null,"삭제완료");
                return;
            }
        }
        JOptionPane.showMessageDialog(null,"아이디나 비번이 맞지않습니다");
    }
}
