package com.foo.ssuroid;

public class MemberInfo {

    //학과, 이름, 학번, 배송지 주소, 전화번호
    private  String department;
    private  String name;
    private  String studentID;
    private  String address;
    private  String phoneNumber;


    public MemberInfo(String department, String name, String studentID, String address, String phoneNumber){
        this.department = department;
        this.name = name;
        this.studentID = studentID;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public String getDepartment(){
        return this.department;
    }

    public void setDepartment(String department){
        this.department=department;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name=name;
    }

    public String getStudentID(){
        return this.studentID;
    }

    public void setStudentID(String studentID){
        this.studentID=studentID;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address){
        this.address=address;
    }

    public String getPhoneNumber(){
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber=phoneNumber;
    }
}

