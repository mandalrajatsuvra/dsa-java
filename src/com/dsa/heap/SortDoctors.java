package com.dsa.heap;


import java.util.*;

class Doctor{
    private String name;
    private String dept;
    private String id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDept() {
        return dept;
    }

    public String getId() {
        return id;
    }

    public Doctor(String name, String dept, String id) {
        this.name = name;
        this.dept = dept;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "name='" + name + '\'' +
                ", dept='" + dept + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}


public class SortDoctors {
    public static void main(String[] args) {
        Doctor d1 = new Doctor("Rajat", "Cardiology", "123");
        Doctor d2 = new Doctor("Nayan", "Ankology", "124");
        Doctor d3 = new Doctor("Amrita", "Cardiology", "125");
        Doctor d4 = new Doctor("Riya", "Phy", "126");
        Comparator<Doctor> comparator = (doc1, doc2)->{
            if(doc1.getDept().compareTo(doc2.getDept()) ==0){
                return doc1.getName().compareTo(doc2.getName());
            }
            return doc1.getDept().compareTo(doc2.getDept());
        };
        List<Doctor> doctors = Arrays.asList(d1, d2, d3, d4);
        Collections.sort(doctors, comparator);
        System.out.println(doctors);
    }

}
