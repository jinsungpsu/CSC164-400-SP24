import java.util.Random;

public class Main {
    public static void main(String[] args) {
        // SIMULATE THE RANDOM SCORES FOR THE SEASON
        final int NUM_GAMES = 82;
        final int NUM_PERIODS = 4;

        Team union = new Team();
        union.city = "Chester";
        // union.name = "Union";
        union.setName("Union");

        Team sixers = new Team(NUM_GAMES, NUM_PERIODS);
        sixers.city = "Philadelphia";
        //sixers.name = "76ers";
        sixers.setName("76ers");

        union.simulateSeason(0, 5);
        sixers.simulateSeason(10, 45);

        // DISPLAY THE SEASON SCORES
        union.showSeasonScores();
        sixers.showSeasonScores();

        // MENU

        // DO STUFF

        // can't do this... b/c name is private
        System.out.println(sixers.getName());
    }

    //procedural way of thinking about the solution
    static double avgPointsPerSeason(int[][] scores) {
        return 0;
    }

    static void showMatchInfo(int match, int[][] scores) {

    }
}

class Team {
    // what it is, what it does...

    private String name;
    String city;

    int wins, losses;

    int[][] scores;


    // now that name is private
    // how do "outsiders" interact with the name instance variable?
    // through setter and getter
    // approved "tunnel" to our private stuff

    // instead of the Main method doing
    // union.name = "Union"
    // now they have to do
    // union.setName("Union");

    // why, then, do setters exist?
    // 1) protect data
    // 2) easier to maintain code

    // always named set followed by the var identifier
    // return type is void
    // parameter is same type for whatever it is we're
    // trying to change.. in this case a String for name
    public void setName(String teamName) {
        // this is a method...
        // i can do whatever i want here
        if (name.length() > 200) {
            // name's too long!
            System.out.println("Name is not changed!");
        } else {
            name = teamName;
            System.out.println("New team name changed to: " + name);
        }
    }

    // if the outside world NEEDS something private from inside here
    // we need getter

    // return type... matches the data requested...
    // in the case of "name" - the return type is String
    // bc the outside world wants the String/name
    // the name of the method
    // will always be get followed by the var identifier
    // no parameters
    public String getName() {
        return name;
    }
    Team() {
        // initializes object...
        scores = new int[10][2];
    }

    Team(int matches, int periods) {
        scores = new int[matches][periods];
    }

    double avgPointsInSeason() {

        return 0;
    }

    void simulateSeason(int min, int max) {
        Random rng = new Random();

        for (int i = 0; i < scores.length; i++) {
            for (int j = 0; j < scores[i].length; j++) {
                scores[i][j] = rng.nextInt(min, max);
            }
        }
    }

    void displayMatchInfo(int match) {

    }

    void showSeasonScores() {
        System.out.println("\n\n" + city + " " + name + " season scores:");
        for (int i = 0; i < scores.length; i++) {
            System.out.println("\nMatch #: " + (i+1));
            for (int j = 0; j < scores[i].length; j++) {
                System.out.print(scores[i][j] + " ");
            }
        }
    }
}
