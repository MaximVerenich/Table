package model;

public class Human{
    public String name;
    public String surname;
    public String patronymic;
    public String numberOfSisters;
    public String numberOfBrothers;
    public Worker mother;
    public Worker father;

    public Human() {
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public String getNumberOfSisters() {
        return numberOfSisters;
    }

    public String  getNumberOfBrothers() {
        return numberOfBrothers;
    }

    public Worker getMother() {
        return mother;
    }

    public Worker getFather() {
        return father;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public void setNumberOfSisters(String numberOfSisters) {
        this.numberOfSisters = numberOfSisters;
    }

    public void setNumberOfBrothers(String numberOfBrothers) {
        this.numberOfBrothers = numberOfBrothers;
    }

    public void setMother(Worker mother) {
        this.mother = mother;
    }

    public void setFather(Worker father) {
        this.father = father;
    }
}
