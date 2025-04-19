/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usermanagementmodule;

/**
 *
 * @author clogg
 */
public class StaffUser extends User{
    public StaffUser(String username, String password){
        super(username, password, "staff");
    }
}

