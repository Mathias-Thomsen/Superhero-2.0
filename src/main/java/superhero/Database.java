package superhero;

import java.util.ArrayList;

public class Database {
    public ArrayList<Superhero> superheroes = new ArrayList<>();

    public void createSuperHero(String superHeroName, String reelName, boolean isHuman, String superPower, int creationYear, double powerLevel) {
        Superhero newSuperHero = new Superhero(superHeroName, reelName, isHuman, superPower, creationYear, powerLevel);
        superheroes.add(newSuperHero);

    }
    public ArrayList<Superhero> getSuperheroes() {
        return superheroes;
    }
    public void clearData() {
        superheroes.clear();
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










