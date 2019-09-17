package com.ferhane.nearbyshop.Loginrequest;

import javax.validation.constraints.Size;

public class LoginForm {
    
    @Size(min=3, max = 60)
    private String username;

    @Size(min = 6, max = 40)
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}