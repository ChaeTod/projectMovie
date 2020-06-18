import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Setup setup = new Setup();

        System.out.println(setup.possibleFilmsToWatch(280));

        List<String> result = new ArrayList<>();

        //System.out.println(setup.generatePermutations(setup.possibleFilmsToWatch(340), result, 0, ""));

        //System.out.println(setup.getAllCombinations(setup.possibleFilmsToWatch(340)));
    }
}
