package com.example.demo.personnes.process;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PersonneBDD {
    private static List<Personne> personnes = new ArrayList<>();

    public static List<Personne> getAllPersonne() {
        return personnes;
    }

    public static void addPersonne(Personne p) {
        personnes.add(p);
    }

    public static void remove(int index) {
        personnes.remove(index);
    }

    public static void updateAge (int index, int age) {
        personnes.get(index).setAge(age);
    }

    public static Personne getById(int index) {
        return personnes.get(index);
    }

    public static void replace(int index, Personne p) {
        personnes.set(index, p);
    }

    public static List<Personne> filter(String prenom, int age) {
        return personnes.stream()
                .filter(p -> p.getPrenom().equals(prenom) && p.getAge() == age)
                .collect(Collectors.toList());

        /*List<Personne> newList = new ArrayList<>();
        for (Personne p : personnes) {
            if (p.getPrenom().equals(prenom) && p.getAge() == age) {
                newList.add(p);
            }
        }
        return newList;*/
    }


}
