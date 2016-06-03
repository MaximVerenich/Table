package controller;

import model.Human;
import model.Worker;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.swing.JTable;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class FileReader {

    private List<Human> studentsList;
    private String xmlFilePath;
    private JTable jTable;
    private ControllerButtons controllerButtons;

    public FileReader(List<Human> studentsList, String xmlFilePath, JTable jTable, ControllerButtons controllerButtons) {
        this.studentsList = studentsList;
        this.xmlFilePath = xmlFilePath;
        this.jTable = jTable;
        this.controllerButtons = controllerButtons;
        open();
    }

    private void open() {
        try {
            studentsList.clear();
            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = builderFactory.newDocumentBuilder();
            Document document = builder.parse(new File(xmlFilePath));

            NodeList letters = document.getElementsByTagName("student");
            NodeList studentsSurname = document.getElementsByTagName("students_surname");
            NodeList studentsName = document.getElementsByTagName("students_name");
            NodeList studentsPatronomic = document.getElementsByTagName("students_patronomic");
            NodeList numberOfSisters = document.getElementsByTagName("number_of_sisters");
            NodeList numberOfBrothers = document.getElementsByTagName("number_of_brothers");
            NodeList fathersSurname = document.getElementsByTagName("fathers_surname");
            NodeList fathersName = document.getElementsByTagName("fathers_name");
            NodeList fathersPatronomic = document.getElementsByTagName("fathers_patronomic");
            NodeList fathersSalary = document.getElementsByTagName("fathers_salary");
            NodeList mothersSurname = document.getElementsByTagName("mothers_surname");
            NodeList mothersName = document.getElementsByTagName("mothers_name");
            NodeList mothersPatronomic = document.getElementsByTagName("mothers_patronomic");
            NodeList mothersSalary = document.getElementsByTagName("mothers_salary");

            for (int studentIndex = 0; studentIndex < letters.getLength(); studentIndex++) {
                buildHumanObject(studentsSurname, studentsName, studentsPatronomic, numberOfSisters, numberOfBrothers,
                        fathersSurname, fathersName, fathersPatronomic, fathersSalary, mothersSurname, mothersName, mothersPatronomic,
                        mothersSalary, studentIndex);
            }

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        controllerButtons.getTableModel().setStudentsList(studentsList);
        jTable.setModel(controllerButtons.getTableModel());
        jTable.getColumnModel().getColumn(0).setMinWidth(190);
        jTable.getColumnModel().getColumn(1).setMinWidth(190);
        jTable.getColumnModel().getColumn(2).setMinWidth(90);
        jTable.getColumnModel().getColumn(3).setMinWidth(190);
        jTable.getColumnModel().getColumn(4).setMinWidth(90);
        jTable.updateUI();
    }

    private void buildHumanObject(NodeList studentsSurname, NodeList studentsName, NodeList studentsPatronomic,
                                  NodeList numberOfSisters, NodeList numberOfBrothers,
                                  NodeList fathersSurname, NodeList fathersName, NodeList fathersPatronomic, NodeList fathersSalary,
                                  NodeList mothersSurname, NodeList mothersName, NodeList mothersPatronomic, NodeList mothersSalary,int index) {
        Human student = new Human();
        Worker father = new Worker();
        Worker mother = new Worker();

        student.setSurname(studentsSurname.item(index).getFirstChild().getNodeValue());
        student.setName(studentsName.item(index).getFirstChild().getNodeValue());
        student.setPatronymic(studentsPatronomic.item(index).getFirstChild().getNodeValue());
        student.setNumberOfSisters(numberOfSisters.item(index).getFirstChild().getNodeValue());
        student.setNumberOfBrothers(numberOfBrothers.item(index).getFirstChild().getNodeValue());

        father.setSurname(fathersSurname.item(index).getFirstChild().getNodeValue());
        father.setName(fathersName.item(index).getFirstChild().getNodeValue());
        father.setPatronymic(fathersPatronomic.item(index).getFirstChild().getNodeValue());
        father.setSalary(fathersSalary.item(index).getFirstChild().getNodeValue());

        mother.setSurname(mothersSurname.item(index).getFirstChild().getNodeValue());
        mother.setName(mothersName.item(index).getFirstChild().getNodeValue());
        mother.setPatronymic(mothersPatronomic.item(index).getFirstChild().getNodeValue());
        mother.setSalary(mothersSalary.item(index).getFirstChild().getNodeValue());

//        student.setSurname(studentElement.getAttribute("Students_surname"));
//        student.setName(studentElement.getAttribute("Students_name"));
//        student.setPatronymic(studentElement.getAttribute("Students_patronomic"));
//
//        father.setSurname(studentElement.getAttribute("Fathers_surname"));
//        father.setName(studentElement.getAttribute("Fathers_name78iu"));
//        father.setPatronymic(studentElement.getAttribute("Fathers_patronomic"));
//        father.setSalary(studentElement.getAttribute("Fathers_salary"));
//
//        mother.setSurname(studentElement.getAttribute("Mothers_surname"));
//        mother.setName(studentElement.getAttribute("Mothers_name"));
//        mother.setPatronymic(studentElement.getAttribute("Mothers_patronomic"));
//        mother.setSalary(studentElement.getAttribute("Mothers_salary"));
//
//        student.setNumberOfSisters(studentElement.getAttribute("Number_of_sisters"));
//        student.setNumberOfBrothers(studentElement.getAttribute("Number_of_brothers"));
//
        student.setFather(father);
        student.setMother(mother);

        studentsList.add(student);
    }
}
