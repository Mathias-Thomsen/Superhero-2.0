import superhero.Superhero;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import database.Database;
import controller.Controller;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ControllerTest {
    Database database;
    Controller controller = new Controller();


    @BeforeEach
    public void setup() {
        database = new Database();

    }


    @Test
    public void testCreateSuperhero() {
        //Arrange
        Controller controller = new Controller();
        //Act
        database.createSuperHero("Superman", "Clark", false, "rig", 2001, 2);

        int actual = database.getSuperheroes().size();
        int expected = 1;

        //Assert
        assertEquals(expected, actual);
    }

    @Test
    public void testmultipleCreateSuperhero() {
        //Arrange
        database.createSuperHero("Superman", "Clark", false, "rig", 2001, 2);
        database.createSuperHero("Spiderman", "peter", true, "stærk", 1000, 2);
        database.createSuperHero("matyhias", "ksjdkf", false, "rig", 4000, 3.4);
        database.createSuperHero("Superman", "Clark", false, "rig", 2001, 2);
        database.createSuperHero("Aquaman","Arthur",false,"fish",1985,5);


        //Act

        int expected = 5;
        int actual = database.getSuperheroes().size();

        //Assert
        assertEquals(expected, actual);
    }


    @Test
    public void findSuperheroOneResult() {
        //Arrange
        Controller controller = new Controller();

        //Act


        ArrayList<Superhero> result = database.findSuperhero("Batman");
        ArrayList<Superhero> result2 = database.findSuperhero("Superman");

        int actualSize = result.size();

        int expectedSize = 0;

        //Assert
        assertEquals(actualSize, expectedSize);

    }

    @Test
    public void findSuperheroNoResult() {
        //Arrange
        Controller controller = new Controller();

        //Act


        ArrayList<Superhero> result = database.findSuperhero("Batman");
        int actualSize = result.size();
        int expectedSize = 0;

        //Assert
        assertEquals(actualSize, expectedSize);


    }

    /*
    @Test
    public void deleteSuperhero() {
        ArrayList<Superhero> result = database.getSuperheroes();
        Superhero superhero = result.get(0);


        boolean expectedResult = true;
        int expectedSize = result.size() - 1;

        boolean actualResult = database.deleteSuperhero(superhero);
        assertEquals(expectedResult, actualResult);


        ArrayList<Superhero> resultAfterDelete = database.getSuperheroes();
        int actualSize = resultAfterDelete.size();

        assertEquals(expectedSize, actualSize);
    }

     */




}

