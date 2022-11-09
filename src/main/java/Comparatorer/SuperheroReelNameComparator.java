package comparatorer;

import Superhero.Superhero;

import java.util.Comparator;

public class SuperheroReelNameComparator implements Comparator <Superhero> {
    public int compare (Superhero d1, Superhero d2){
        return d1.getReelName().compareTo(d2.getReelName());
    }
}
