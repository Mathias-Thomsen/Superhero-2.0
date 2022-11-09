package comparatorer;

import Superhero.Superhero;

import java.util.Comparator;

public class SuperheroCreationYearComparator implements Comparator <Superhero> {
    public int compare (Superhero d1, Superhero d2){
        return Integer.toString(d1.getCreationYear()).compareTo(Integer.toString(d2.getCreationYear()));
    }
}
