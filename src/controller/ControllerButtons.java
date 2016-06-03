package controller;

import model.Human;
import model.Worker;
import view.AddNewStudent;
import view.DeleteStudent;
import view.MainFrame;
import view.Pagenation;
import view.SearchStudent;
import view.TableModel;
import view.WindowForOperation;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.util.ArrayList;
import java.util.List;

public class ControllerButtons {
    private MainFrame mainFrame;
    private TableModel tableModel;
    private List<Human> studentsList;
    private AddNewStudent addNewStudent;
    private DeleteStudent deleteStudent;
    private SearchStudent searchStudent;
    private JScrollPane jScrollPane;
    private JTable jTable;
    private List<Human> resultOfSearch = new ArrayList<>();

    public ControllerButtons() {
        mainFrame = new MainFrame(this);
        tableModel = new TableModel(studentsList);
        mainFrame.addTableModel(tableModel);
    }

    public void createNewStudent() {
        addNewStudent = new AddNewStudent(this);
    }

    public void addStudent() {
        Human student = new Human();
        Worker mother = new Worker();
        Worker father = new Worker();

        student.setName(addNewStudent.getStudentsNameTextField().getText());
        student.setSurname(addNewStudent.getStudentsSurnameTextField().getText());
        student.setPatronymic(addNewStudent.getStudentsPatronomicTextField().getText());

        father.setName(addNewStudent.getFathersNameTextField().getText());
        father.setSurname(addNewStudent.getFathersSurnameTextField().getText());
        father.setPatronymic(addNewStudent.getFathersPatronomicTextField().getText());
        father.setSalary(addNewStudent.getFathersSalary());

        mother.setName(addNewStudent.getMothersNameTextField().getText());
        mother.setSurname(addNewStudent.getMothersSurnameTextField().getText());
        mother.setPatronymic(addNewStudent.getMothersPatronomicTextField().getText());
        mother.setSalary(addNewStudent.getMothersSalary());

        student.setNumberOfSisters(addNewStudent.getNumberOfSisters());
        student.setNumberOfBrothers(addNewStudent.getNumberOfBrothers());
        student.father = father;
        student.mother = mother;

        studentsList.add(student);
        tableModel.setStudentsList(studentsList);
        jTable.setModel(tableModel);
        jTable.getColumnModel().getColumn(0).setMinWidth(190);
        jTable.getColumnModel().getColumn(1).setMinWidth(190);
        jTable.getColumnModel().getColumn(2).setMinWidth(90);
        jTable.getColumnModel().getColumn(3).setMinWidth(190);
        jTable.getColumnModel().getColumn(4).setMinWidth(90);
        jTable.updateUI();
    }

    public void deleteStudent() {
        deleteStudent = new DeleteStudent(this);
    }

    public void searchStudent() {
        tableModel.setStudentsList(studentsList);
        searchStudent = new SearchStudent(this, studentsList);
        searchStudent.setjScrollPane(jScrollPane);
    }


    public void deleteByStudentsFIO(WindowForOperation deleteWindow) {
        int numberOfDeleted = 0;
        int index = 0;
        while (index < studentsList.size()) {
            if (studentsList.get(index).getSurname().equals(deleteWindow.getStudentsSurname().getText()) &&
                    studentsList.get(index).getName().equals(deleteWindow.getStudentsName().getText()) &&
                    studentsList.get(index).getPatronymic().equals(deleteWindow.getStudentsPatronomic().getText())) {
                delete(index);
                numberOfDeleted++;
            } else index++;
        }
        deleteStudent.setResult(numberOfDeleted);
    }

    public void deleteByRelativesFIO(WindowForOperation deleteWindow) {
        int numberOfDeleted = 0;
        int index = 0;
        while (index < studentsList.size()) {
            if ((studentsList.get(index).getMother().getSurname().equals(deleteWindow.getRelativesSurname().getText()) &&
                    studentsList.get(index).getMother().getName().equals(deleteWindow.getRelativesName().getText()) &&
                    studentsList.get(index).getMother().getPatronymic().equals(deleteWindow.getRelativesPatronomic().getText())) || (
                    studentsList.get(index).getFather().getSurname().equals(deleteWindow.getRelativesSurname().getText()) &&
                            studentsList.get(index).getFather().getName().equals(deleteWindow.getRelativesName().getText()) &&
                            studentsList.get(index).getFather().getPatronymic().equals(deleteWindow.getRelativesPatronomic().getText()))
                    ) {
                delete(index);
                numberOfDeleted++;
            } else index++;
        }
        deleteStudent.setResult(numberOfDeleted);
    }

