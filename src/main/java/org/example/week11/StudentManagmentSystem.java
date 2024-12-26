package org.example.week11;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

class StudentSystem {
    List<Student> studenti;

        public StudentSystem(String filename){
            try{
                studenti = readStudents(filename);
            }catch(IOException e){
                studenti = new ArrayList<>();
                System.out.println("Unable to read file");
            }
        }
        public static void main(String[] args) throws IOException {
            StudentSystem system = new StudentSystem("C:\\Users\\timur\\IdeaProjects\\oop-labs\\src\\main\\java\\org\\example\\week11\\students.csv");

            Optional<Student> s = system.getStudentByID(5);

            Student highestGPA = system.getHighestGPAStudent();
            System.out.println(highestGPA);

            Student longestName = system.getLongestName();
            System.out.println(longestName);

        /*
            for(Student student : system.studenti){
                System.out.println(String.valueOf(student.ID())+" "+ student.name() + student.university() + student.department() + student.GPA());
            }
         */
        }

        public static List<Student> readStudents(String filename)throws IOException{
            List<Student> studenti = new ArrayList<>();
            BufferedReader bufferedReader = new BufferedReader(new FileReader(filename));
            List<String> lines = bufferedReader.lines().collect(Collectors.toList());
            for(String line : lines){
                String[] studentParts = line.split(",");

                Student s = new Student(
                        Integer.parseInt(studentParts[0]),
                        studentParts[1],
                        studentParts[2],
                        studentParts[3],
                        Double.parseDouble(studentParts[4])
                );
                studenti.add(s);
            }
            bufferedReader.close();
            return studenti;
    }
    public Optional<Student> getStudentByID(int id){
            for(Student s : studenti){
                if(s.ID() == id) return Optional.of(s);
            }
            return Optional.ofNullable(null);
    }

    public Student getHighestGPAStudent(){
            if(studenti.size() == 0) throw new EmptyStudentListException("List is empty");

            Student highestGPA = studenti.get(0);

            for(Student student : studenti){
                if(student.GPA() > highestGPA.GPA()) highestGPA = student;
            }
            return highestGPA;
    }

    public Student getLongestName(){
            if(studenti.size() == 0) throw new RuntimeException("It is empty");

            Student longestName = studenti.get(0);

            for(Student student : studenti){
                if(student.name().length() > longestName.name().length()) longestName = student;
            }
            return longestName;
    }

}



