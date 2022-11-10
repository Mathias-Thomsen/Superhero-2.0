package Comparatorer;

import superhero.Superhero;

import java.util.Comparator;

public class SuperheroNameComparator implements Comparator <Superhero> {
    public int compare(Superhero d1, Superhero d2) {
        return d1.getSuperHeroName().toLowerCase().compareTo(d2.getSuperHeroName().toLowerCase());
    }
}



