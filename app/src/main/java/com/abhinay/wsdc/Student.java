package com.abhinay.wsdc;

public class Student
{
    private String name;
    private String roll;
    private String branch;
    private String mobile;
    private String email;
    private String loginid;
    private String password;
    public Student(String name,String roll,String branch,String mobile,String email,String LoginId,String password)
    {
        this.name = name;
        this.roll = roll;
        this.branch = branch;
        this.mobile = mobile;
        this.email = email;
        this.loginid  = LoginId;
        this.password = password;
    }
    public String getLoginid()
    {
        return loginid;
    }
    public String getPassword()
    {
        return password;
    }
}
