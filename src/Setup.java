import java.io.File;
import java.io.FileNotFoundException;

import java.util.*;

public class Setup {
    private static final String fileURL = "D:\\Study\\projectDayTask\\src\\MovieList.txt";

    public int possibleFilmsToWatch(int timeInTrain){

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

        System.out.println("Sorted list of films: ");
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

        System.out.println("You can watch: ");
        for (Film st : possibleFilmsToWatch)
            System.out.println(st);

        return filmCounter;
    }
}
