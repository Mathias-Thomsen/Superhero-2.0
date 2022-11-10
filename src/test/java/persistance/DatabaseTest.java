package persistance;

import Superhero.Superhero;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;


class DatabaseTest {
    Database database = new Database();

    @Test
    void sortNameMethod() throws IOException {
        database.sortSuperHeroRealName();
        database.primaryNameSecondaryRealName();
        database.sortNameMethod();
    }
    @Test
    void sortSuperPower(){
        database.sortSuperPower();
        database.sortPower();
    }
    @Test
    void sortCreationYear(){
        database.sortCreationYear();
    }
    @Test
    void sortIsHuman(){
        database.sortIsHuman();
    }



}