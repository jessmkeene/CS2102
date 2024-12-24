
import org.junit.Test;

import java.util.LinkedList;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class Examples {

    PetRescue pr;
    Coord cr;

    LinkedList<Integer> someBirdWeights = new LinkedList<>();
    LinkedList<Integer> DogYears = new LinkedList<>();
    LinkedList<Coord> Cats = new LinkedList<Coord>();
    LinkedList<Coord> NoCats = new LinkedList<Coord>();
    LinkedList<Coord> CatsDistance = new LinkedList<Coord>();

    Coord cr3 = new Coord("Jules", 4,3);

    Coord cr2 = new Coord("Jules", 0,0);

    Coord cr1 = new Coord("Jules", -4,-3);



    public Examples() {
        someBirdWeights.add(10);
        DogYears.add(2);
        DogYears.add(8);
        Cats.add(new Coord("James", 8,7));
        Cats.add(new Coord("Jules", 30,20));
        Cats.add(new Coord("Jess", 2,1));
        CatsDistance.add(cr3);
        CatsDistance.add(cr2);
        CatsDistance.add(cr1);


    }


    @Test
    public void testBiggestBirdsNonEmpty(){
        pr = new PetRescue(someBirdWeights, new LinkedList<Integer>(), "", new LinkedList<Coord>());
        assertEquals("10 should be the biggest bird out of 1 bird", 10, pr.biggestBird()); // label text (optional), expected value, actual/check value
    }


    @Test
    public void testInHumanYearsNonEmpty(){
        pr = new PetRescue(new LinkedList<Integer>(),DogYears, "", new LinkedList<Coord>());
        LinkedList<Integer> expected = new LinkedList<>();
        expected.add(14);
        expected.add(56);
        assertEquals("test dog years to human years",expected, pr.inHumanYears());
    }

    @Test
    public void testbestowHonorsWithOneName(){
        pr = new PetRescue(new LinkedList<Integer>(),new LinkedList<Integer>(), "Dave", new LinkedList<Coord>());
        pr.bestowHonor("Mr.","Phd");
        assertEquals("test that title and credential is given","Mr. Dave, Phd", pr.petOfTheMonth);
    }

    @Test
    public void testbestowHonorsWithNoName(){
        pr = new PetRescue(new LinkedList<Integer>(),new LinkedList<Integer>(), "Dave", new LinkedList<Coord>());

        pr.bestowHonor("","");
        assertEquals("test that just name is given when title and credential is nothing","Dave", pr.petOfTheMonth);
    }

    @Test
    public void testbestowHonorsforTwoNames(){
        pr = new PetRescue(new LinkedList<Integer>(),new LinkedList<Integer>(), "Dave", new LinkedList<Coord>());
        pr.bestowHonor("Mr.","Phd");
        pr.bestowHonor("Ms.","MD");
        assertEquals("test that title and credential is given when called twice","Ms. Mr. Dave, Phd MD", pr.petOfTheMonth);
    }

    @Test
    public void testFeedChinchillasIfNotEmptyPantry(){
        pr = new PetRescue(new LinkedList<Integer>(),new LinkedList<Integer>(), "", new LinkedList<Coord>());
        assertEquals("tests food in pantry after feeding chinchillas when food amount is positive","Chinchilla: 14 pellets, 56 hay", pr.feedChinchillas(14,56));
    }

    @Test
    public void testFeedChinchillasIfNegativeFood(){
        pr = new PetRescue(new LinkedList<Integer>(),new LinkedList<Integer>(), "", new LinkedList<Coord>());
        LinkedList<Integer> FoodInPantryAfter= new LinkedList<>();
        assertEquals("tests food in pantry after feeding chinchillas when food amount is positive","Chinchilla: unknown pellets, unknown hay", pr.feedChinchillas(-6,-7));
    }

    @Test
    public void testFeedChinchillasIfEmptyPantry(){
        pr = new PetRescue(new LinkedList<Integer>(),new LinkedList<Integer>(), "", new LinkedList<Coord>());
        LinkedList<Integer> FoodInPantryAfter= new LinkedList<>();
        assertEquals("tests food when food after is zero","Chinchilla: 0 pellets, 0 hay", pr.feedChinchillas(0,0));
    }

    @Test
    public void testClosestToNoneEmpty(){
        pr = new PetRescue(new LinkedList<Integer>(),new LinkedList<Integer>(), "", Cats);
        LinkedList<Integer> FoodInPantryAfter= new LinkedList<>();
        assertEquals("tests shows cat that is nearest to coordinate","Jess", pr.closestTo(0,0));
    }

    @Test
    public void testClosestToEmpty(){
        pr = new PetRescue(new LinkedList<Integer>(),new LinkedList<Integer>(), "", NoCats);
        LinkedList<Integer> FoodInPantryAfter= new LinkedList<>();
        assertEquals("tests there are no cats","Conspiciously Catless", pr.closestTo(0,0));
    }

    @Test
    public void testFindDistanceWhenNegative(){
        pr = new PetRescue(new LinkedList<Integer>(),new LinkedList<Integer>(), "", CatsDistance);
        assertEquals("tests the distance when cat coordinates are negative",5.0, pr.FindDistance(cr1,0,0),.0001);
    }

    @Test
    public void testFindDistanceWhenZero(){
        pr = new PetRescue(new LinkedList<Integer>(),new LinkedList<Integer>(), "", CatsDistance);
        assertEquals("tests that there is no distance between coodinates",0.0, pr.FindDistance(cr2,0,0),.0001);
    }

    @Test
    public void testFindDistanceWhenPositive(){
        pr = new PetRescue(new LinkedList<Integer>(),new LinkedList<Integer>(), "", CatsDistance);
        assertEquals("tests the distance when cat coordinates are positive",5.0, pr.FindDistance(cr3, 0,0),.0001);
    }


}



