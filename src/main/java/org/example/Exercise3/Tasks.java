package org.example.Exercise3;

import java.io.*;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;
import java.util.*;
import java.util.stream.Collectors;

public class Tasks {
    public static void main(String[] args) {
        StudentSystem ss = new StudentSystem("C:\\Users\\timur\\IdeaProjects\\oop-labs\\src\\main\\java\\org\\example\\Exercise3\\students.csv");
        for(Student s : ss.getStudents()){
            System.out.println(s);
        }
        System.out.println("________________________");
        System.out.println(ss.getHighestGPAStudent());
        System.out.println(ss.getLongestNameStudent());
        if(ss.getStudentByID(1).isPresent()){
            System.out.println(ss.getStudentByID(1).get());
        }
        System.out.println(ss.numStudents());

    }
}


class StudentNotFoundException extends NoSuchElementException{
    public StudentNotFoundException(String message){
        super(message);
    }
}

class EmptyStudentListException extends RuntimeException{
    public EmptyStudentListException(String message){
        super(message);
    }
}

class InvalidStudentDataException extends Exception{
    public InvalidStudentDataException(String message){
        super(message);
    }
}

class Student{
    private int ID;
    private String name;
    private String university;
    private String department;
    private double GPA;

    public Student(int ID, String name, String university, String department, double GPA) {
        this.ID = ID;
        this.name = name;
        this.university = university;
        this.department = department;
        this.GPA = GPA;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getGPA() {
        return GPA;
    }

    public void setGPA(double GPA) {
        this.GPA = GPA;
    }

    @Override
    public String toString() {
        return "Student{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", university='" + university + '\'' +
                ", department='" + department + '\'' +
                ", GPA=" + GPA +
                '}';
    }
}

class StudentSystem{
    private List<Student> students;

    public StudentSystem(List<Student> students) {
        this.students = students;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public StudentSystem(String filename){
        students = new ArrayList<>();
        try{
            BufferedReader read = new BufferedReader(
              new FileReader(filename)
            );
            List<String> line = read.lines().toList();
            for(String l : line){
                String[] parts = l.split(",");
                students.add(new Student(
                        Integer.parseInt(parts[0]),
                        parts[1],
                        parts[2],
                        parts[3],
                        Double.parseDouble(parts[4])
                ));
            }validateStudentData(students);
        }catch(IOException e){
            System.out.println("NO SUCH FILE");
        }catch(InvalidStudentDataException i){

        }
    }

    public static List<Student> readStudents(String fileName){
        StudentSystem studentsystem = new StudentSystem(fileName);
        return studentsystem.getStudents();
    }

    public int numStudents() {
        return students.size();
    }

    public Optional<Student> getStudentByID(int id){
        for(Student student : students){
            if(student.getID() == id){
                return Optional.of(student);
            }
        }
        return Optional.empty();
    }

    public Student getHighestGPAStudent(){
        if(this.students.size() == 0){
            throw new EmptyStudentListException("List is empty");
        }

        Student najveca  = this.students.get(0);

        for(Student student : students){
            if(student.getGPA() > najveca.getGPA()){
                najveca = student;
            }
        }
        return najveca;
    }

    public Student getLongestNameStudent() {
        if (this.students.size() == 0) {
            throw new EmptyStudentListException("List is empty");
        }

        Student najduze = students.get(0);
        for(Student student : students){
            if(student.getName().length() > najduze.getName().length()){
                najduze = student;
            }
        }
        return najduze;
    }

    private void validateStudentData(List<Student> studenti) throws InvalidStudentDataException{
        for(Student student : students){
            if(student.getGPA()<6 && student.getGPA()>10){
                throw new InvalidStudentDataException("Procitano pogresno");
            }
        }
    }


}