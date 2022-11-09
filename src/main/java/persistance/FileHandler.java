package persistance;

import Superhero.Superhero;


import java.util.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

public class FileHandler {
    private ArrayList<Superhero> loadSuperheroData = new ArrayList<>();
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


    public ArrayList<Superhero> loadData() throws IOException {
        Scanner reader = new Scanner(new File("data\\superheroes"), StandardCharsets.ISO_8859_1);
        while(reader.hasNextLine()){
            String line = reader.nextLine();
            loadSuperheroData.add(parseCsvLine(line));

        }
        return loadSuperheroData;
    }


    public void sortNameMethod() throws IOException {
        loadData().sort(new comparatorer.SuperheroNameComparator());
    }


    public void primaryNameSecondaryIsHuman() throws IOException {
        loadData().sort(new comparatorer.SuperheroNameComparator().thenComparing(new SuperheroIsHumanComparator()));
    }

    public void primarySuperNameSecondaryReelName() throws IOException {
        loadData().sort(new comparatorer.SuperheroNameComparator());
    }


    private Superhero parseCsvLine(String line) {
        String[] parts = line.split(";");

        Superhero superheroLoadData = new Superhero();
        superheroLoadData.setReelName(parts[0]);

        superheroLoadData.setReelName(parts[1]);
        superheroLoadData.setIsHuman(Boolean.parseBoolean(parts[2]));
        superheroLoadData.setSuperPower(parts[3]);
        superheroLoadData.setCreationYear(Integer.parseInt(parts[4]));
        superheroLoadData.setPowerLevel(Integer.parseInt(parts[5]));
        return superheroLoadData;
    }


}
