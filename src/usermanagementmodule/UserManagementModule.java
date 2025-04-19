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
        
        MemberUser[] memberList = new MemberUser[50];
        int memberCount = 0;
        
        //Program State = running
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
                    //Admin Login Logic
                    input.nextLine();
                    
                    AdminUser admin = new AdminUser("admin","admin123");
                    System.out.print("Enter admin username: ");
                    String adminUser = input.nextLine();
                    System.out.print("Enter admin password: ");
                    String adminPass = input.nextLine();
                    
                    if(admin.getUsername().equals(adminUser)&& admin.checkPassword(adminPass)){
                     System.out.println("Login successful!\n");
                     AdminManager adminManager = new AdminManager(staffList,staffCount);
                     adminManager.showAdminMenu(input);
                     staffCount = adminManager.getStaffCount();
                    } else {
                        System.out.println("Invalid credentials!\n");
                    }
                    break;
                case 2: 
                    //Staff Login Logic
                    input.nextLine();
                    
                    System.out.print("Enter staff username: ");
                    String staffUsername = input.nextLine();
                    
                    System.out.print("Enter staff password: ");
                    String staffPassword = input.nextLine();
                    
                    boolean found = false;
                    StaffUser loggedInStaff = null;
                    
                    for(int i=0; i < staffCount; i++){
                        if(staffList[i].getUsername().equals(staffUsername)&& staffList[i].checkPassword(staffPassword)){
                            found = true;
                            loggedInStaff = staffList[i];
                            break;
                        }
                    }
                    //On succesful staff login
                    if(found){
                        System.out.println("Login successful! Welcome, " + loggedInStaff.getUsername());
                        boolean staffActive = true;
                        MembershipManager membershipManager = new MembershipManager(memberList, memberCount);
                        
                        while(staffActive){
                          System.out.println("\n=== Staff Menu ===");
                          System.out.println("1. Manage Memberships");
                          System.out.println("2. Reservation");
                          System.out.println("3. Purchase");
                          System.out.println("4. Inventory");
                          System.out.println("5. Logout");
                          System.out.print("Enter choice: ");
                          
                          int staffChoice = input.nextInt();
                          input.nextLine();
                          
                          switch(staffChoice){
                              case 1:
                                  membershipManager.showMemberMenu(input);
                                  memberCount = membershipManager.getMemberCount();
                                  break;
                              case 2:
                                  System.out.println("Redirecting to Reservation module...");
                                  break;
                              case 3:
                                  System.out.println("Redirecting to Purchase module");
                                  break;
                              case 4:
                                  System.out.println("Redirecting to Inventory Module");
                                  break;
                              case 5:
                                  staffActive = false;
                                  System.out.println("Logging out of staff account...");
                                  break;
                              default:
                                  System.out.println("Invalid input!");
                          }
                        }
                        
                    }else{
                        System.out.println("Invalid staff credentials!\n");
                    }
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
