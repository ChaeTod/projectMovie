public class Film {
    private int film_size;
    private String film_name;

    public Film(int film_size, String film_name) {
        this.film_size = film_size;
        this.film_name = film_name;
    }

    public int getFilm_size() {
        return film_size;
    }

    public void setFilm_size(int film_size) {
        this.film_size = film_size;
    }

    public String getFilm_name() {
        return film_name;
    }

    public void setFilm_name(String film_name) {
        this.film_name = film_name;
    }

    @Override
    public String toString() {
        return this.film_name + " is going for " + this.film_size;
    }
}
