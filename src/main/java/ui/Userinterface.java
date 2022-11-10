package ui;

import controller.Controller;
import superhero.Superhero;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Userinterface {
    Scanner scanner = new Scanner(System.in);
    Controller controller = new Controller();
    private String name;
    private boolean userValgFalse = false;
    private String primaryAttribut = "";
    private String secondaryAttribute = "";

    public void menu() throws IOException {
        int menuValg = 0;

        while (menuValg != 9) {
            System.out.println("""
            -------------------------
            Database med superheroes! (Husk at loade programmet første gang du åbner det)
            -------------------------
            1. Opret superhero
            2. Se liste af superheroes
            3. Søg efter superheroes
            4. Redigere superhero
            5. Slet superhero
            6. Gem liste af superheroes
            7. Load liste af superheroes
            8. Sortering af superhero data
            9. Afslut
            """);

            do {
                String valg = scanner.nextLine().trim();
                try {
                    menuValg = Integer.parseInt(valg);
                    userValgFalse = true;
                } catch (NumberFormatException e) {
                    System.out.print("Der skete en fejl! - Indtast venligst et gyldigt nummer: ");
                    scanner.nextLine();
                }

            } while (!userValgFalse);

            startprogram(menuValg);
        }

    }
    public void startprogram(int menuValg) throws IOException {
        switch (menuValg) {
            case 1 -> createSuperhero();
            case 2 -> printList();
            case 3 -> searchSuperhero();
            case 4 -> editSuperhero();
            case 5 -> deleteSuperheroUserInput();
            case 6 -> saveData();
            case 7 -> loadData();
            case 8 -> sortingMenu();
            case 9 -> exitProgram();
            default -> System.out.println("Ugyldigt Input\n");
        }
    }
    public void sortingMenu() throws IOException {
        int userSorteringsValg = 0;
        System.out.println("""
                -----------------------
                Vælg sorterings metode:
                -----------------------
                1. Sorter efter superhero navn
                2. Sorter efter superkræfter
                3. Sorter efter rigtige navn
                4. Sorter efter oprindelses år
                5. Sorter efter menneske
                6. Sorter efter styrke
                7. Sorter efter udvalgte primær og sekundær attributter
                9. Gå tilbage til menu
                """);
        do {
            String sorteringsvalg = scanner.nextLine().trim();
            try {
                userSorteringsValg = Integer.parseInt(sorteringsvalg);
                userValgFalse = true;
            } catch (NumberFormatException e) {
                System.out.print("Der skete en fejl! - Indtast venligst et gyldigt nummer: ");
                scanner.nextLine();
            }

        } while (!userValgFalse);
        vælgSortingMetode(userSorteringsValg);
    }
    public void sortWithToAttributes() throws IOException {
        int userInputPrimaryAttributes = 0;
        int userInputSecondaryAttributes = 0;


        System.out.println("""
                -----------------------
                Vælg den primære attribut
               
                1. Superhero navn
                2. Superkræfter
                3. Rigtige navn
                4. Oprindelses år
                5. Menneske eller ej
                6. Styrke
                7. Gå tilbage til sorteringsmenu
                9. Gå tilbage til hovedmenu
                """);

        do {
            String primaryAttributes = scanner.nextLine().trim();
            try {
                userInputPrimaryAttributes = Integer.parseInt(primaryAttributes);
                userValgFalse = true;
            } catch (NumberFormatException e) {
                System.out.print("Der skete en fejl! - Indtast venligst et gyldigt nummer: ");
                scanner.nextLine();
            }

        } while (!userValgFalse);

        do {
            switch (userInputPrimaryAttributes) {
                case 1 -> primaryAttribut = "superHeroName";
                case 2 -> primaryAttribut = "reelName";
                case 3 -> primaryAttribut = "isHuman";
                case 4 -> primaryAttribut = "superPower";
                case 5 -> primaryAttribut = "creationYear";
                case 6 -> primaryAttribut = "powerLevel";
                case 7 -> vælgSortingMetode(userInputPrimaryAttributes);
                case 8 -> menu();
            }

            System.out.println("""
                    -----------------------
                    Vælg den sekundære attribut (du kan ikke vælge den samme som primære)
                                       
                    1. Superhero navn
                    2. Superkræfter
                    3. Rigtige navn
                    4. Oprindelses år
                    5. Menneske eller ej
                    6. Styrke
                    7. Gå tilbage til sorteringsmenu
                    9. Gå tilbage til hovedmenu
                    """);

            do {
                String secondaryAttribut = scanner.nextLine().trim();
                try {
                    userInputSecondaryAttributes = Integer.parseInt(secondaryAttribut);
                    userValgFalse = true;
                } catch (NumberFormatException e) {
                    System.out.print("Der skete en fejl! - Indtast venligst et gyldigt nummer: ");
                    scanner.nextLine();
                }

            } while (!userValgFalse);


            if (userInputPrimaryAttributes != userInputSecondaryAttributes) {
                switch (userInputSecondaryAttributes) {
                    case 1 -> secondaryAttribute = "superHeroName";
                    case 2 -> secondaryAttribute = "reelName";
                    case 3 -> secondaryAttribute = "isHuman";
                    case 4 -> secondaryAttribute = "superPower";
                    case 5 -> secondaryAttribute = "creationYear";
                    case 6 -> secondaryAttribute = "powerLevel";
                    case 7 -> vælgSortingMetode(userInputPrimaryAttributes);
                    case 8 -> menu();
                }

                getPrimaryAndSecondary();

            } else {
                System.out.println("Den sekundære attribut skal være forskellig fra din primære");
                userValgFalse = false;
            }

        } while (!userValgFalse);
    }
    public void getPrimaryAndSecondary(){
        try {
            controller.getSortPrimaryAndSecondary(primaryAttribut, secondaryAttribute);
            printList();
        } catch (IOException e) {
            System.out.println("Kan ikke sortere efter primære og sekundære");
        }
    }
    public void exitProgram()  {
        try {
            System.out.print("Programmet afsluttes");
            TimeUnit.SECONDS.sleep(1);
            System.out.print(".");
            TimeUnit.SECONDS.sleep(1);
            System.out.print(".");
            TimeUnit.SECONDS.sleep(1);
            System.out.print(".");
            System.exit(1);

        } catch (InterruptedException e) {
            System.out.println("Systemet kan ikke afslutte");
        }


    }
    public void printList() throws IOException {
        for (Superhero controller : controller.getSuperheroes()) {
            String yesOrNo;
            if (controller.isHuman()){
                yesOrNo = "Ja";
            } else {
                yesOrNo = "Nej";
            }
            System.out.println("------------------\n"
                    + "Superheltenavn:... " + controller.getSuperHeroName() + "\n"
                    + "Superkraft:....... " + controller.getSuperPower() + "\n"
                    + "Virkelige navn:... " + controller.getReelName() + "\n"
                    + "Oprindelsesår:.... " + controller.getCreationYear() + "\n"
                    + "Er menneske:...... " + yesOrNo + "\n"
                    + "Styrke:........... " + controller.getPowerLevel());
        }
    }
    public void vælgSortingMetode(int userSorteringValg) throws IOException {

        switch (userSorteringValg) {
            case 1 -> getSortNameMethod();
            case 2 -> getSortSuperPower();
            case 3 -> getSuperHerorealName();
            case 4 -> getSortCreationYear();
            case 5 -> getSortIsHuman();
            case 6 -> getSortPower();
            case 7 -> sortWithToAttributes();
            case 9 -> menu();
            default -> System.out.println("Ugyldigt Input\n");
        }

    }
    public void getSortNameMethod() {
        try {
            controller.getSortNameMethod();
            printList();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void getSuperHerorealName() {
        try {
            controller.getSuperHerorealName();
            printList();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void getSortSuperPower() {
        try {
            controller.getSortSuperPower();
            printList();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void getSortCreationYear(){
        try {
            controller.getSortCreationYear();
            printList();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void getSortIsHuman(){
        try {
            controller.getSortIsHuman();
            printList();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void getSortPower() {
        try {
            controller.getSortPower();
            printList();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void saveData() {
        if(controller.isChange()) {
            controller.saveData();
            System.out.println("Data has been saved to the system!");
        } else {
            System.out.println("Data not saved. No change has been made!");
        }
    }
    public void loadData() {
        controller.loadData();
        System.out.println("Data has been loaded to the system!");
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
        char humanStatus;
        do {
            System.out.println("-----------------------------------------------------");
            System.out.print("Er din superhelt et menneske (j/n): ");
            humanStatus = scanner.next().charAt(0);
            if (humanStatus == 'j') {
                isHuman = true;
            } else if (humanStatus == 'n') {
                isHuman = false;
            } else {
                System.out.println("ugyldigt input");
            }
        } while (humanStatus != 'j' && humanStatus != 'n');


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

        } while (!userValgFalse );

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
    public void searchSuperhero() {
        System.out.println("-----------------------------------------------------");
        System.out.println("Indtast den superhelt du vil søge efter: ");

            String searchTerm = scanner.nextLine();
        for (Superhero controller : controller.getSuperheroes()) {
            String yesOrNo = null;
            if (controller.isHuman()){
                yesOrNo = "Ja";
            } else {
                yesOrNo = "Nej";
            }

            System.out.println("------------------\n"
                    + "Superheltenavn: " + controller.getSuperHeroName() + "\n"
                    + "Superkraft: " + controller.getSuperPower() + "\n"
                    + "Virkelige navn: " + controller.getReelName() + "\n"
                    + "Oprindelsesår: " + controller.getCreationYear() + "\n"
                    + "Er menneske: " + yesOrNo + "\n"
                    + "Styrke: " + controller.getPowerLevel());
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
            System.out.println("Classes.Superhero navn: " + editSuperhero.getSuperHeroName());

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
            System.out.println("Classes.Superhero rigtige navn: " + editSuperhero.getReelName());

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

        controller.setChange(true); // set change to true if the editMethod is running and a change has been made.

    }
    public void deleteSuperheroUserInput(){
        System.out.println("-----------------------------------------------------");
        System.out.println("Indtast en superhero du vil slette: ");
        String userDeleteSuperhero = scanner.nextLine().toLowerCase();
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