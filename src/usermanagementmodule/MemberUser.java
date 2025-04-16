/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usermanagementmodule;

/**
 *
 * @author clogg
 */
public class MemberUser {
    private String name;
    private String email;
    private String membershipType;
    
    public MemberUser(String name, String email, String membershipType){
        this.name = name;
        this.email = email;
        this.membershipType = membershipType;
    }
    
    public String getName(){
        return name;
    }
    
    public String getEmail(){
        return email;
    }
    
    public String getMembershipType(){
        return membershipType;
    }
    
    public void setMembershipType(String membershipType){
        this.membershipType = membershipType;
    }
    
    @Override
    public String toString() {
        return "Name: " + name + " | Email: " + email + " | Membership: " + membershipType;
    }
}
