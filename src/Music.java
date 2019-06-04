import java.util.Random;

class Music {
    private static final String[] styles = {"RnB", "Electrohuse", "Pop"};
    private Random rnd = new Random();

    String playMusic() {
        return styles[rnd.nextInt(styles.length)];
    }

}
