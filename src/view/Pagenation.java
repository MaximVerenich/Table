package view;


import controller.ControllerButtons;
import model.Human;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class Pagenation extends JPanel{
    private ControllerButtons controllerButtons;
    private int start = 0;
    private int finish = 0;
    private List<Human> list;

    public Pagenation(List<Human> list, ControllerButtons controllerButtons) {
        this.controllerButtons = controllerButtons;
        this.list = list;

        JButton previous = new JButton(new ImageIcon("images/previous.png"));
        previous.setPreferredSize(new Dimension(25, 25));

        JButton next = new JButton(new ImageIcon("images/next.png"));
        next.setPreferredSize(new Dimension(25, 25));

        JTextField pagenation = new JTextField();
        pagenation.setPreferredSize(new Dimension(24, 24));

        JButton toStart = new JButton(new ImageIcon("images/start.png"));
        toStart.setPreferredSize(new Dimension(25, 25));

        JButton toFinish = new JButton(new ImageIcon("images/finish.png"));
        toFinish.setPreferredSize(new Dimension(25, 25));

        add(toStart);
        add(previous);
        add(pagenation);
        add(next);
        add(toFinish);

        toStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controllerButtons.last(list, 0, Integer.valueOf(pagenation.getText()));
                start = Integer.valueOf(pagenation.getText());
                finish = list.size();
            }
        });

        toFinish.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controllerButtons.last(list, list.size() - Integer.valueOf(pagenation.getText()), list.size());
                start = 0;
                finish = list.size() - Integer.valueOf(pagenation.getText());
            }
        });

        previous.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (finish - Integer.valueOf(pagenation.getText()) <= 0) {
                    controllerButtons.last(list, 0, finish);
                    finish = list.size();
                    start = 0;

                } else {
                    controllerButtons.previous(list, finish, Integer.valueOf(pagenation.getText()));
                    if(finish == list.size()){
                        start = 0;
                    } else start = finish;
                    finish -= Integer.valueOf(pagenation.getText());
                }
            }
        });

        next.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (start + Integer.valueOf(pagenation.getText()) >=list.size()) {
                    controllerButtons.last(list, start, list.size());
                    start = 0;
                    finish = list.size();
                } else {
                    controllerButtons.next(list, start, Integer.valueOf(pagenation.getText()));
                    if(start == 0){
                        finish = list.size();
                    }
                    else finish = start;
                    start += Integer.valueOf(pagenation.getText());
                }
            }

        });
    }
}
