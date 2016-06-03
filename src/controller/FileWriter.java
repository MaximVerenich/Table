package controller;


import model.Human;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.List;

public class FileWriter {

    private List<Human> studentsList;
    private String fileName;

    public FileWriter(List<Human> studentsList, String fileName) {
        this.studentsList = studentsList;
        this.fileName = fileName;
        save();
    }

    private void save(){
        try {
            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = builderFactory.newDocumentBuilder();
            Document document = builder.newDocument();

            Element element = document.createElement("array_of_students");
            document.appendChild(element);

            for (Human student1 : studentsList) {

                Element student = document.createElement("student");
                element.appendChild(student);

                Element studentsSurname = document.createElement("students_surname");
                student.appendChild(studentsSurname);
                studentsSurname.appendChild(document.createTextNode(student1.getSurname()));

                Element studentsName = document.createElement("students_name");
                student.appendChild(studentsName);
                studentsName.appendChild(document.createTextNode(student1.getName()));

                Element studentsPatronomic = document.createElement("students_patronomic");
                student.appendChild(studentsPatronomic);
                studentsPatronomic.appendChild(document.createTextNode(student1.getPatronymic()));

                Element numberOfSisters = document.createElement("number_of_sisters");
                student.appendChild(numberOfSisters);
                numberOfSisters.appendChild(document.createTextNode(student1.getNumberOfSisters()));

                Element numberOfBrothers = document.createElement("number_of_brothers");
                student.appendChild(numberOfBrothers);
                numberOfBrothers.appendChild(document.createTextNode(student1.getNumberOfBrothers()));


                Element father = document.createElement("father");
                student.appendChild(father);

                Element fathersSurname = document.createElement("fathers_surname");
                father.appendChild(fathersSurname);
                fathersSurname.appendChild(document.createTextNode(student1.getFather().getSurname()));

                Element fathersName = document.createElement("fathers_name");
                father.appendChild(fathersName);
                fathersName.appendChild(document.createTextNode(student1.getFather().getName()));

                Element fathersPatronomic = document.createElement("fathers_patronomic");
                father.appendChild(fathersPatronomic);
                fathersPatronomic.appendChild(document.createTextNode(student1.getFather().getPatronymic()));

                Element fathersSalary = document.createElement("fathers_salary");
                father.appendChild(fathersSalary);
                fathersSalary.appendChild(document.createTextNode(student1.getFather().getSalary()));


                Element mother = document.createElement("mother");
                student.appendChild(mother);

                Element mothersSurname = document.createElement("mothers_surname");
                mother.appendChild(mothersSurname);
                mothersSurname.appendChild(document.createTextNode(student1.getMother().getSurname()));

                Element mothersName = document.createElement("mothers_name");
                mother.appendChild(mothersName);
                mothersName.appendChild(document.createTextNode(student1.getMother().getName()));

                Element mothersPatronomic = document.createElement("mothers_patronomic");
                mother.appendChild(mothersPatronomic);
                mothersPatronomic.appendChild(document.createTextNode(student1.getMother().getPatronymic()));

                Element mothersSalary = document.createElement("mothers_salary");
                mother.appendChild(mothersSalary);
                mothersSalary.appendChild(document.createTextNode(student1.getMother().getSalary()));

            }

            TransformerFactory factory = TransformerFactory.newInstance();
            Transformer transformer = factory.newTransformer();

            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(new File(fileName));
            transformer.transform(source, result);
        } catch (ParserConfigurationException | TransformerException e) {
            e.printStackTrace();
        }
    }
}
