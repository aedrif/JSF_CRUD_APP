package com.example.demo2.dao;

import com.example.demo2.models.Student;
import com.example.demo2.services.Db;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {


    public StudentDAO() {
    }

    public int addStudent(Student student){
        int c = 0;
        Db db = new Db();
        Connection con = db.getcon();
        try {
            ResultSet rs = con.createStatement().executeQuery("select id from student where email='"+ student.getEmail() +"';");
            if(!rs.next()){
                PreparedStatement pr = con.prepareStatement("INSERT INTO student (first_name, age, email) VALUES (?,?,?)");
                pr.setString(1,student.getFirst_name());
                pr.setInt(2,student.getAge());
                pr.setString(3,student.getEmail());
                pr.executeUpdate();
                c=1;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            db.closecon();
            return c;
        }
    }

    public List<Student> getStudents() {
        Db db = new Db();
        List<Student> list = new ArrayList<Student>();
        Connection con = db.getcon();
        try {
            ResultSet rs = con.createStatement().executeQuery("select * from student");
            while (rs.next()) {
                Student p = new Student(rs.getInt("id"),rs.getString("first_name"), rs.getInt("age"), rs.getString("email"));
                list.add(p);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            db.closecon();
            return list;
        }
    }

    public void editStudent(Student std) {
            Db db = new Db();
            Connection con = db.getcon();
            try {
                 PreparedStatement stmt = con.prepareStatement("UPDATE student SET first_name = ?, age = ?, email = ? WHERE id = ?");
                stmt.setString(1, std.getFirst_name());
                stmt.setInt(2, std.getAge());
                stmt.setString(3, std.getEmail());
                stmt.setInt(4, std.getId());
                System.out.println(stmt.executeUpdate());
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } finally {
                db.closecon();
            }
    }

    public void deleteStudent(int id) {
            Db db = new Db();
            Connection con = db.getcon();
            try (
                    PreparedStatement stmt = con.prepareStatement("DELETE FROM student WHERE id= ? ;")) {
                stmt.setInt(1, id);
                stmt.executeUpdate();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } finally {
                db.closecon();
            }
    }



}
