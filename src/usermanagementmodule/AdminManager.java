/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usermanagementmodule;

import java.util.Scanner;
/**
 *
 * @author clogg
 */
public class AdminManager {
   private StaffUser[] staffList;
   private int staffCount;
   
   public AdminManager(StaffUser[] staffList, int staffCount){
       this.staffList = staffList;
       this.staffCount = staffCount;
   }
   
   public void showAdminMenu(Scanner input){
       boolean adminActive = true;
       while (adminActive){
           //Edit menu UI when you guys plug in your functions
           System.out.println("\n=== Admin Menu ===");
            System.out.println("1. Add Staff");
            System.out.println("2. View Staff");
            System.out.println("3. Delete Staff");
            System.out.println("4. Logout");
            System.out.print("Enter choice: ");
            int choice = input.nextInt();
            input.nextLine(); 

            switch (choice) {
                case 1:
                    addStaff(input);
                    break;
                case 2:
                    viewStaff();
                    break;
                case 3:
                    deleteStaff(input);
                    break;
                case 4:
                    adminActive = false;
                    System.out.println("Logging out of admin account...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    public void addStaff(Scanner input) {
        System.out.print("Enter new staff username: ");
        String username = input.nextLine();

        System.out.print("Enter password for staff: ");
        String password = input.nextLine();

        staffList[staffCount] = new StaffUser(username, password);
        staffCount++;

        System.out.println("Staff added successfully!");
    }

    public void viewStaff() {
        System.out.println("\n=== Staff List ===");
        if (staffCount == 0) {
            System.out.println("No staff accounts found.");
        } else {
            for (int i = 0; i < staffCount; i++) {
                System.out.println((i + 1) + ". " + staffList[i].getUsername());
            }
        }
    }

    public void deleteStaff(Scanner input) {
        System.out.print("Enter staff username to delete: ");
        String username = input.nextLine();
        boolean found = false;

        for (int i = 0; i < staffCount; i++) {
            if (staffList[i].getUsername().equals(username)) {
                found = true;
                // Shift staff array to cover hole
                for (int j = i; j < staffCount - 1; j++) {
                    staffList[j] = staffList[j + 1];
                }
                staffList[staffCount - 1] = null;
                staffCount--;
                System.out.println("Staff account deleted.");
                break;
            }
        }

        if (!found) {
            System.out.println("Staff not found.");
        }
    }

    public int getStaffCount() {
        return staffCount;
    }
}
       
  
