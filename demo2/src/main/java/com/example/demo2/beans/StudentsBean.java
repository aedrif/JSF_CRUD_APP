package com.example.demo2.beans;

import com.example.demo2.dao.StudentDAO;
import com.example.demo2.models.Student;

import java.util.List;

public class StudentsBean {

    private final StudentDAO dao = new StudentDAO();
    private List<Student> studentList = listStudents();
    private Boolean addForm;
    private String error = null;
    private Student newStudent;
    private Student selectedStd;
    private int currentPage = 1;
    private int totalpages;
    private String region = "en";

    public StudentsBean() {
        newStudent = new Student();
        addForm = false;
    }
    public List<Student> currentList(){
    return studentList.subList((currentPage - 1) * 5, Math.min(currentPage * 5, studentList.size()));
    }
    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public void showAddForm() {
        addForm = true;
    }

    public List<Student> listStudents(){
        List<Student> list =  dao.getStudents();
        if ( list.size() % 5 == 0 ){
            totalpages = (int)list.size() / 5;
        } else{
            totalpages = (int) Math.floor((double) list.size() / 5)+1;
        }
        return list;
    }
    public void addStudent(){
        this.addForm = false;
        if(dao.addStudent(newStudent) == 1){
            this.error = "Student added Succesfully";
        }else {
            this.error = "Failed to add student";
        }
        studentList = listStudents();
    }

    public Boolean getAddForm() {
        return addForm;
    }

    public Student getNewStudent() {
        return newStudent;
    }

    public void setNewStudent(Student newStudent) {
        this.newStudent = newStudent;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
        addForm = false;
    }

    public Student getSelectedStd() {
        return selectedStd;
    }

    public void setSelectedStd(Student selectedStd) {
        this.selectedStd = selectedStd;
        this.error = null;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }
    public void switchregion(){
        region= (region == "en") ? "fr": "en";
        this.error = null;
    }

    public void editStudent(Student std){
        dao.editStudent(std);
        selectedStd = null;
        studentList = listStudents();
    }
    public void deleteStudent(int id){
        dao.deleteStudent(id);
        studentList = listStudents();
        this.error = null;
    }

    public void previousPage() {
        currentPage--;
        addForm = false;
        this.error = null;
    }

    public void nextPage() {
        currentPage++;
        addForm = false;
        this.error = null;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public int getTotalpages() {
        return totalpages;
    }

    public void setTotalpages(int totalpages) {
        this.totalpages = totalpages;
        this.error = null;
    }
}
