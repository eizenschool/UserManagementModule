package usermanagementmodule;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author clogg
 */
public class User {
    private String username;
    private String password;
    private String role;
    
    public User(String username, String password, String role){
     this.username = username;
     this.password = password;
     this.role = role;
    }
    
    public String getUsername(){
        return username;
    }
    
    public String getRole() {
        return role;
    }
    
    public boolean checkPassword(String inputPassword){
        return this.password.equals(inputPassword);
    }    
    
}
