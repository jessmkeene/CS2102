import java.util.LinkedList;

public class PetRescue implements PetRescueable{

    public String petOfTheMonth;
    public LinkedList<Integer> birdWeights;
    public LinkedList<Integer> dogYears;
    public LinkedList<Coord> catCoords;
    public int pellets = 0;
    public int hay = 0;
    public String title;
    public String credential;


    public PetRescue(LinkedList<Integer> birdWeights,
                     LinkedList<Integer> dogYears,
                     String petOfTheMonth,
                     LinkedList<Coord> catCoords) {
    this.birdWeights = birdWeights;
    this.dogYears  = dogYears;
    this.petOfTheMonth = petOfTheMonth;
    this.catCoords = catCoords;
    }

    /**
     * Searches the birds in the pet rescue
     * @return the size of the biggest bird in oz or 0 if there are no birds
     */
    @Override
    public int biggestBird() {
        if (birdWeights.isEmpty()) {
            return 0;
        }
        else {
            int maxValue;
            maxValue = 0;
            for (int someBirdWeights: birdWeights) {
                if(someBirdWeights > maxValue) {
                    maxValue = someBirdWeights;
                }

            }
            return maxValue;
        }
    }
    /**
     * Transforms the dog records in the pet rescue
     * @return a list of ages in the same order as the dog records,
     *         but each age is converted into human years by multiplying by 7
     */
    public LinkedList<Integer> inHumanYears(){
        LinkedList<Integer> result;
        result = new LinkedList<Integer>();
        int a;
        for(int dogYear: dogYears) {
            result.add(dogYear * 7);
        }
        return result;
    }
    /**
     * Awards the pet of the month with a title and/or a credential for their accomplishments
     * @param title Can be a title like "Dr." or "Capt."
     *              or the empty string "" if no title to be added
     * @param credential a degree or honor including but not limited to "MD", "PhD", or "Esq."
     *                   or the empty string "" if no credential to be added
     * effects: modifies the name on record of the form "TITLE name, CREDENTIAL"
     * multiple space separated titles can be added with the newest first
     * multiple space separated credentials can be added after the comma with the newest last.
     */
    @Override
    public void bestowHonor(String title, String credential) {
        if (petOfTheMonth.contains(" ")) {
            if (credential.isBlank() && !title.isBlank()) {
                petOfTheMonth = title.concat(" " + petOfTheMonth);
            } else if (title.isBlank() && !credential.isBlank()) {
                petOfTheMonth = petOfTheMonth.concat(" " + credential);
            } else if (title.isBlank()) {
            } else {
                String string1 = title.concat(" " + petOfTheMonth);
                petOfTheMonth = string1.concat(" " + credential);
            }
        } else {
            if (credential.isBlank() && !title.isBlank()) {
                petOfTheMonth = title.concat(" " + petOfTheMonth);
            } else if (title.isBlank() && !credential.isBlank()) {
                petOfTheMonth = petOfTheMonth.concat(", " + credential);
            } else if (title.isBlank()) {
            } else {
                String string1 = title.concat(" " + petOfTheMonth);
                petOfTheMonth = string1.concat(", " + credential);
            }
        }
    }
    /**
     * Adds positive or subtracts negative food from the pantry and then prints out a new label for the contents inside
     * assume the initial amount of pellets and hay should be 0
     * @param pellets the amount of pellets to add/subtract
     * @param hay the amount of hay to add/subtract
     * @return a string in the format "Chinchilla: # pellets, # hay"
     * If the storage of pellets or hay goes negative, reset them to 0, and replace # with "unknown"
     */
    @Override
    public String feedChinchillas(int pellets, int hay) {
        this.pellets = this.pellets + pellets;
        this.hay = this.hay + hay;

        String amtOfHay = this.hay + "";
        String amtOfPellets = this.pellets + "";

        if(this.hay < 0){
            this.hay = 0;
            amtOfHay = "unknown";
        }
        if(this.pellets < 0){
            this.pellets = 0;
            amtOfPellets = "unknown";
        }

        return "Chinchilla: " + amtOfPellets + " pellets, " + amtOfHay + " hay";
    }
    /**
     * Finds the closest cat in the rescue to some coordinate
     *
     * @param x the coordinate to find the closest to
     * @param y
     * @return the name of the cat if found or "Conspiciously Catless" if there are no cats.
     */
    public String closestTo(int x, int y) {
        Coord targetCoord = new Coord("Conspiciously Catless", -100,-100);

        for(Coord currentCoord : this.catCoords){
            double closestDistance = coordsDistance(targetCoord, new Coord("", x,y));
            double currentDistance = coordsDistance(currentCoord, new Coord("", x,y));

            if(closestDistance > currentDistance){
                targetCoord = currentCoord;
            }
        }
        return targetCoord.name;
    }

    /**
     * finds the distance inbetween the coordinates
     *
     * @param from origin point
     * @param to goal point
     * @return pythagorean theorem a^2 + b^2 = c^2
     */
    public double coordsDistance(Coord from, Coord to) {
        return Math.sqrt((from.y - to.y) * (from.y - to.y) + (from.x - to.x) * (from.x - to.x));
    }


}
