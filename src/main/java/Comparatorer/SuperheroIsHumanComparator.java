package Comparatorer;

import superhero.Superhero;

import java.util.Comparator;

public class SuperheroIsHumanComparator implements Comparator <Superhero> {
    public int compare (Superhero d1, Superhero d2){
        return Boolean.toString(d1.isHuman()).compareTo(Boolean.toString(d2.isHuman()));
    }
}