package ui;

import persistance.Database;
import persistance.FileHandler;
import Superhero.Superhero;

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





    public void saveData()  {
        try {
            fileHandler.saveData(database.getSuperheroes());
        } catch (FileNotFoundException e) {
            System.out.println("File do not exist");
        }
    }


    public void loadData() {
        try {
            database.clearData();
            fileHandler.loadData(database.getSuperheroes());
        }
        catch (FileNotFoundException e) {
            System.out.println("File do not exist");
        }

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

