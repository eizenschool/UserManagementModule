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
public class MembershipManager {
 private MemberUser[] memberList;
 private int memberCount;
 
 public MembershipManager(MemberUser[] memberList, int memberCount){
     this.memberList = memberList;
     this.memberCount = memberCount;
 }
 
 public void showMemberMenu(Scanner input){
   boolean active = true;
   while (active){
     System.out.println("\n=== Membership Menu ===");
            System.out.println("1. Add Member");
            System.out.println("2. View Members");
            System.out.println("3. Delete Member");
            System.out.println("4. Back");
            System.out.print("Enter choice: "); 
            
            int choice = input.nextInt();
            input.nextLine();
            
            switch(choice){
                case 1:
                    addMember(input);
                    break;
                case 2:
                    viewMembers();
                    break;
                case 3:
                    deleteMember(input);
                    break;
                case 4:
                    active = false;
                    break;
                default:
                    System.out.println("Invalid input.");
            }
    }
  }
 
 public void addMember(Scanner input){
     String tier = "";
     boolean validTier = false;
     
     System.out.print("Enter member name: ");
     String name = input.nextLine();
     
     System.out.print("Enter member email: ");
     String email = input.nextLine();
     
     System.out.print("Enter membership tier (Silver/Gold/Platinum): ");
     while(!validTier){
         System.out.print("Enter membership tier (Silver/Gold/Platinum): ");
         tier = input.nextLine();
         
         if(tier.equalsIgnoreCase("Silver")||
            tier.equalsIgnoreCase("Gold")||
            tier.equalsIgnoreCase("Platinum")){
             validTier = true;
         } else {
             System.out.println("Invalid tier. Please enter Silver, Gold, or Platinum.");
         }
     }
     
     //Link To Payment Here
     
     memberList[memberCount] = new MemberUser(name,email,tier);
     memberCount++;
     
     System.out.println("Member successfully registered!");
 }
 
 public void viewMembers(){
     System.out.println("\n=== Member List ===");
     if(memberCount==0){
         System.out.println("No registered members");
     }else{
         for(int i = 0; i < memberCount; i++){
             System.out.println((i+1)+ ". " + memberList[i]);
         }
     }
 }
 
 public void deleteMember(Scanner input){
     System.out.print("Enter email of member to delete: ");
     String email = input.nextLine();
     
     boolean found = false;
     for (int i = 0; i<memberCount; i++){
         if (memberList[i].getEmail().equals(email)){
             found = true;
             //Shift array to cover hole
             for(int j = i; j < memberCount-1; j++){
                 memberList[j] = memberList[j + 1];
             }
             memberList[memberCount - 1] = null;
             memberCount--;
             System.out.println("Member deleted.");
             break;
         }
       }
     if(!found){
         System.out.println("Member not found");
     }
}
 public int getMemberCount(){
     return memberCount;
 }
 
 public MemberUser findMemberByEmail(String email){
     for(int i = 0; i < memberCount; i++){
         if(memberList[i].getEmail().equals(email)){
             return memberList[i];
         }
     }
     return null;
 }
}