package view;

import controller.ControllerButtons;
import model.Human;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.List;

public class SearchStudent {

    private ControllerButtons controllerButtons;
    private int result = 0;
    private WindowForOperation searchWindow;
    private JScrollPane jScrollPane;
    private List<Human> studentsList;
    private JPanel panelForPagenation = new JPanel();
    private int start = 0;
    private int finish = 0;

    public SearchStudent(ControllerButtons controllerButtons, List<Human> studentsList) {
        this.controllerButtons = controllerButtons;
        this.studentsList = studentsList;
        searchWindow = new WindowForOperation("Поиск");
        searchWindow.getMainFrame().addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {

            }

            @Override
            public void windowClosing(WindowEvent e) {
                controllerButtons.changeTableModel();
            }

            @Override
            public void windowClosed(WindowEvent e) {
                controllerButtons.changeTableModel();
            }

            @Override
            public void windowIconified(WindowEvent e) {

            }

            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent e) {

            }

            @Override
            public void windowDeactivated(WindowEvent e) {

            }
        });
        addSearchButton();
    }

    private void addSearchButton() {
        JButton searchButton = new JButton("Найти");
        searchWindow.getPanelForButton().add(searchButton);
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (searchWindow.getCheckOperationForStudentsFIO() == 1) {
                    controllerButtons.searchByStudentsFIO(searchWindow);
                    showResultOfSearch();
                }
                if (searchWindow.getCheckOperationForRelativesFIO() == 1) {
                    controllerButtons.searchByRelativesFIO(searchWindow);
                    showResultOfSearch();
                }
                if (searchWindow.getCheckOperationForNumberOfSister() == 1) {
                    controllerButtons.searchByNumberOfSisters(searchWindow);
                    showResultOfSearch();
                }
                if (searchWindow.getCheckOperationForNumberOfBrother() == 1) {
                    controllerButtons.searchByNumberOfBrothers(searchWindow);
                    showResultOfSearch();
                }
                if (searchWindow.getCheckOperationForMothersSalary() == 1) {
                    controllerButtons.searchBySalaryOfMother(searchWindow);
                    showResultOfSearch();
                }
                if (searchWindow.getCheckOperationForFathersSalary() == 1) {
                    controllerButtons.searchBySalaryOfFather(searchWindow);
                    showResultOfSearch();
                }
            }

        });
    }

    private void showResultOfSearch() {
        JFrame resultOfDelete = new JFrame();
        resultOfDelete.setMinimumSize(new Dimension(150, 100));
        resultOfDelete.setVisible(true);
        JPanel jPanel = new JPanel();
        JLabel resultLabel = new JLabel("Найдено студентов: " + result);
        jPanel.add(resultLabel);
        resultOfDelete.add(jPanel);
    }

    public void setjScrollPane(JScrollPane jScrollPane) {
        this.jScrollPane = jScrollPane;
        searchWindow.getMainPanel().add(jScrollPane, BorderLayout.SOUTH);
        //searchWindow.getMainPanel().add(panelForPagenation);
        addButtonsForPagenation();
        searchWindow.getMainFrame().setSize(1100, 600);
    }

    private void addButtonsForPagenation(){
        Pagenation pagenation = new Pagenation(controllerButtons.getResultOfSearch(), controllerButtons);
        searchWindow.getMainPanel().add(pagenation);
    }

    public void setResult(int result) {
        this.result = result;
    }
}
