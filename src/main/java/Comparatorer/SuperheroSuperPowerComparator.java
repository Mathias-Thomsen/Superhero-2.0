package Comparatorer;

import Superhero.Superhero;

import java.util.Comparator;

public class SuperheroSuperPowerComparator implements Comparator<Superhero> {
    public int compare (Superhero d1, Superhero d2){
        return d1.getSuperPower().toLowerCase().compareTo(d2.getSuperPower().toLowerCase());
    }
}
