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

    public void getSortNameMethod() throws IOException {
        database.sortNameMethod();
    }

    public void getSortSuperPower(){
        database.sortSuperPower();
    }

    public void getSuperHerorealName(){
        database.sortSuperHeroRealName();
    }

    public void getSortCreationYear(){
        database.sortCreationYear();
    }

    public void getSortIsHuman(){
        database.sortIsHuman();
    }

    public void getSortPower(){
        database.sortPower();
    }

    public void getPrimaryNameSecondaryRealName(){
        database.primaryNameSecondaryRealName();
    }

    public void saveData()  {
        try {
            fileHandler.saveData(database.getSuperheroes());
        } catch (FileNotFoundException e) {
            System.out.println("File do not exist");
        }
    }

    public boolean isChange(){
        return database.isChange();
    }

    public void setChange(boolean change){
        database.setChange(change);
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

}

