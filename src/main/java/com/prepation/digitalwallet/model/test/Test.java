/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.prepation.digitalwallet.model.test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author NMSLAP570
 */
public class Test {

    public static void main(String args[]) {
        Person surya = new Person("surya");
        Person vikram = new Person("vikram");
        
        surya.setAddress(new Address("111111"));
        vikram.setAddress(new Address("111111"));
        
        
        List<Person> personList = new LinkedList<>();        
        personList.add(surya);
        personList.add(vikram);
                        
        System.out.println(personList.indexOf(surya));
        System.out.println(Arrays.toString(personList.toArray()));
        
        
        
    }

}
