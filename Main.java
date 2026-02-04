import java.sql.*;
import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static Connection con;

    public static void main(String[] args) throws Exception {

        con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/database_name",
                "root",
                "test1234"
        );

        while (true) {
            System.out.println("1.Register Student");
            System.out.println("2.Login Student");
            System.out.println("3.Delete Student");
            System.out.println("4.Update Student");
            System.out.println("5.Exit");
            System.out.println("Enter your choice: ");
         int choice = sc.nextInt();
         sc.nextLine();
         switch (choice) {
             case 1:insertStudentdata();break;
             case 2:loginStudent();break;
             case 3:deleteStudent();break;
             case 4:updateStudent();break;
             case 5: con.close();
             System.out.println("exited");
             return;
             default:
                 System.out.println("Invalid choice");
         }



        }
    }
    public static void insertStudentdata()throws Exception{
        String query="insert into Employees (studentID,FirstName,LastName,BirthDate,enroll,email,password)values (?,?,?,?,?,?,?)";
        PreparedStatement ps= con.prepareStatement(query);
        System.out.println("Enter Student ID:-(00):-");
        ps.setInt(1, sc.nextInt());
        sc.nextLine();
        System.out.println("Enter FirstName :-");
        ps.setString(2, sc.nextLine());
        System.out.println("Enter LastName :-");
        ps.setString(3, sc.nextLine());
        System.out.println("Enter BirthDate (YYYY-MM-DD):-");
        ps.setString(4, sc.nextLine());
        System.out.println("Enter Enrollment :-");
        ps.setString(5, sc.nextLine());
        System.out.println("Enter Email :-");
        ps.setString(6, sc.nextLine());
        System.out.println("Enter Password :-");
        ps.setString(7, sc.nextLine());
        System.out.println("Enrolled thanks 🙏🏻");

        ps.executeUpdate();
        ps.close();


    }
    public static void loginStudent()throws Exception{
     String query="select * from Employees where email=? and Password=?";
     PreparedStatement ps= con.prepareStatement(query);
     System.out.println("Enter email:");
     String email=sc.nextLine().trim();

     System.out.println("Enter Password:");
     String password=sc.nextLine().trim();
     ps.setString(1, email);
     ps.setString(2, password);
     ResultSet rs=ps.executeQuery();
     if(rs.next()){
         System.out.println("Email:"+rs.getString("email"));
         System.out.println("Welcome "+rs.getString("FirstName"));
     }else{
         System.out.println("Student ID not found or wrong password");
     }
     rs.close();
     ps.close();
    }
    public static void deleteStudent()throws Exception{
        String query="delete from Employees where studentID=?";
        PreparedStatement ps= con.prepareStatement(query);
        ps.setString(1,sc.nextLine());
        ps.executeUpdate();
        ps.close();
    }
    public static void updateStudent()throws Exception {
        System.out.println("1.Update name");
        System.out.println("2.Update surname");
        System.out.println("3.Update email");
        System.out.println("4.Update password");
        System.out.println("5.Update birthdate");
        System.out.println("Choice accordingly:-");
        int choices = sc.nextInt();
        switch (choices) {
            case 1:
                updateName();
                break;
            case 2:
                updateSurname();
                break;
            case 3:
                updateEmail();
                break;
            case 4:
                updatePassword();
                break;
            case 5:
                updateBirthDate();
                break;
            case 6:
                con.close();
                System.out.println("exited");
                return;
            default:
                System.out.println("Invalid choice");
        }

    }
       public static void updateName()throws Exception{
        String query="update Employees set FirstName=? where studentID=?";
        PreparedStatement ps= con.prepareStatement(query);
        System.out.println("Enter FirstName :-");
        ps.setString(1,sc.nextLine());
        sc.nextLine();
        System.out.println("Enter RollNo:-");
        ps.setInt(2,sc.nextInt());
        ps.executeUpdate();
           System.out.println("Successfully updated");
        ps.close();

       }
       public static void updateSurname()throws Exception{
        String query="update Employees set LastName=? where studentID=?";
        PreparedStatement ps= con.prepareStatement(query);
        System.out.println("Enter LastName :-");
        ps.setString(1,sc.nextLine());
        sc.nextLine();
        System.out.println("Enter RollNo:-");
        ps.setInt(2,sc.nextInt());
        ps.executeUpdate();
           System.out.println("Successfully updated");
        ps.close();

       }
       public static void updateEmail()throws Exception{
        String query="update Employees set Email=? where studentID=?";
        PreparedStatement ps= con.prepareStatement(query);
        System.out.println("Enter Email :-");
        ps.setString(1,sc.nextLine());
        sc.nextLine();
        System.out.println("Enter RollNo:-");
        ps.setInt(2,sc.nextInt());
        ps.executeUpdate();
           System.out.println("Successfully updated");
        ps.close();

       }
       public static void updatePassword()throws Exception{
        String query="update Employees set Password=? where studentID=?";
        PreparedStatement ps= con.prepareStatement(query);
        System.out.println("Enter Password :-");
        ps.setString(1,sc.nextLine());
        sc.nextLine();
        System.out.println("Enter RollNo:-");
        ps.setInt(2,sc.nextInt());
        ps.executeUpdate();
           System.out.println("Successfully updated");
        ps.close();

       }
       public static void updateBirthDate()throws Exception{
        String query="update Employees set BirthDate=? where studentID=?";
        PreparedStatement ps= con.prepareStatement(query);
        System.out.println("Enter BirthDate :-");
        ps.setString(1,sc.nextLine());
        sc.nextLine();
        System.out.println("Enter RollNo:-");
        ps.setInt(2,sc.nextInt());
        ps.executeUpdate();
        System.out.println("Successfully updated");
        ps.close();
       }


}
