package superhero;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Userinterface {
    Scanner scanner = new Scanner(System.in);
    Controller controller = new Controller();
    private String name;
    boolean userValgFalse = false;


    public void menu() {
        int menuValg = 0;

        while (menuValg != 9) {
            System.out.println("""
            -------------------------
            Database med superheroes!
            -------------------------
            1. Opret superhero
            2. Se liste af superheroes
            3. Søg efter superheroes
            4. Redigere superhero
            5. Slet superhero
            6. Gem liste af superheroes
            7. Load liste af superheroes
            9. Afslut
            """);


            do {
                try {
                    menuValg = scanner.nextInt();
                    scanner.nextLine();
                    startprogram(menuValg);
                    userValgFalse = false;
                } catch (InputMismatchException e) {
                    System.out.print("Der skete en fejl! - Indtast venligst et gyldigt nummer: ");
                    userValgFalse = true;
                    scanner.nextLine();
                }

            } while (userValgFalse);
        }
    }
    public void startprogram(int menuValg)  {
        if (menuValg == 1) {
            createSuperhero();
        } else if (menuValg == 2) {
            showListOfSuperheroes();
        } else if (menuValg == 3) {
            searchSuperhero();
        } else if (menuValg == 4) {
            editSuperhero();
        } else if (menuValg == 5) {
            deleteSuperheroUserInput();
        } else if (menuValg == 6) {
            saveData();
        } else if (menuValg == 7){
            loadData();
        } else if (menuValg == 9) {
            System.out.println("Programmet afsluttes");
        }

    }


    public void loadData() {
        controller.loadData();
        System.out.println("Data has been loaded!");
    }
    public void saveData(){
        controller.saveData();
        System.out.println("Data has been saved!");
    }
    public void createSuperhero() {
        System.out.println("-----------------------------------------------------");
        System.out.print("Indtast navnet på din superhelt (fx Spiderman): ");

        String superHeroName = scanner.nextLine();

        while (superHeroName.isEmpty() || superHeroName.equals(" ")) {
            System.out.print("Indtast venligst et navn:");
            superHeroName = scanner.nextLine();
        }
        System.out.println("-----------------------------------------------------");
        System.out.print("Indtast superheltens rigtige navn (fx Peter Parker): ");
        String reelName = scanner.nextLine();

        while (reelName.isEmpty() || reelName.equals(" ")) {
            System.out.print("Indtast venligst et navn:");
            reelName = scanner.nextLine();
        }


        boolean isHuman = false;
        char userInputHumanStatus;

        do {
            System.out.println("-----------------------------------------------------");
            System.out.print("Er din superhelt et menneske (j/n): ");
            userInputHumanStatus = scanner.next().charAt(0);

            if(userInputHumanStatus == 'j') {
                isHuman = true;
            } else if (userInputHumanStatus == 'n'){
                isHuman = false;
            } else {
                System.out.println("Ugyldigt input");
            }
        } while (userInputHumanStatus != 'j' && userInputHumanStatus != 'n' );

        scanner.nextLine();

        System.out.println("-----------------------------------------------------");
        System.out.print("Indtast hvilken superkraft din superhero har (fx stærk): ");
        String superPower = scanner.nextLine();
        while (superPower.isEmpty() || superPower.equals(" ")) {
            System.out.print("Indtast venligst en superkraft:");
            superPower = scanner.nextLine();
        }

        System.out.println("-----------------------------------------------------");
        System.out.print("Indtast det år superhelten blev skabt (fx 1945): ");
        int creationYear = 0;
        do {
            try {
                String creationYearString = scanner.nextLine();
                creationYear = Integer.parseInt(creationYearString);
                userValgFalse = true;
            }
            catch (NumberFormatException e) {
                System.out.println("Indtast venligst et årstal der indeholder tal: ");
            }

        } while (!userValgFalse);

        System.out.println("-----------------------------------------------------");
        System.out.print("Indtast superheltens styrke (med '.' f.eks. 1.5): ");
        double styrke = 0;
        do {
            try {
                String styrkeString = scanner.nextLine();
                styrke = Double.parseDouble(styrkeString);
                userValgFalse = true;

            }
            catch (NumberFormatException e) {
                System.out.println("Indtast venligst et kommatal der indeholder komma '.' f.eks. 1.5");
                userValgFalse = false;
            }
        } while (!userValgFalse);

        controller.createSuperHero(superHeroName, reelName, isHuman, superPower, creationYear, styrke);
    }
    public void showListOfSuperheroes() {
        System.out.println("Liste af superhelte: ");
        for (Superhero controller : controller.getSuperheroes()) {
            System.out.println("------------------\n"
                    + "Superheltenavn: " + controller.getSuperHeroName() + "\n"
                    + "Superkraft: " + controller.getSuperPower() + "\n"
                    + "Virkelige navn: " + controller.getReelName() + "\n"
                    + "Oprindelsesår: " + controller.getCreationYear() + "\n"
                    + "Er menneske: " + controller.isHuman() + "\n"
                    + "Styrke: " + controller.getPowerLevel());
        }

    }
    public void searchSuperhero() {
        System.out.println("-----------------------------------------------------");
        System.out.println("Indtast den superhelt du vil søge efter: ");

        String searchTerm = scanner.nextLine();
        for (Superhero controller1  : controller.findSuperhero(searchTerm)) {
            System.out.println("------------------\n"
                    + "Superheltenavn: " + controller1.getSuperHeroName() + "\n"
                    + "Superkraft: " + controller1.getSuperPower() + "\n"
                    + "Virkelige navn: " + controller1.getReelName() + "\n"
                    + "Oprindelsesår: " + controller1.getCreationYear() + "\n"
                    + "Er menneske: " + controller1.isHuman() + "\n"
                    + "Styrke: " + controller1.getPowerLevel());
        }
        if (controller.findSuperhero(searchTerm).isEmpty()) {
            System.out.println("Ingen resultat");
        }


    }
    public void editSuperhero() {
        System.out.println("-----------------------------------------------------");
        System.out.println("Indtast en superhero du vil redigere: ");
        String userEditSuperhero = scanner.nextLine();
        ArrayList<Superhero> searchEditResult = new ArrayList<>();

        int index = 1;

        for (Superhero editSuperhero : controller.getSuperheroes()) {
            name = editSuperhero.getSuperHeroName().toLowerCase();
            if (name.contains(userEditSuperhero.toLowerCase())) {
                searchEditResult.add(editSuperhero);
                System.out.println(index++ + ":" + editSuperhero.getSuperHeroName());

            }
        }

        System.out.print("Indtast nummeret på den superhero du vil redigere: ");
        String userEditNumberString = scanner.nextLine();
        int userEditNumberInteger = Integer.parseInt(userEditNumberString);


        Superhero editSuperhero = searchEditResult.get(userEditNumberInteger - 1);
        System.out.println("Du har valgt at redigere: " + editSuperhero.getSuperHeroName());

        System.out.println("Ønsker du ikke redigere tryk ENTER for at fortsætte!");


        do {
            System.out.println("superhero.Superhero navn: " + editSuperhero.getSuperHeroName());

            try {
                System.out.print("Skriv din rettelse her: ");
                String newSuperheroName = scanner.nextLine().trim();
                if (!newSuperheroName.isEmpty()) {
                    editSuperhero.setSuperheroName(newSuperheroName);
                }

                userValgFalse = true;
            } catch (NumberFormatException var11) {
                System.out.println("Skriv venligst din rettelse med tekst bogstaver eller ENTER hvis du ikke vil rette!");
            }
        } while (!userValgFalse);

        do {
            System.out.println("superhero.Superhero rigtige navn: " + editSuperhero.getReelName());

            try {
                System.out.print("Skriv din rettelse her: ");
                String newReelName = scanner.nextLine().trim();
                if (!newReelName.isEmpty()) {
                    editSuperhero.setReelName(newReelName);
                }

                userValgFalse = true;
            } catch (NumberFormatException var10) {
                System.out.println("Skriv venligst din rettelse med tekst bogstaver eller ENTER hvis du ikke vil rette!");
            }
        } while (!userValgFalse);

        do {
            System.out.println("Superkraft: " + editSuperhero.getSuperPower());

            try {
                System.out.print("Skriv din rettelse her: ");
                String newSuperPower = scanner.nextLine().trim();//trim cutter mellemrum fra brugerinputet.
                if (!newSuperPower.isEmpty()) {
                    editSuperhero.setSuperPower(newSuperPower);
                }

                userValgFalse = true;
            } catch (NumberFormatException var9) {
                System.out.println("Skriv venligst din rettelse med tekst bogstaver eller ENTER hvis du ikke vil rette!");
            }
        } while (!userValgFalse);

        do {
            System.out.println("Oprindelsesår: " + editSuperhero.getCreationYear());

            try {
                System.out.print("Skriv din rettelse her: ");
                String newCreationYear = scanner.nextLine().trim();
                if (!newCreationYear.isEmpty()) {
                    editSuperhero.setCreationYear(newCreationYear);
                }

                userValgFalse = true;
            } catch (NumberFormatException var8) {
                System.out.println("Skriv venligst din rettelse med tal eller ENTER hvis du ikke vil rette!");
            }
        } while (!userValgFalse);

        do {
            System.out.println("Er menneske: " + editSuperhero.isHuman());

            try {
                System.out.print("Skriv din rettelse her (j/n): ");
                String newIsHuman = scanner.nextLine().trim();
                if (!newIsHuman.isEmpty()) {
                    editSuperhero.setIsHuman(Boolean.parseBoolean(newIsHuman));
                }

                userValgFalse = true;
            } catch (NumberFormatException var7) {
                System.out.println("Skriv venligst din rettelse med (j/n) eller ENTER hvis du ikke vil rette!");
            }
        } while (!userValgFalse);

        do {
            System.out.println("Styrke: " + editSuperhero.getPowerLevel());

            try {
                System.out.print("Skriv din rettelse her: ");
                String newPowerLevel = scanner.nextLine().trim();
                if (!newPowerLevel.isEmpty()) {
                    editSuperhero.setPowerLevel(newPowerLevel);
                }

                userValgFalse = true;
            } catch (NumberFormatException var6) {
                System.out.println("Skriv venligst din rettelse med kommatal (f.eks. 1,5) eller ENTER hvis du ikke vil rette!");
            }
        } while (!userValgFalse);

    }
    public void deleteSuperheroUserInput(){
        System.out.println("-----------------------------------------------------");
        System.out.println("Indtast en superhero du vil slette: ");
        String userDeleteSuperhero = scanner.nextLine();
        ArrayList<Superhero> searchDeleteResult = new ArrayList<>();

        int index = 1;


        for (Superhero deleteSuperhero : controller.getSuperheroes()) {
            name = deleteSuperhero.getSuperHeroName().toLowerCase();
            if (name.contains(userDeleteSuperhero.toLowerCase())) {
                searchDeleteResult.add(deleteSuperhero);
                System.out.println(index++ + ":" + deleteSuperhero.getSuperHeroName());

            }
        }
        System.out.print("Indtast nummeret på den superhero du vil slette: ");
        String userDeleteNumberString = scanner.nextLine();
        int userDeleteNumberInt = Integer.parseInt(userDeleteNumberString);

        Superhero deleteSuperhero = searchDeleteResult.get(userDeleteNumberInt - 1);
        controller.deleteSuperhero(deleteSuperhero);
        System.out.println("Du har nu slettet: " + deleteSuperhero.getSuperHeroName());

    }
}
