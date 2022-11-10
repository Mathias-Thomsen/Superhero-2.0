package database;

import Comparatorer.*;
import superhero.Superhero;
import java.io.IOException;
import java.util.ArrayList;

public class Database {
    private boolean change = false;
    public ArrayList<Superhero> superheroes = new ArrayList<>();


    public void createSuperHero(String superHeroName, String reelName, boolean isHuman, String superPower, int creationYear, double powerLevel) {
        Superhero newSuperHero = new Superhero(superHeroName, reelName, isHuman, superPower, creationYear, powerLevel);
        superheroes.add(newSuperHero);

        change = true; // To the save method, so we only save to the txt file if a change has been made.

    }
    public ArrayList<Superhero> getSuperheroes() {
        return superheroes;
    }

    public ArrayList<Superhero> findSuperhero(String searchTerm) {
        ArrayList<Superhero> searchResult = new ArrayList<>();
        for (Superhero hero : superheroes) {
            if (hero.getSuperHeroName().contains(searchTerm)) {
                searchResult.add(hero);
            }
        }
        return searchResult;

    }
    public boolean deleteSuperhero(Superhero superhero) {
        boolean result = superheroes.remove(superhero);

        change = true;

        return result;
    }
    public boolean isChange() {
        return change;
    }
    public void setChange(boolean change) {
        this.change = change;

    }
    public void clearData() {
        superheroes.clear();
    }
    public void sortNameMethod() throws IOException {
        superheroes.sort(new SuperheroNameComparator());
    }
    public void sortSuperPower() {
        superheroes.sort(new SuperheroSuperPowerComparator());
    }
    public void sortSuperHeroRealName() {
        superheroes.sort(new SuperheroReelNameComparator());
    }
    public void sortCreationYear() {
        superheroes.sort(new SuperheroCreationYearComparator());
    }
    public void sortIsHuman() {
        superheroes.sort(new SuperheroIsHumanComparator());
    }
    public void sortPower() {
        superheroes.sort(new SuperheroPowerLevelComparator());
    }
    public void primaryNameSecondaryRealName() {
        superheroes.sort(new SuperheroNameComparator().thenComparing(new SuperheroReelNameComparator()));
    }
    public void sortPrimaryAndSecondary(String primaryAttribute, String secondaryAttribute) {
        FlexibleComparator comparator = new FlexibleComparator(primaryAttribute);
        superheroes.sort(comparator.thenComparing(new FlexibleComparator(secondaryAttribute)));
    }
}









