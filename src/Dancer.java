import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

class Dancer {
    private Random rnd = new Random();


    private final String SEX;
    private final int NAME;
    private final String STYLES[];

    Dancer(int id) {
        NAME = id;
        SEX = sex();
        STYLES = dancerSkills();

        if (STYLES.length > 0) {
            System.out.println("Dancer №" + id + ": " + SEX + ". Coming in the club to dance:");
            System.out.println(Arrays.toString(STYLES));
            System.out.println();
        } else {
            System.out.println("Dancer №" + id + ": " + SEX + ". Coming in the club to drink all night.");
            System.out.println();
        }
    }

    public int getNAME() {
        return NAME;
    }

    public String getSEX() {
        return SEX;
    }

    public String[] getSTYLES() {
        return STYLES;
    }

    public boolean drinkOrDance(String music) {
        boolean dance = false;
        switch (music) {
            case "RnB":
                return dance(new String[]{"RnBDance", "Hip-Hop Dance"});
            case "Electrohuse":
                return dance(new String[]{"Electrodance"});
            case "Hip-Hop":
                return dance(new String[]{"Hip-Hop Dance"});
            case "Pop":
                return dance(new String[]{"Pop dance"});
        }

        return dance;
    }

    private boolean dance(String[] skills) {
        boolean dance = false;
        for (String s : STYLES) {
            for (String skill : skills) {
                if (s.equals(skill)) {
                    dance = true;
                }
            }

        }

        return dance;
    }

    private String sex() {
        String[] sex = {"Male", "Female"};
        return sex[rnd.nextInt(sex.length)];
    }

    private String[] dancerSkills() {
        String[] styleSkills = {"RnBDance", "Electrodance", "Hip-Hop Dance", "Pop dance"};
        ArrayList<String> skills = new ArrayList<>();
        String[] dancerSkills = new String[rnd.nextInt(styleSkills.length)];
        skills.addAll(Arrays.asList(styleSkills));

        for (int i = 0; i < dancerSkills.length; i++) {
            dancerSkills[i] = skills.remove(rnd.nextInt(skills.size()));
        }
        return dancerSkills;
    }
}
