package view;


import controller.ControllerButtons;
import model.Human;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class AddNewStudent {
    private JFrame addFrame;
    private JPanel panelForFilds;
    private JPanel panelForButton;

    private JTextField studentsNameTextField;
    private JTextField studentsSurnameTextField;
    private JTextField studentsPatronomicTextField;

    private JTextField fathersNameTextField;
    private JTextField fathersSurnameTextField;
    private JTextField fathersPatronomicTextField;
    private String fathersSalary = new String();

    private JTextField mothersNameTextField;
    private JTextField mothersSurnameTextField;
    private JTextField mothersPatronomicTextField;
    private String mothersSalary = new String();

    private String numberOfSisters = "0";
    private String numberOfBrothers = "0";

    private ControllerButtons controllerButtons;

    public AddNewStudent(ControllerButtons controllerButtons) {
        this.controllerButtons = controllerButtons;
        addFrame = new JFrame();
        addFrame.setSize(300, 355);
        createPanelsOnFrame();
        addFrame.setVisible(true);
        createStudent();
        createFather();
        createMother();
        createNumberOfSisters();
        createNumberOfBrothers();
        createButtonOK();
    }

    private void createPanelsOnFrame() {
        panelForFilds = new JPanel();
        panelForButton = new JPanel();
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new BoxLayout(jPanel, BoxLayout.Y_AXIS));
        jPanel.add(panelForFilds);
        jPanel.add(panelForButton);
        addFrame.add(jPanel);
        panelForFilds.setLayout(new BoxLayout(panelForFilds, BoxLayout.Y_AXIS));
    }

    private void createButtonOK() {
        JButton OKButton = new JButton("OK");
        panelForButton.add(OKButton);

        OKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controllerButtons.addStudent();
                addFrame.setVisible(false);

            }
        });
    }

    private void createStudent() {
        textFieldForStudentsSurname();
        textFieldForStudentsName();
        textFieldForStudentsPatronymic();
    }

    private void createFather() {
        textFieldForFathersSurname();
        textFieldForFathersName();
        textFieldForFathersPatronymic();
        createFathersSalary();
    }

    private void createMother() {
        textFieldForMothersSurname();
        textFieldForMothersName();
        textFieldForMothersPatronymic();
        createMothersSalary();
    }

    private void createFathersSalary() {
        String[] salary = {
                "0 - 50$",
                "50 - 100$",
                "100 - 300$",
                "300 - 500$",
                "500 - 700$",
                "700 - 1000$",
                "1000 - 1500$",
                "более 1500$"
        };
        JComboBox fathersSalaryBox = new JComboBox(salary);
        createNumber(fathersSalaryBox, "Зарплата отца");
        fathersSalaryBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                fathersSalary = e.getItem().toString();
            }
        });
    }

    private void createMothersSalary() {
        String[] salary = {
                "0 - 50$",
                "50 - 100$",
                "100 - 300$",
                "300 - 500$",
                "500 - 700$",
                "700 - 1000$",
                "1000 - 1500$",
                "более 1500$"
        };
        JComboBox mothersSalaryBox = new JComboBox(salary);
        createNumber(mothersSalaryBox, "Зарплата матери");
        mothersSalaryBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                mothersSalary = e.getItem().toString();
            }
        });
    }

    private void createNumberOfSisters() {
        String[] salary = {
                "0",
                "1",
                "2",
                "3",
                "4",
                "5",
                "6",
                "более 6"
        };
        JComboBox numberOfSistersBox = new JComboBox(salary);
        createNumber(numberOfSistersBox, "Количество сестёр");
        numberOfSistersBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                numberOfSisters = e.getItem().toString();
            }
        });
    }

    private void createNumberOfBrothers() {
        String[] salary = {
                "0",
                "1",
                "2",
                "3",
                "4",
                "5",
                "6",
                "более 6"
        };
        JComboBox numberOfBrothersBox = new JComboBox(salary);
        createNumber(numberOfBrothersBox, "Количество братьев");
        numberOfBrothersBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                numberOfBrothers = e.getItem().toString();
            }
        });
    }

    private void textFieldForStudentsName() {
        studentsNameTextField = new JTextField();
        createField(studentsNameTextField, "Имя студента");
    }

    private void textFieldForStudentsSurname() {
        studentsSurnameTextField = new JTextField();
        createField(studentsSurnameTextField, "Фамилия студента");
    }

    private void textFieldForStudentsPatronymic() {
        studentsPatronomicTextField = new JTextField();
        createField(studentsPatronomicTextField, "Отчество студента");
    }

    private void textFieldForFathersName() {
        fathersNameTextField = new JTextField();
        createField(fathersNameTextField, "Имя отца");
    }

    private void textFieldForFathersSurname() {
        fathersSurnameTextField = new JTextField();
        createField(fathersSurnameTextField, "Фамилия отца");
    }

    private void textFieldForFathersPatronymic() {
        fathersPatronomicTextField = new JTextField();
        createField(fathersPatronomicTextField, "Отчество отца");
    }

    private void textFieldForMothersName() {
        mothersNameTextField = new JTextField();
        createField(mothersNameTextField, "Имя матери");
    }

    private void textFieldForMothersSurname() {
        mothersSurnameTextField = new JTextField();
        createField(mothersSurnameTextField, "Фамилия матери");
    }

    private void textFieldForMothersPatronymic() {
        mothersPatronomicTextField = new JTextField();
        createField(mothersPatronomicTextField, "Отчество матери");
    }

    private void createField(JTextField jTextField, String nameOfField) {
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new BoxLayout(jPanel, BoxLayout.X_AXIS));
        jPanel.setAlignmentX(JComponent.LEFT_ALIGNMENT);
        jTextField.setMaximumSize(new Dimension(100, 20));
        JLabel jLabel = new JLabel(nameOfField);
        jLabel.setMaximumSize(new Dimension(140, 20));
        jPanel.add(jLabel);
        jPanel.add(jTextField);
        panelForFilds.add(jPanel);
    }

    private void createNumber(JComboBox jComboBox, String string) {
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new BoxLayout(jPanel, BoxLayout.X_AXIS));
        jPanel.setAlignmentX(JComponent.LEFT_ALIGNMENT);
        jComboBox.setMaximumSize(new Dimension(100, 20));
        JLabel jLabel = new JLabel(string);
        jLabel.setMaximumSize(new Dimension(140, 20));
        jPanel.add(jLabel);
        jPanel.add(jComboBox);
        panelForFilds.add(jPanel);
    }

    public JTextField getStudentsNameTextField() {
        return studentsNameTextField;
    }

    public JTextField getStudentsSurnameTextField() {
        return studentsSurnameTextField;
    }

    public JTextField getStudentsPatronomicTextField() {
        return studentsPatronomicTextField;
    }

    public JTextField getFathersNameTextField() {
        return fathersNameTextField;
    }

    public JTextField getFathersSurnameTextField() {
        return fathersSurnameTextField;
    }

    public JTextField getFathersPatronomicTextField() {
        return fathersPatronomicTextField;
    }

    public String getFathersSalary() {
        return fathersSalary;
    }

    public JTextField getMothersNameTextField() {
        return mothersNameTextField;
    }

    public JTextField getMothersSurnameTextField() {
        return mothersSurnameTextField;
    }

    public JTextField getMothersPatronomicTextField() {
        return mothersPatronomicTextField;
    }

    public String getMothersSalary() {
        return mothersSalary;
    }

    public String getNumberOfSisters() {
        return numberOfSisters;
    }

    public String getNumberOfBrothers() {
        return numberOfBrothers;
    }
}
