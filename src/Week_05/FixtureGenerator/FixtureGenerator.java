package Week_05.FixtureGenerator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FixtureGenerator {
    private List<String> teams;
    private List<String> fixtures;

    public FixtureGenerator(List<String> teams) {
        this.teams = teams;
        this.fixtures = new ArrayList<>();
    }

    public void generateFixtures() {
        if (teams.size() % 2 != 0) {
            teams.add("Bay");
        }

        int totalRounds = teams.size() - 1;
        int matchesPerRound = teams.size() / 2;

        List<String> teamsCopy = new ArrayList<>(teams);
        teamsCopy.remove(0); // Remove the first team (Bay) temporarily

        for (int round = 0; round < totalRounds; round++) {
            List<String> roundFixtures = new ArrayList<>();
            roundFixtures.add(teams.get(0) + " vs " + teamsCopy.get(0));

            for (int match = 1; match < matchesPerRound; match++) {
                int firstTeamIndex = match;
                int secondTeamIndex = (teams.size() - 1) - match;

                roundFixtures.add(teamsCopy.get(firstTeamIndex) + " vs " + teamsCopy.get(secondTeamIndex));
            }

            Collections.rotate(teamsCopy, 1); // Rotate the list for the next round
            fixtures.addAll(roundFixtures);
        }
    }

    public List<String> getFixtures() {
        return fixtures;
    }

    public static void main(String[] args) {
        List<String> teams = new ArrayList<>();
        teams.add("Galatasaray");
        teams.add("Bursaspor");
        teams.add("Fenerbahçe");
        teams.add("Beşiktaş");
        teams.add("Başakşehir");
        teams.add("Trabzonspor");

        FixtureGenerator generator = new FixtureGenerator(teams);
        generator.generateFixtures();

        List<String> fixtures = generator.getFixtures();

        int roundNumber = 1;
        for (String fixture : fixtures) {
            System.out.println("Round " + roundNumber + ": " + fixture);
            roundNumber++;
        }
    }
}