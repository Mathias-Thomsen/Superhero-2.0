import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class Controller {
    Database database = new Database();
    FileHandler fileHandler = new FileHandler();
    Superhero superhero;


    public void createSuperHero(String superHeroName, String reelName, boolean isHuman, String superPower, int creationYear, double styrke) {
        database.createSuperHero(superHeroName, reelName, isHuman, superPower, creationYear, styrke);
    }

    public ArrayList<Superhero> getSuperheroes() {
        return database.getSuperheroes();
    }

    public ArrayList<Superhero> findSuperhero(String searchTerm) {
        return database.findSuperhero(searchTerm);
    }

    public void deleteSuperhero(Superhero deleteSuperhero) {
        database.deleteSuperhero(deleteSuperhero);

    }

    public void createTestData() {
        database.createTestData();
    }



    public void saveData() throws FileNotFoundException {
        fileHandler.saveData(database.getSuperheroes());
    }

    public void loadData() throws IOException {
        fileHandler.loadData();

    }

    public String getSuperHeroName() {
        return superhero.getSuperHeroName();
    }

    public String getSuperPower() {
        return superhero.getSuperPower();
    }

    public String getReelName() {
        return superhero.getReelName();
    }

    public int getCreationYear() {
        return superhero.getCreationYear();
    }

    public boolean isHuman() {
        return superhero.isHuman();
    }

    public double getPowerLevel() {
        return superhero.getPowerLevel();
    }
}

