package comparatorer;

public class SuperheroNameComparator implements Comparable<SuperheroNameComparator> {
    private String superHeroName;
    private String reelName;
    private boolean isHuman;
    private String superPower;
    private int creationYear;
    private double powerLevel;

    public void Superhero(String superHeroName, String reelName, boolean isHuman, String superPower, int creationYear, double powerLevel) {
        this.superHeroName = superHeroName;
        this.reelName = reelName;
        this.isHuman = isHuman;
        this.superPower = superPower;
        this.creationYear = creationYear;
        this.powerLevel = powerLevel;
    }

    @Override
    public int compareTo(SuperheroNameComparator o) {
        return 0;
    }
    public String getSuperHeroName(){
        return superHeroName;
    }

}
