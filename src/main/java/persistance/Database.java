package persistance;

import Comparatorer.*;
import Superhero.Superhero;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Database {
    public ArrayList<Superhero> superheroes = new ArrayList<>();



    public void createSuperHero(String superHeroName, String reelName, boolean isHuman, String superPower, int creationYear, double powerLevel) {
        Superhero newSuperHero = new Superhero(superHeroName, reelName, isHuman, superPower, creationYear, powerLevel);
        superheroes.add(newSuperHero);

    }
    public ArrayList<Superhero> getSuperheroes() {
        return superheroes;
    }

    public ArrayList<Superhero> findSuperhero(String searchTerm){
        ArrayList<Superhero> searchResult = new ArrayList<>();
        for (Superhero hero : superheroes) {
            if (hero.getSuperHeroName().contains(searchTerm)) {
                searchResult.add(hero);
            }
        }return searchResult;

    }

    public boolean deleteSuperhero(Superhero superhero) {
        boolean result = superheroes.remove(superhero);

        return result;

    }

    public void clearData(){
       superheroes.clear();
    }

    public void sortNameMethod() throws IOException {
        superheroes.sort(new SuperheroNameComparator());
    }

    public void sortSuperPower(){
        superheroes.sort(new SuperheroSuperPowerComparator());
    }

    public void sortSuperHeroRealName(){
        superheroes.sort(new SuperheroReelNameComparator());
    }

    public void sortCreationYear(){
        superheroes.sort(new SuperheroCreationYearComparator());
    }

    public void sortIsHuman(){
        superheroes.sort(new SuperheroIsHumanComparator());
    }

    public void sortPower(){
        superheroes.sort(new SuperheroPowerLevelComparator());
    }

    public void primaryNameSecondaryRealName(){
        superheroes.sort(new SuperheroNameComparator().thenComparing(new SuperheroReelNameComparator()));
    }

}









