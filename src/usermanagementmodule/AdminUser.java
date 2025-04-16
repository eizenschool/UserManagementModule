package usermanagementmodule;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author clogg
 */
public class AdminUser extends User{
    public AdminUser(String username, String password){
        super(username, password, "admin");
    }
}
