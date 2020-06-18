import java.io.File;
import java.io.FileNotFoundException;

import java.util.*;

public class Setup {
    private static final String fileURL = "D:\\Study\\projectDayTask\\src\\MovieList.txt";

    public String possibleFilmsToWatch(int timeInTrain) {

        ArrayList<Film> filmList = new ArrayList<>();

        String[] filmInfo = null;
        try {
            File myObj = new File(fileURL);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String[] filmSplit = myReader.nextLine().split(" ");
                for (String st : filmSplit) {
                    filmInfo = st.split(":");
                    if (filmInfo[0] != null)
                        filmList.add(new Film(Integer.parseInt(filmInfo[1]), filmInfo[0]));
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Movie list was not found!");
            e.printStackTrace();
        }

        System.out.println("List of films: ");
        for (Film film : filmList)
            System.out.println(film);

        //filmList.sort(new ComparatorSetup());
        Collections.sort(filmList, new ComparatorSetup());

        System.out.println("\n Sorted list of films: ");
        for (Film st : filmList)
            System.out.println(st);

        /*Scanner in = new Scanner(System.in);
        System.out.println("Input the time in the train: ");
        int timeInTrain = in.nextInt();*/

        Set<Film> possibleFilmsToWatch = new HashSet<>();
        int filmCounter = 0;

        for (Film st : filmList) {
            if (st.getFilm_size() < timeInTrain) {
                timeInTrain -= st.getFilm_size();
                possibleFilmsToWatch.add(st);
                filmCounter++;
            }
        }

        /*int counter = 0;
        int MIN_VAL = 3;

        for (int i = 1; i < )


        while (filmList.get(counter).getFilm_size() < timeInTrain || counter != filmList.size() && counter > MIN_VAL) {
            Set<String> allFilms = new HashSet<>();
            timeInTrain -= filmList.get(counter).getFilm_size();
            allFilms.add(filmList.get(counter).getFilm_name());
            possibleFilmsToWatch.addAll(allFilms);
            counter++;
        }*/

        /*System.out.println("\n You can watch: ");
        for (String st : possibleFilmsToWatch)
            System.out.println(st);*/

        /*String sArray[] = new String []{"A", "A", "B", "C"};
        //convert array to list
        List<String> list1 = Arrays.asList(sArray);
        List<String> list2 = Arrays.asList(sArray);
        List<String> list3 = Arrays.asList(sArray);

        LinkedList<List <String>> lists = new LinkedList<List <String>>();

        lists.add(list1);
        lists.add(list2);
        lists.add(list3);

        Set<String> combinations = new TreeSet<String>();
        Set<String> newCombinations;

        for (String s: lists.removeFirst())
            combinations.add(s);

        while (!lists.isEmpty()) {
            List<String> next = lists.removeFirst();
            newCombinations =  new TreeSet<String>();
            for (String s1: combinations)
                for (String s2 : next)
                    newCombinations.add(s1 + s2);

            combinations = newCombinations;
        }
        for (String s: combinations)
            System.out.print(s+" ");*/

        return possibleFilmsToWatch.toString();
    }

    /*public List<List<String>> getAllCombinations(List<String> elements) {
        List<List<String>> combinationList = new ArrayList<List<String>>();
        for (long i = 1; i < Math.pow(2, elements.size()); i++) {
            List<String> list = new ArrayList<String>();
            for (int j = 0; j < elements.size(); j++) {
                if ((i & (long) Math.pow(2, j)) > 0) {
                    list.add(elements.get(j));
                }
            }
            combinationList.add(list);
        }
        return combinationList;
    }*/

   /*public void generatePermutations(List<List<Character>> lists, List<String> result, int depth, String current) {
        if (depth == lists.size()) {
            result.add(current);
            return;
        }

        for (int i = 0; i < lists.get(depth).size(); i++) {
            generatePermutations(lists, result, depth + 1, current + lists.get(depth).get(i));
        }
    }*/
}
