package Comparatorer;

import Superhero.Superhero;

import java.util.Comparator;

public class SuperheroNameComparator implements Comparator <Superhero> {
    public int compare(Superhero d1, Superhero d2) {
        return d1.getSuperHeroName().compareTo(d2.getSuperHeroName());
    }
}



