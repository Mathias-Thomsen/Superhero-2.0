package fileHandler;

import database.Database;
import org.junit.jupiter.api.Test;

import java.io.IOException;


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