    public void deleteByNumberOfSisters(WindowForOperation deleteWindow) {
        int numberOfDeleted = 0;
        int index = 0;
        while (index < studentsList.size()) {
            if (studentsList.get(index).getNumberOfSisters().equals(deleteWindow.getNumberOfSisters())) {
                delete(index);
                numberOfDeleted++;
            } else index++;
        }
        deleteStudent.setResult(numberOfDeleted);

    }

    public void deleteByNumberOfBrothers(WindowForOperation deleteWindow) {
        int numberOfDeleted = 0;
        int index = 0;
        while (index < studentsList.size()) {
            if (studentsList.get(index).getNumberOfBrothers().equals(deleteWindow.getNumberOfBrothers())) {
                delete(index);
                numberOfDeleted++;
            } else index++;
        }
        deleteStudent.setResult(numberOfDeleted);

    }

    public void deleteBySalaryOfMother(WindowForOperation deleteWindow) {
        int numberOfDeleted = 0;
        int index = 0;
        while (index < studentsList.size()) {
            if (studentsList.get(index).getMother().getSalary().equals(deleteWindow.getSalaryOfMother())) {
                delete(index);
                numberOfDeleted++;
            } else index++;
        }
        deleteStudent.setResult(numberOfDeleted);
    }

    public void deleteBySalaryOfFather(WindowForOperation deleteWindow) {
        int numberOfDeleted = 0;
        int index = 0;
        while (index < studentsList.size()) {
            if (studentsList.get(index).getFather().getSalary().equals(deleteWindow.getSalaryOfFather())) {
                delete(index);
                numberOfDeleted++;
            } else index++;
        }
        deleteStudent.setResult(numberOfDeleted);
    }

    private void delete(int index) {
        studentsList.remove(index);
        tableModel.setStudentsList(studentsList);
        jTable.updateUI();
    }


    public void searchByStudentsFIO(WindowForOperation searchWindow) {
        resultOfSearch.clear();
        int numberOfSearches = 0;
        int index = 0;
        while (index < studentsList.size()) {
            if (studentsList.get(index).getSurname().equals(searchWindow.getStudentsSurname().getText()) &&
                    studentsList.get(index).getName().equals(searchWindow.getStudentsName().getText()) &&
                    studentsList.get(index).getPatronymic().equals(searchWindow.getStudentsPatronomic().getText())) {
                addStudentForSearch(resultOfSearch, index);
                numberOfSearches++;
            }
            index++;
        }
        searchStudent.setResult(numberOfSearches);
        tableModel.setStudentsList(resultOfSearch);
        jTable.updateUI();
    }

    public void searchByRelativesFIO(WindowForOperation searchWindow) {
        resultOfSearch.clear();
        int numberOfSearches = 0;
        int index = 0;
        while (index < studentsList.size()) {
            if ((studentsList.get(index).getMother().getSurname().equals(searchWindow.getRelativesSurname().getText()) &&
                    studentsList.get(index).getMother().getName().equals(searchWindow.getRelativesName().getText()) &&
                    studentsList.get(index).getMother().getPatronymic().equals(searchWindow.getRelativesPatronomic().getText())) || (
                    studentsList.get(index).getFather().getSurname().equals(searchWindow.getRelativesSurname().getText()) &&
                            studentsList.get(index).getFather().getName().equals(searchWindow.getRelativesName().getText()) &&
                            studentsList.get(index).getFather().getPatronymic().equals(searchWindow.getRelativesPatronomic().getText()))
                    ) {
                addStudentForSearch(resultOfSearch, index);
                numberOfSearches++;
            }
            index++;
        }
        searchStudent.setResult(numberOfSearches);
        tableModel.setStudentsList(resultOfSearch);
        jTable.updateUI();
    }

