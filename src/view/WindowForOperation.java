package view;

import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class WindowForOperation {

    private String operation;

    private JFrame mainFrame;
    private JPanel mainPanel;

    private JPanel panelForStudentsFIO = new JPanel();
    private JPanel panelForRelativesFIO = new JPanel();
    private JPanel panelForSistersAndBrothers = new JPanel();
    private JPanel panelForSalary = new JPanel();
    private JPanel panelForButton = new JPanel();

    private JCheckBox checkBoxOperationByStudentsFIO;
    private JCheckBox checkBoxOperationByRelativesFIO;
    private JCheckBox checkBoxOperationByNumberOfSistersOrBrothers;
    private JCheckBox checkBoxOperationBySalary;

    private JTextField studentsSurname;
    private JTextField studentsName;
    private JTextField studentsPatronomic;

    private JTextField relativesSurname;
    private JTextField relativesName;
    private JTextField relativesPatronomic;

    private String numberOfSisters = "0";
    private String numberOfBrothers = "0";
    private String salaryOfMother = "0 - 50$";
    private String salaryOfFather = "0 - 50$";

    private int checkOperationForStudentsFIO = 0;
    private int checkOperationForRelativesFIO = 0;
    private int checkOperationForNumberOfSister = 0;
    private int checkOperationForNumberOfBrother = 0;
    private int checkOperationForMothersSalary = 0;
    private int checkOperationForFathersSalary = 0;

    public WindowForOperation(String operation) {
        this.operation = operation;
        createMainFrame();
        componentsOfPanelForStudentsFIO();
        componentsOfPanelForRelativesFIO();
        componentsOfPanelForNumberOfBrothersOrSisters();
        componentsOfPanelForSalary();
    }

    private void createMainFrame() {
        mainFrame = new JFrame();
        mainFrame.setSize(410, 400);
        mainPanel = new JPanel();

        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        panelForStudentsFIO.setLayout(new BoxLayout(panelForStudentsFIO, BoxLayout.Y_AXIS));
        panelForRelativesFIO.setLayout(new BoxLayout(panelForRelativesFIO, BoxLayout.Y_AXIS));
        panelForSistersAndBrothers.setLayout(new BoxLayout(panelForSistersAndBrothers, BoxLayout.Y_AXIS));
        panelForSalary.setLayout(new BoxLayout(panelForSalary, BoxLayout.Y_AXIS));

        mainPanel.add(panelForStudentsFIO);
        mainPanel.add(panelForRelativesFIO);
        mainPanel.add(panelForSistersAndBrothers);
        mainPanel.add(panelForSalary);
        mainPanel.add(panelForButton);

        mainFrame.add(mainPanel);
        mainFrame.setVisible(true);
    }

    private void componentsOfPanelForStudentsFIO() {
        studentsSurname = new JTextField();
        studentsName = new JTextField();
        studentsPatronomic = new JTextField();

        studentsSurname.setEnabled(false);
        studentsName.setEnabled(false);
        studentsPatronomic.setEnabled(false);

        checkBoxOperationByStudentsFIO = new JCheckBox(operation + " по ФИО студента");
        checkBoxOperationByStudentsFIO.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (checkBoxOperationByStudentsFIO.isSelected() == true) {
                    checkBoxOperationByRelativesFIO.setEnabled(false);
                    checkBoxOperationByNumberOfSistersOrBrothers.setEnabled(false);
                    checkBoxOperationBySalary.setEnabled(false);

                    studentsSurname.setEnabled(true);
                    studentsName.setEnabled(true);
                    studentsPatronomic.setEnabled(true);

                    checkOperationForStudentsFIO = 1;
                } else {
                    checkBoxOperationByRelativesFIO.setEnabled(true);
                    checkBoxOperationByNumberOfSistersOrBrothers.setEnabled(true);
                    checkBoxOperationBySalary.setEnabled(true);

                    studentsSurname.setEnabled(false);
                    studentsName.setEnabled(false);
                    studentsPatronomic.setEnabled(false);

                    checkOperationForStudentsFIO = 0;
                }

            }
        });

        panelForStudentsFIO.add(checkBoxOperationByStudentsFIO);
        createField(studentsSurname, "Фамилия студента", panelForStudentsFIO);
        createField(studentsName, "Имя студента", panelForStudentsFIO);
        createField(studentsPatronomic, "Отчество студента", panelForStudentsFIO);
    }

    private void componentsOfPanelForRelativesFIO() {
        relativesSurname = new JTextField();
        relativesName = new JTextField();
        relativesPatronomic = new JTextField();

        relativesSurname.setEnabled(false);
        relativesName.setEnabled(false);
        relativesPatronomic.setEnabled(false);

        checkBoxOperationByRelativesFIO = new JCheckBox(operation + " по ФИО родителя");
        checkBoxOperationByRelativesFIO.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (checkBoxOperationByRelativesFIO.isSelected() == true) {
                    checkBoxOperationByStudentsFIO.setEnabled(false);
                    checkBoxOperationByNumberOfSistersOrBrothers.setEnabled(false);
                    checkBoxOperationBySalary.setEnabled(false);

                    relativesSurname.setEnabled(true);
                    relativesName.setEnabled(true);
                    relativesPatronomic.setEnabled(true);

                    checkOperationForRelativesFIO = 1;
                } else {
                    checkBoxOperationByStudentsFIO.setEnabled(true);
                    checkBoxOperationByNumberOfSistersOrBrothers.setEnabled(true);
                    checkBoxOperationBySalary.setEnabled(true);

                    relativesSurname.setEnabled(false);
                    relativesName.setEnabled(false);
                    relativesPatronomic.setEnabled(false);

                    checkOperationForRelativesFIO = 0;
                }
            }
        });

        panelForRelativesFIO.add(checkBoxOperationByRelativesFIO);
        createField(relativesSurname, "Фамилия родителя", panelForRelativesFIO);
        createField(relativesName, "Имя родителя", panelForRelativesFIO);
        createField(relativesPatronomic, "Отчество родителя", panelForRelativesFIO);
    }

    private void componentsOfPanelForNumberOfBrothersOrSisters() {
        checkBoxOperationByNumberOfSistersOrBrothers = new JCheckBox(operation + " по числу братьев или сестёр");
        panelForSistersAndBrothers.add(checkBoxOperationByNumberOfSistersOrBrothers);

        String[] numbers = {"0", "1", "2", "3", "4", "5", "6", "более 6"};

        JComboBox sistersComboBox = new JComboBox(numbers);
        JComboBox brothersComboBox = new JComboBox(numbers);
        sistersComboBox.setEnabled(false);
        brothersComboBox.setEnabled(false);

        checkBoxOperationByNumberOfSistersOrBrothers.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (checkBoxOperationByNumberOfSistersOrBrothers.isSelected() == true) {
                    checkBoxOperationByStudentsFIO.setEnabled(false);
                    checkBoxOperationByRelativesFIO.setEnabled(false);
                    checkBoxOperationBySalary.setEnabled(false);
                    sistersComboBox.setEnabled(true);
                    brothersComboBox.setEnabled(true);
                } else {
                    checkBoxOperationByStudentsFIO.setEnabled(true);
                    checkBoxOperationByRelativesFIO.setEnabled(true);
                    checkBoxOperationBySalary.setEnabled(true);
                    if (sistersComboBox.isEnabled() == true || brothersComboBox.isEnabled() == true) {
                        sistersComboBox.setEnabled(false);
                        brothersComboBox.setEnabled(false);
                    } else {
                        sistersComboBox.setEnabled(true);
                        brothersComboBox.setEnabled(true);
                    }
                }
                checkOperationForNumberOfSister = 0;
                checkOperationForNumberOfBrother = 0;
            }
        });

        createComboBox(sistersComboBox, "Количество сестер", panelForSistersAndBrothers);
        createComboBox(brothersComboBox, "Количество братьев", panelForSistersAndBrothers);

        sistersComboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                numberOfSisters = e.getItem().toString();
                if(checkBoxOperationByNumberOfSistersOrBrothers.isSelected() == true){
                    brothersComboBox.setEnabled(false);
                    checkOperationForNumberOfSister = 1;
                    checkOperationForNumberOfBrother = 0;
                }
            }
        });

        brothersComboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                numberOfBrothers = e.getItem().toString();
                if(checkBoxOperationByNumberOfSistersOrBrothers.isSelected() == true){
                    sistersComboBox.setEnabled(false);
                    checkOperationForNumberOfBrother = 1;
                    checkOperationForNumberOfSister = 0;
                }
            }
        });
    }

    private void componentsOfPanelForSalary(){
        checkBoxOperationBySalary = new JCheckBox(operation + " по зарплате родителя");
        panelForSalary.add(checkBoxOperationBySalary);
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

        JComboBox mothersSalary = new JComboBox(salary);
        JComboBox fathersSalary = new JComboBox(salary);
        fathersSalary.setEnabled(false);
        mothersSalary.setEnabled(false);

        checkBoxOperationBySalary.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(checkBoxOperationBySalary.isSelected() == true){
                    checkBoxOperationByStudentsFIO.setEnabled(false);
                    checkBoxOperationByRelativesFIO.setEnabled(false);
                    checkBoxOperationByNumberOfSistersOrBrothers.setEnabled(false);
                    fathersSalary.setEnabled(true);
                    mothersSalary.setEnabled(true);
                } else {
                    checkBoxOperationByStudentsFIO.setEnabled(true);
                    checkBoxOperationByRelativesFIO.setEnabled(true);
                    checkBoxOperationByNumberOfSistersOrBrothers.setEnabled(true);
                    if(mothersSalary.isEnabled() == true || fathersSalary.isEnabled() == true){
                        mothersSalary.setEnabled(false);
                        fathersSalary.setEnabled(false);
                    } else{
                        mothersSalary.setEnabled(true);
                        fathersSalary.setEnabled(true);
                    }
                }
                checkOperationForFathersSalary = 0;
                checkOperationForMothersSalary = 0;
            }
        });

        createComboBox(mothersSalary, "Зарплата матери", panelForSalary);
        createComboBox(fathersSalary, "Зарплата отца", panelForSalary);

        mothersSalary.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                salaryOfMother = e.getItem().toString();
                if(checkBoxOperationBySalary.isSelected() == true){
                    fathersSalary.setEnabled(false);
                    checkOperationForMothersSalary = 1;
                    checkOperationForFathersSalary = 0;
                }
            }
        });
        fathersSalary.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                salaryOfFather = e.getItem().toString();
                if(checkBoxOperationBySalary.isSelected() == true){
                    mothersSalary.setEnabled(false);
                    checkOperationForFathersSalary = 1;
                    checkOperationForMothersSalary = 0;
                }
            }
        });
    }

    private void createField(JTextField jTextField, String nameOfField, JPanel panel) {
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new BoxLayout(jPanel, BoxLayout.X_AXIS));
        jPanel.setAlignmentX(JComponent.LEFT_ALIGNMENT);
        jTextField.setMaximumSize(new Dimension(110, 20));
        JLabel jLabel = new JLabel(nameOfField);
        jLabel.setMaximumSize(new Dimension(201, 20));
        jPanel.add(jLabel);
        jPanel.add(jTextField);
        panel.add(jPanel);
    }

    private void createComboBox(JComboBox jComboBox, String string, JPanel panel){
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new BoxLayout(jPanel, BoxLayout.X_AXIS));
        jPanel.setAlignmentX(JComponent.LEFT_ALIGNMENT);
        jComboBox.setMaximumSize(new Dimension(110, 20));
        JLabel jLabel = new JLabel(string);
        jLabel.setMaximumSize(new Dimension(200, 20));
        jPanel.add(jLabel);
        jPanel.add(jComboBox);
        panel.add(jPanel);
    }

    public JPanel getPanelForButton() {
        return panelForButton;
    }

    public int getCheckOperationForStudentsFIO() {
        return checkOperationForStudentsFIO;
    }

    public int getCheckOperationForRelativesFIO() {
        return checkOperationForRelativesFIO;
    }

    public int getCheckOperationForNumberOfSister() {
        return checkOperationForNumberOfSister;
    }

    public int getCheckOperationForNumberOfBrother() {
        return checkOperationForNumberOfBrother;
    }

    public int getCheckOperationForMothersSalary() {
        return checkOperationForMothersSalary;
    }

    public int getCheckOperationForFathersSalary() {
        return checkOperationForFathersSalary;
    }

    public JFrame getMainFrame() {
        return mainFrame;
    }

    public JTextField getStudentsSurname() {
        return studentsSurname;
    }

    public JTextField getStudentsName() {
        return studentsName;
    }

    public JTextField getStudentsPatronomic() {
        return studentsPatronomic;
    }

    public JTextField getRelativesSurname() {
        return relativesSurname;
    }

    public JTextField getRelativesName() {
        return relativesName;
    }

    public JTextField getRelativesPatronomic() {
        return relativesPatronomic;
    }

    public String getNumberOfSisters() {
        return numberOfSisters;
    }

    public String getNumberOfBrothers() {
        return numberOfBrothers;
    }

    public String getSalaryOfMother() {
        return salaryOfMother;
    }

    public String getSalaryOfFather() {
        return salaryOfFather;
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }
}
