package Comparatorer;

import Superhero.Superhero;

import java.util.Comparator;

public class SuperheroPowerLevelComparator implements Comparator <Superhero> {
    public int compare (Superhero d1, Superhero d2){
        return Double.toString(d1.getPowerLevel()).compareTo(Double.toString(d2.getPowerLevel()));
    }
}
