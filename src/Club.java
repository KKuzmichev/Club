import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.TimeUnit;

class Club {

    private Music music = new Music();
    private Random rnd = new Random();
    private int visitorsCount = rnd.nextInt(100);
    private int clubWorkTime = rnd.nextInt(20);

    void letsDance() throws InterruptedException {
        ArrayList<Dancer> dancers = createDancers(visitorsCount);

        for (int i = 0; i < clubWorkTime; i++) {
            if (clubWorkTime == 0) {
                System.out.println("Club is closed!!!");
            }
            String clubMusic = music.playMusic();

            System.out.println("Club work: " + clubWorkTime + " songs." + '\n');
            System.out.println("Now in club: " + clubMusic + "!!!" + '\n');

            for (Dancer dancer : dancers) {
                if (dancer.drinkOrDance(clubMusic)) {
                    System.out.println(
                            Arrays.toString(dancer.getSTYLES())
                                    + "\nDancer №" + dancer.getNAME()
                                    + " " + dancer.getSEX() + ": Dance!"
                                    + '\n');
                } else if (!dancer.drinkOrDance(clubMusic)) {
                    System.out.println(
                            Arrays.toString(dancer.getSTYLES())
                                    + "\nDancer " + dancer.getNAME()
                                    + " " + dancer.getSEX() + ": Drink vodka in the bar!"
                                    + '\n');
                }
            }
            int musicPlayTime = 5;
            TimeUnit.SECONDS.sleep(musicPlayTime);

        }
    }

    private ArrayList<Dancer> createDancers(int dancersCount) {
        ArrayList<Dancer> dancers = new ArrayList<>();
        for (int i = 0; i < dancersCount; i++) {
            dancers.add(new Dancer(i));
        }
        return dancers;
    }
}
