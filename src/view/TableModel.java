package view;

import model.Human;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class TableModel extends AbstractTableModel{

    public final static int FIO = 0;
    public final static int FATHER_FIO = 1;
    public final static int FATHER_SALERY = 2;
    public final static int MOTHER_FIO = 3;
    public final static int MOTHER_SALERY = 4;
    public final static int NUMB_OF_SISTERS = 5;
    public final static int NUMB_OF_BROTHERS = 6;
    public int columnIndex = 7;
    private List<Human> studentsList;

    public TableModel(List<Human> studentsList) {
        this.studentsList = studentsList;
    }

    @Override
    public int getRowCount() {
        return studentsList.size();
    }

    @Override
    public int getColumnCount() {
        return columnIndex;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex){
            case FIO:
                return (studentsList.get(rowIndex).getSurname() + " " + studentsList.get(rowIndex).getName() + " " + studentsList.get(rowIndex).getPatronymic());
            case FATHER_FIO:
                return (studentsList.get(rowIndex).getFather().getSurname() + " " + studentsList.get(rowIndex).getFather().getName() + " " + studentsList.get(rowIndex).getFather().getPatronymic());
            case FATHER_SALERY:
                return (studentsList.get(rowIndex).getFather().getSalary());
            case MOTHER_FIO:
                return (studentsList.get(rowIndex).getMother().getSurname() + " " + studentsList.get(rowIndex).getMother().getName() + " " + studentsList.get(rowIndex).getMother().getPatronymic());
            case MOTHER_SALERY:
                return (studentsList.get(rowIndex).getMother().getSalary());
            case NUMB_OF_SISTERS:
                return (studentsList.get(rowIndex).getNumberOfSisters());
            case NUMB_OF_BROTHERS:
                return (studentsList.get(rowIndex).getNumberOfBrothers());
        }
        return "";
    }

    @Override
    public String getColumnName(int columnIndex){
        switch (columnIndex){
            case FIO:
                return "Ф.И.О. студента";
            case FATHER_FIO:
                return "Ф.И.О. отца";
            case FATHER_SALERY:
                return "Зарплата отца";
            case MOTHER_FIO:
                return "Ф.И.О. матери";
            case MOTHER_SALERY:
                return "Зарплата матери";
            case NUMB_OF_SISTERS:
                return "Число сестер";
            case NUMB_OF_BROTHERS:
                return "Число братьев";
        }
        return "";
    }

    public void setStudentsList(List<Human> studentsList) {
        this.studentsList = studentsList;
    }
}
