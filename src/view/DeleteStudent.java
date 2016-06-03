package view;

import controller.ControllerButtons;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteStudent {

    private ControllerButtons controllerButtons;
    private int result = 0;
    private WindowForOperation deleteWindow;

    public DeleteStudent(ControllerButtons controllerButtons) {
        this.controllerButtons = controllerButtons;
        deleteWindow = new WindowForOperation("Удалить");
        addDeleteButton();
    }

    private void addDeleteButton() {
        JButton deleteButton = new JButton("Удалить");
        deleteWindow.getPanelForButton().add(deleteButton);
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (deleteWindow.getCheckOperationForStudentsFIO() == 1) {
                    controllerButtons.deleteByStudentsFIO(deleteWindow);
                    deleteWindow.getMainFrame().setVisible(false);
                    showResultOfDelete();
                }
                if (deleteWindow.getCheckOperationForRelativesFIO() == 1) {
                    controllerButtons.deleteByRelativesFIO(deleteWindow);
                    deleteWindow.getMainFrame().setVisible(false);
                    showResultOfDelete();
                }
                if (deleteWindow.getCheckOperationForNumberOfSister() == 1) {
                    controllerButtons.deleteByNumberOfSisters(deleteWindow);
                    deleteWindow.getMainFrame().setVisible(false);
                    showResultOfDelete();
                }
                if (deleteWindow.getCheckOperationForNumberOfBrother() == 1) {
                    controllerButtons.deleteByNumberOfBrothers(deleteWindow);
                    deleteWindow.getMainFrame().setVisible(false);
                    showResultOfDelete();
                }
                if (deleteWindow.getCheckOperationForMothersSalary() == 1) {
                    controllerButtons.deleteBySalaryOfMother(deleteWindow);
                    deleteWindow.getMainFrame().setVisible(false);
                    showResultOfDelete();
                }
                if (deleteWindow.getCheckOperationForFathersSalary() == 1) {
                    controllerButtons.deleteBySalaryOfFather(deleteWindow);
                    deleteWindow.getMainFrame().setVisible(false);
                    showResultOfDelete();
                }
            }
        });
        deleteButton.setVisible(true);
    }

    private void showResultOfDelete() {
        JFrame resultOfDelete = new JFrame();
        resultOfDelete.setMinimumSize(new Dimension(150, 100));
        resultOfDelete.setVisible(true);
        JPanel jPanel = new JPanel();
        JLabel resultLabel = new JLabel("Удалено студентов: " + result);
        jPanel.add(resultLabel);
        resultOfDelete.add(jPanel);
    }

    public void setResult(int result) {
        this.result = result;
    }

}
