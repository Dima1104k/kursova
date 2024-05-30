package com.example33.demo8.model;

import java.time.LocalDate;


public class User {
    private Integer id;
    private String firstName;
    private String lastName;
    private Group group; // Замість назви групи, зберігаємо об'єкт Група
    private String username;
    private String password;
    private String type;
    private LocalDate birthDate;
    private String faculty;
    private String educationForm;
    private int course;
    private String speciality;

    // Конструктор

    public User( Integer id, String firstName, String username, String password, String type) {
        this.id = id;
        this.firstName = firstName;
        this.username = username;
        this.password = password;
        this.type = type;
    }


    // Конструктор з усіма полями

    public User(Integer id, String firstName, String lastName, Group group, String username, String password, String type, LocalDate birthDate, String faculty, String educationForm, int course, String speciality) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.group = group;
        this.username = username;
        this.password = password;
        this.type = type;
        this.birthDate = birthDate;
        this.faculty = faculty;
        this.educationForm = educationForm;
        this.course = course;
        this.speciality = speciality;
    }

    // Геттери та сеттери
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getEducationForm() {
        return educationForm;
    }

    public void setEducationForm(String educationForm) {
        this.educationForm = educationForm;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }
}
