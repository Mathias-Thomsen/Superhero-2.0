package persistance;

import Superhero.Superhero;

import java.util.ArrayList;

public class Database {
    public ArrayList<Superhero> superheroes = new ArrayList<>();



   public void createTestData() {
        createSuperHero("Batman", "Bruce Wayne", false, "Money", 1939, 1.00);
        createSuperHero("Spiderman", "Peter Parker", true, "Spindelvæv", 2000, 1.00);
        createSuperHero("Wonder Women", "Diana Prince", true, "fly", 2010, 1.00);
    }


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
}









