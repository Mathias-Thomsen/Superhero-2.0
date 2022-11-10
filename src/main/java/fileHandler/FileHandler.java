package fileHandler;

import superhero.Superhero;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;


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
    public void loadData(ArrayList<Superhero> allSuperheroes) throws FileNotFoundException {

        Scanner reader = new Scanner(new File("data/superheroes.csv"));
        while(reader.hasNextLine()) {
            String line = reader.nextLine();

            Superhero dataObjekt = parseCsvLine(line);
            allSuperheroes.add(dataObjekt);
        }
    }
    private Superhero parseCsvLine(String line) {
        try {
            String[] parts = line.split(";");

            Superhero superheroLoadData = new Superhero();
            superheroLoadData.setSuperheroName(parts[0]);
            superheroLoadData.setReelName(parts[1]);
            superheroLoadData.setIsHuman(Boolean.parseBoolean(parts[2]));
            superheroLoadData.setSuperPower(parts[3]);
            superheroLoadData.setCreationYear(parts[4]);
            superheroLoadData.setPowerLevel(parts[5]);
            return superheroLoadData;

        } catch (NumberFormatException e ){
            System.out.println("Kan ikke loade data");
            return null;
        }
    }


}