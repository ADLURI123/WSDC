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
    private int hosteldue;
    private int librarydue;
    public Student(String name,String roll,String branch,String mobile,String email,String LoginId,String password,int hosteldue,int librarydue)
    {
        this.name = name;
        this.roll = roll;
        this.branch = branch;
        this.mobile = mobile;
        this.email = email;
        this.loginid  = LoginId;
        this.password = password;
        this.hosteldue = hosteldue;
        this.librarydue = librarydue;
    }
    public String getname()
    {
        return name;
    }
    public String getroll()
    {
        return roll;
    }
    public String getBranch(){return branch;}
    public String getMobile (){return mobile;}
    public String getEmail (){return email;}
    public int gethosteldue(){return hosteldue;}
    public int getlibrarydue(){return librarydue;}
}
