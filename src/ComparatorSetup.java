import java.util.Comparator;

public class ComparatorSetup implements Comparator<Film>
{
    public int compare(Film a, Film b)
    {
        return a.getFilm_size() - b.getFilm_size();
    }
}