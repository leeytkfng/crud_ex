import Model.Card_Info;
import View.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

class mvc_pattern {
    ArrayList<Card_Info> list;
    Card_Info currentUser;
    View_Main main1;

    View_create create;
    View_search search;
    View_Delete delete;


    public mvc_pattern() {
        list = new ArrayList<Card_Info>();
        main1 = new View_Main();
        create = new View_create(list);
        search = new View_search(list);
        delete = new View_Delete(list);
    }

    public void initialize() {
        main1.show();
        main1.button[0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                main1.frame.dispose();
                create.show();
            }
        });
        main1.button[1].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                main1.frame.dispose();
                search.show();
            }
        });
        main1.button[2].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                main1.frame.dispose();
                delete.show();
            }
        });
        create.buttons[0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                list.add(new Card_Info(create.text[0].getText(),
                        create.text[1].getText(),
                        0,
                        (long) (Math.random()*100000)));
                if(create.text[0].getText().isEmpty() || create.text[1].getText().isEmpty()){
                    JOptionPane.showMessageDialog(null,"아이디나 비밀번호가 적절하지않습니다.");
                } else {
                    JOptionPane.showMessageDialog(null,"생성완료" );
                    create.frame.dispose();
                    main1.show();
                }
                for(int i = 0; i< create.text.length; i++){
                    create.text[i].setText(null);
                }
            }
        });
        create.buttons[1].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                create.frame.dispose();
                main1.show();
            }
        });



        search.buttons[0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userId = search.texts[0].getText();
                currentUser = findUserById(userId);
                search.updateText();
                for(int i =0 ; i<search.texts.length;i++){
                    search.texts[i].setText(null);
                }
            }
        });

        search.buttons[1].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                search.frame.dispose();
                main1.show();
            }
        });
        delete.buttons[0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                delete.DeleteText();
            }
        });
        delete.buttons[1].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                delete.frame.dispose();
                main1.show();
            }
        });

    }
    private Card_Info findUserById(String userId) {
        for (Card_Info cardInfo : list) {
            if (cardInfo.getId().equals(userId)) {
                return cardInfo;
            }
        }
        return null;
    }
}

public class Main {
    public static void main(String[] args) {
        mvc_pattern mvc = new mvc_pattern();
        mvc.initialize();
    }
}