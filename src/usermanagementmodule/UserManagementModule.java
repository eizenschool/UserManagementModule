/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package usermanagementmodule;
import java.util.Scanner;
/**
 *
 * @author clogg
 */
public class UserManagementModule {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        StaffUser[] staffList = new StaffUser[50];
        int staffCount = 0;
        boolean running = true;
        
        while(running){
            System.out.println("Welcome!");
            System.out.println("1. Admin Login");
            System.out.println("2. Staff Login");
            System.out.println("3. Exit");
            
            System.out.println("Enter choice: ");
            int choice = input.nextInt();
            
            switch(choice){
                case 1:
                    //Handle Admin login
                    input.nextLine();
                    System.out.print("Enter admin username: ");
                    String adminUser = input.nextLine();
                    System.out.print("Enter admin password: ");
                    String adminPass = input.nextLine();
                    
                    if(adminUser.equals("admin")&& adminPass.equals("admin123")){
                     System.out.println("Login successful!\n");
                     AdminManager adminManager = new AdminManager(staffList,staffCount);
                     adminManager.showAdminMenu(input);
                     staffCount = adminManager.getStaffCount();
                    } else {
                        System.out.println("Invalid credentials!\n");
                    }
                    break;
                case 2: 
                    //Handle Staff login
                    break;
                case 3:
                    running = false;
                    System.out.println("Exiting Program...");
                    break;
                default:
                    System.out.println("Invalid input!");
            
            
            }            
    }
  }  
}
