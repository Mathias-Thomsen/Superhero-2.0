package Comparatorer;

import superhero.Superhero;

import java.util.Comparator;

public class FlexibleComparator implements Comparator<Superhero> {
    private String sortBy;
    public FlexibleComparator(String sortBy){
        this.sortBy = sortBy;
    }
    @Override
    public int compare(Superhero o1, Superhero o2) {
        switch(sortBy){
            case "creationYear"->{
                return Integer.compare(o1.getCreationYear(),o2.getCreationYear());
            }
            case "heroName"->{
                return o1.getSuperHeroName().compareTo(o2.getSuperHeroName());
            }
            case "power"-> {
                return Double.compare(o1.getPowerLevel(),o2.getPowerLevel());
            }
            case "realName"->{
                return o1.getReelName().compareTo(o2.getReelName());
            }
            case "superPower"->{
                return o1.getSuperPower().compareTo(o2.getSuperPower());
            }
            case "isHuman" -> {
                return Boolean.compare(o1.isHuman(),o2.isHuman());
            }
        }
        return 0;
    }
}

