package persistance;

import Superhero.Superhero;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;

public class FileHandler {
    public void saveData(ArrayList<Superhero> superheroes) throws FileNotFoundException {
        PrintStream output = new PrintStream(new File("data\\superheroes.csv"));

        for (Superhero hero : superheroes) {
            output.print(hero.getSuperHeroName());
            output.print(";");
            output.print(hero.getReelName());
            output.print(";");
            output.print(hero.isHuman());
            output.print(";");
            output.print(hero.getSuperPower());
            output.print(";");
            output.print(hero.getCreationYear());
            output.print(";");
            output.print(hero.getPowerLevel());
            output.println();


        }
        output.close();
    }

}
