package View;

import javax.swing.*;
import java.awt.*;

public class View_Main {
    public JFrame frame;
    public JButton[] button;
    JLabel label;
    JPanel panel;

    ImageIcon icon;

    public View_Main() {
        frame = new JFrame("first");
        label = new JLabel("Card_Gift",JLabel.CENTER);
        button = new JButton[] {new JButton("계정 생성"),new JButton("로그인"),new JButton("계정 삭제")};
        panel = new JPanel();

        panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));


        for(int i =0 ; i< button.length; i++){  //length => size = 2
            button[i].setBackground(Color.PINK);
            button[i].setForeground(Color.gray);
            button[i].setFont(new Font(Font.SERIF, Font.BOLD,15));
            button[i].setPreferredSize(new Dimension(100,60));

            button[i].setOpaque(true);
            button[i].setContentAreaFilled(true);
            panel.add(button[i]);
        }

    }

    public void show() {
        frame.setLayout(new BorderLayout());
        frame.setBackground(Color.lightGray);
        frame.add(panel, BorderLayout.SOUTH);
        frame.add(label, BorderLayout.CENTER);
        frame.setLocation(250,200);
        icon = new ImageIcon("imgs/img1.png");
        Image img = icon.getImage().getScaledInstance(200,200,Image.SCALE_SMOOTH);

        JLabel imageLabel = new JLabel(new ImageIcon(img));
        frame.add(imageLabel, BorderLayout.NORTH);

        label.setFont(new Font(Font.SERIF , Font.BOLD, 50));
        frame.setSize(600,500);
        frame.setVisible(true);
        frame.setResizable(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