    public void searchByNumberOfSisters(WindowForOperation searchWindow) {
        resultOfSearch.clear();
        int numberOfSearches = 0;
        int index = 0;
        while (index < studentsList.size()) {
            if (studentsList.get(index).getNumberOfSisters().equals(searchWindow.getNumberOfSisters())) {
                addStudentForSearch(resultOfSearch, index);
                numberOfSearches++;
            }
            index++;
        }
        searchStudent.setResult(numberOfSearches);
        tableModel.setStudentsList(resultOfSearch);
        jTable.updateUI();
    }

    public void searchByNumberOfBrothers(WindowForOperation searchWindow) {
        resultOfSearch.clear();
        int numberOfSearches = 0;
        int index = 0;
        while (index < studentsList.size()) {
            if (studentsList.get(index).getNumberOfBrothers().equals(searchWindow.getNumberOfBrothers())) {
                addStudentForSearch(resultOfSearch, index);
                numberOfSearches++;
            }
            index++;
        }
        searchStudent.setResult(numberOfSearches);
        tableModel.setStudentsList(resultOfSearch);
        jTable.updateUI();
    }

    public void searchBySalaryOfMother(WindowForOperation searchWindow) {
        resultOfSearch.clear();
        int numberOfSearches = 0;
        int index = 0;
        while (index < studentsList.size()) {
            if (studentsList.get(index).getMother().getSalary().equals(searchWindow.getSalaryOfMother())) {
                addStudentForSearch(resultOfSearch, index);
                numberOfSearches++;
            }
            index++;
        }
        searchStudent.setResult(numberOfSearches);
        tableModel.setStudentsList(resultOfSearch);
        jTable.updateUI();
    }

    public void searchBySalaryOfFather(WindowForOperation searchWindow) {
        resultOfSearch.clear();
        int numberOfSearches = 0;
        int index = 0;
        while (index < studentsList.size()) {
            if (studentsList.get(index).getFather().getSalary().equals(searchWindow.getSalaryOfFather())) {
                addStudentForSearch(resultOfSearch, index);
                numberOfSearches++;
            }
            index++;
        }
        searchStudent.setResult(numberOfSearches);
        tableModel.setStudentsList(resultOfSearch);
        jTable.updateUI();
    }

    private void addStudentForSearch(List<Human> resultOfSearch, int index) {
        Human student = new Human();
        Worker mother = new Worker();
        Worker father = new Worker();

        student.setSurname(studentsList.get(index).getSurname());
        student.setName(studentsList.get(index).getName());
        student.setPatronymic(studentsList.get(index).getPatronymic());
        student.setNumberOfSisters(studentsList.get(index).getNumberOfSisters());
        student.setNumberOfBrothers(studentsList.get(index).getNumberOfBrothers());

        mother.setSurname(studentsList.get(index).getMother().getSurname());
        mother.setName(studentsList.get(index).getMother().getName());
        mother.setPatronymic(studentsList.get(index).getMother().getPatronymic());
        mother.setSalary(studentsList.get(index).getMother().getSalary());

        father.setSurname(studentsList.get(index).getFather().getSurname());
        father.setName(studentsList.get(index).getFather().getName());
        father.setPatronymic(studentsList.get(index).getFather().getPatronymic());
        father.setSalary(studentsList.get(index).getFather().getSalary());

        student.setMother(mother);
        student.setFather(father);

        resultOfSearch.add(student);
    }

    public void changeTableModel() {
        tableModel.setStudentsList(studentsList);
        mainFrame.getPanelForToolBarAndTable().add(jScrollPane);
        jTable.updateUI();
    }


    public void previous(List<Human> studentsList,int finish, int step){
        tableModel.setStudentsList(studentsList.subList(finish - step, finish));
        jTable.updateUI();
    }

    public void next(List<Human> studentsList, int start, int step){
        tableModel.setStudentsList(studentsList.subList(start, start + step));
        jTable.updateUI();
    }

    public void last(List<Human> studentsList, int start, int size){
        tableModel.setStudentsList(studentsList.subList(start, size));
        jTable.updateUI();
    }


    public void setjTable(JTable jTable) {
        this.jTable = jTable;
    }

    public void setStudentsList(List<Human> studentsList) {
        this.studentsList = studentsList;
    }

    public TableModel getTableModel() {
        return tableModel;
    }

    public void setjScrollPane(JScrollPane jScrollPane) {
        this.jScrollPane = jScrollPane;
    }

    public List<Human> getResultOfSearch() {
        return resultOfSearch;
    }
}
