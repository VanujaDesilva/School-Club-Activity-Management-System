package com.example.ood_cw;
public class Student {
    private int stdId;
    private String firstName;
    private String lastName;
    private int telNo;
    private String dob;

    public Student(int stdId, String firstName, String lastName, int telNo, String dob) {
        this.stdId = stdId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.telNo = telNo;
        this.dob = dob;
    }

    public int getStdId() {
        return stdId;
    }

    public void setStdId(int stdId) {
        this.stdId = stdId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getTelNo() {
        return telNo;
    }

    public void setTelNo(int telNo) {
        this.telNo = telNo;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }
}

