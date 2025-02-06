package View;

import Model.Card_Info;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class View_search {
    ArrayList<Card_Info> info;
    public JFrame frame;
    JLabel label;
    JLabel[] labels;
    public JTextField[] texts;
    public JButton[] buttons;
    JLabel result;

    public View_search(ArrayList<Card_Info> info) {
        this.info = info;

        frame = new JFrame("카드 조회");
        label = new JLabel("Search Card");
        labels = new JLabel[]{new JLabel("아이디"), new JLabel("비밀번호")};
        texts = new JTextField[]{new JTextField(), new JTextField()};
        buttons = new JButton[]{new JButton("조회"), new JButton("취소")};
        result = new JLabel(""); // 결과 조회

        label.setBounds(125, 25, 300, 30);

        for (int i = 0; i < labels.length; i++) {
            labels[i].setBounds(50, (100 * (i + 1)), 80, 30);
        }

        for (int i = 0; i < texts.length; i++) {
            texts[i].setBounds(150, (100 * (i + 1)), 200, 30);
        }

        buttons[0].setBounds(150, 250, 80, 30);
        buttons[1].setBounds(250, 250, 80, 30);

        result.setBounds(50, 300, 400, 30);

    }
    
    public void show() {
        frame.setLayout(new BorderLayout());

        frame.add(label);
        for (JLabel lbl : labels) frame.add(lbl);
        for (JTextField txt : texts) frame.add(txt);
        for (JButton btn : buttons) frame.add(btn);
        frame.add(result);

        frame.setSize(500, 400);
        frame.setLocation(250,200);
        frame.setVisible(true);
        frame.setResizable(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void updateText() {
        String inputId = texts[0].getText();
        String inputPw = texts[1].getText();

        for (Card_Info card : info) {
            if (card.getId().equals(inputId) && card.getPassword().equals(inputPw)) {
                JOptionPane.showMessageDialog(null,"로그인성공 \n" + "카드번호:" +card.getCart_number());

                View_intro intro = new View_intro(card,info);

                frame.dispose();
                intro.show();
                return;
            }
        }
        JOptionPane.showMessageDialog(null,"아이디나 비밀번호 오류");
    }

}
