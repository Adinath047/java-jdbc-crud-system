import java.sql.*;
import java.util.Scanner;

public class student {
    Static Scanner sc = new Scanner(System.in);


    static Connection con;

    public static void main(String[] args) throws Exception {

        con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/database_name",
                "root",
                "test1234"
        );

        private int id;
        private int age;
        private String name;
        private String email;
        private String course;

        public student(int id,int age,String name,String email,String course){
            this.id=id;
            this.age=age;
            this.name=name;
            this.email=email;
            this.course=course;
        }


        }

