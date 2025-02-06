package View;

import Model.Card_Info;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class View_intro {
    private Card_Info user;
    private ArrayList<Card_Info> list;
    JFrame frame;
    JLabel[] label;

    JPanel h_panel, b_panel;
    JButton[] buttons;
    String[] column;
    DefaultTableModel model;
    JScrollPane scroll;
    JTable table;

    View_Main main1;

    public View_intro(Card_Info user, ArrayList<Card_Info> list) {
        this.user = user;
        this.list = list;
        main1 = new View_Main();
        frame = new JFrame("info");
        label = new JLabel[]{
                new JLabel("아이디: " + user.getId()),
                new JLabel("카드번호: " + user.getCart_number())
        };
        h_panel = new JPanel();
        column = new String[]{"시간", "내역", "잔액"};
        model = new DefaultTableModel(new Object[][]{}, column);
        table = new JTable(model);
        scroll = new JScrollPane(table);
        b_panel = new JPanel();
        buttons = new JButton[]{new JButton("충전"), new JButton("출금"), new JButton("닫기"), new JButton("관리자 상담")};

        // 충전 버튼 이벤트 추가
        buttons[0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                chargeBalance();
            }
        });

        // 출금 버튼
        buttons[1].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                withdrawbalance();
            }
        });

        //닫기버튼
        buttons[2].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                View_Main main1= new View_Main();
                main1.show();
            }
        });
        buttons[3].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    public void show() {
        frame.setLayout(new BorderLayout());
        h_panel.setLayout(new GridLayout(3, 1));
        label[0].setFont(new Font(Font.SERIF, Font.BOLD, 20));

        for (JLabel jLabel : label) {
            h_panel.add(jLabel);
        }
        for (JButton button : buttons) {
            b_panel.add(button);
        }

        frame.add(h_panel, BorderLayout.NORTH);
        frame.add(scroll, BorderLayout.CENTER);
        frame.add(b_panel, BorderLayout.SOUTH);
        frame.setSize(600, 500);
        frame.setLocation(250,200);
        frame.setVisible(true);
        frame.setResizable(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void chargeBalance() {
        String input = JOptionPane.showInputDialog(frame, "충전할 금액:", "충전", JOptionPane.PLAIN_MESSAGE);

        // 올바른 입력값인지 확인
        if (input == null || input.trim().isEmpty()) {
            JOptionPane.showMessageDialog(frame, "금액을 입력하세요!", "입력 오류", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            int amount = Integer.parseInt(input.trim());

            if (amount <= 0) {
                JOptionPane.showMessageDialog(frame, "0원 이상의 금액을 입력하세요!", "입력 오류", JOptionPane.ERROR_MESSAGE);
                return;
            }

            user.setBalnace(user.getBalnace() + amount);

            model.addRow(new Object[]{java.time.LocalDateTime.now(), "충전", user.getBalnace()});

            model.fireTableDataChanged();  //테이블 갱신하는 메서드 중요!

            JOptionPane.showMessageDialog(frame, amount + "원이 충전되었습니다!", "충전 완료", JOptionPane.INFORMATION_MESSAGE);

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame, "숫자를 입력하세요!", "입력 오류", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void withdrawbalance() {
        String output = JOptionPane.showInputDialog(frame, "충전할 금액:", "충전", JOptionPane.PLAIN_MESSAGE);

        // 올바른 입력값인지 확인
        if (output == null || output.trim().isEmpty()) {
            JOptionPane.showMessageDialog(frame, "금액을 입력하세요!", "입력 오류", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            int amount = Integer.parseInt(output.trim());

            if (amount <= 0) {
                JOptionPane.showMessageDialog(frame, "0원 이상의 금액을 입력하세요!", "입력 오류", JOptionPane.ERROR_MESSAGE);
                return;
            }

            user.setBalnace(user.getBalnace() - amount);

            if (user.getBalnace() < 0) {
                JOptionPane.showMessageDialog(frame, "더이상 출금할수없습니다.", "출금오류", JOptionPane.ERROR_MESSAGE);
                return;
            }

            model.addRow(new Object[]{java.time.LocalDateTime.now(), "출금", user.getBalnace()});

            model.fireTableDataChanged();  //테이블 갱신하는 메서드 중요!

            JOptionPane.showMessageDialog(frame, amount + "원이 차감되었습니다!", "충전 완료", JOptionPane.INFORMATION_MESSAGE);

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame, "숫자를 입력하세요!", "입력 오류", JOptionPane.ERROR_MESSAGE);
        }
    }
}
