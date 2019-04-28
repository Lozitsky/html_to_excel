package com.kirilo.spring_mvc.html_to_excel.service;

import com.kirilo.spring_mvc.html_to_excel.model.Animal;

import java.util.ArrayList;
import java.util.List;

public class AnimalService {
    private static List animalList = new ArrayList();

    static {
        animalList.add(new Animal(1, "Lion", "Wild", true, 100));
        animalList.add(new Animal(2, "Tiger", "Wild", true, 90));
        animalList.add(new Animal(3, "Goat", "Domestic", true, 20));
        animalList.add(new Animal(4, "Elephant", "Wild", true, 1000));
    }

    public List getAnimalList() {
        //internally we will call business -> DAO
        return animalList;
    }
}
