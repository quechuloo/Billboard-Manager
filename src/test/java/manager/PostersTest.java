package manager;

import domain.Movies;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PostersTest {
    Posters manager = new Posters();
    private Movies first = new Movies(1, "The Shawshank Redemption", "drama");
    private Movies second = new Movies(2, "Venom", "thriller");
    private Movies third = new Movies(3, "Godzilla", "fantastic");
    private Movies fourth = new Movies(4, "Charlie and the Chocolate Factory", "family");
    private Movies fifth = new Movies(5, "Attack on Titan", "anime");
    private Movies sixth = new Movies(6, "Bleach", "anime");
    private Movies seventh = new Movies(7, "The Fast and the Furious", "thriller");
    private Movies eighth = new Movies(8, "Blade", "horrors");
    private Movies ninth = new Movies(9, "Guyver", "fantastic");
    private Movies tenth = new Movies(10, "Guyver: Dark Hero", "fantastic");

    @Test
    public void shouldGetUnderLimit() {
        manager.add(first);
        manager.add(second);
        manager.add(third);

        Movies[] actual = manager.getAll();
        Movies[] expected = new Movies[]{third, second, first};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldGetOverLimit() {
        Posters manager = new Posters();
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eighth);
        manager.add(ninth);
        manager.add(tenth);

        Movies[] actual = manager.getAll();
        Movies[] expected = new Movies[]{tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second, first};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldGetEmpty() {
        Movies[] actual = manager.getAll();
        Movies[] expeсted = new Movies[0];
        assertArrayEquals(expeсted, actual);
    }

    @Test
    public void shouldNumberOfFilmsEqualToTheLimit() {
        Posters manager = new Posters(10);
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eighth);
        manager.add(ninth);
        manager.add(tenth);

        Movies[] actual = manager.getAll();
        Movies[] expeсted = new Movies[]{tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second, first};
        assertArrayEquals(expeсted, actual);

    }

    @Test
    public void shouldNumberOfFilmsAboveTheLimit() {
        Posters manager = new Posters(11);
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eighth);
        manager.add(ninth);
        manager.add(tenth);

        Movies[] actual = manager.getAll();
        Movies[] expeсted = new Movies[]{tenth,ninth, eighth, seventh, sixth, fifth, fourth, third, second, first};
        assertArrayEquals(expeсted, actual);

    }

    @Test
    public void shouldNumberOfFilmsBelowTheLimit() {
        Posters manager = new Posters(9);
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eighth);
        manager.add(ninth);
        manager.add(tenth);

        Movies[] actual = manager.getAll();
        Movies[] expeсted = new Movies[]{tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second};
        assertArrayEquals(expeсted, actual);
    }
}