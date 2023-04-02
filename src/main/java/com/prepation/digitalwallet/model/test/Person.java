/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.prepation.digitalwallet.model.test;

import java.util.Objects;

/**
 *
 * @author NMSLAP570
 */
public class Person {
    
    private String name;
    
    private Address address;

    public Person(String name) {
        this.name = name;
    }
    
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 13 * hash + Objects.hashCode(this.address);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Person other = (Person) obj;
        if (!Objects.equals(this.address, other.address)) {
            return false;
        }
        return true;
    }

    

//    @Override
//    public int hashCode() {
//        int hash = 7;
//        hash = 79 * hash + Objects.hashCode(this.address);
//        return hash;
//    }
//
//    @Override
//    public boolean equals(Object obj) {
//        if (this == obj) {
//            return true;
//        }
//        if (obj == null) {
//            return false;
//        }
//        if (getClass() != obj.getClass()) {
//            return false;
//        }
//        final Person other = (Person) obj;
//        if (!Objects.equals(this.address, other.address)) {
//            return false;
//        }
//        return true;
//    }


    @Override
    public String toString() {
        return "Person{" + "name=" + name + ", address=" + address + '}';
    }
    
    
    
}
