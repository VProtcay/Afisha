package ru.netology.manager;

import ru.netology.domain.Movie;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ManagerAfishaTest {

    ManagerAfisha manager = new ManagerAfisha();
    ManagerAfisha manager1 = new ManagerAfisha(5);

    Movie first = new Movie(1, "Бладшот", "боевик");
    Movie second = new Movie(2, "Вперёд", "мультфильм");
    Movie third = new Movie(3, "Отель Белград", "комедия");
    Movie fourth = new Movie(4, "Джентельмены", "боевик");
    Movie fifth = new Movie(5, "Человек-невидимка", "ужасы");
    Movie sixth = new Movie(6, "Тролли. Мировой тур", "мультфильм");
    Movie seventh = new Movie(7, "Номер один", "комедия");
    Movie eighth = new Movie(8, "Мой волк", "приключение");
    Movie ninth = new Movie(9, "Последний богатырь: Посланник Тьмы", "приключение");
    Movie tenth = new Movie(10, "Чемпион мира", "драма");
    Movie eleventh = new Movie(11, "Код 355", "боевик");

    @Test
    public void shouldGetLastsIfEqualsLimit() {
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

        Movie[] actual = manager.getLasts();
        Movie[] expected = new Movie[]{tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second, first};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldGetLastsIfUnderLimit() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);

        Movie[] actual = manager.getLasts();
        Movie[] expected = new Movie[]{seventh, sixth, fifth, fourth, third, second, first};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldGetLastsIfOverLimit() {

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
        manager.add(eleventh);

        Movie[] actual = manager.getLasts();
        Movie[] expected = new Movie[]{eleventh, tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldGetLastsIfEqualsNewLimit() {

        manager1.add(first);
        manager1.add(second);
        manager1.add(third);
        manager1.add(fourth);
        manager1.add(fifth);

        Movie[] actual = manager1.getLasts();
        Movie[] expected = new Movie[]{fifth, fourth, third, second, first};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldGetLastsIfUnderNewLimit() {

        manager1.add(first);
        manager1.add(second);
        manager1.add(third);

        Movie[] actual = manager1.getLasts();
        Movie[] expected = new Movie[]{third, second, first};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldGetLastsIfOverNewLimit() {

        manager1.add(first);
        manager1.add(second);
        manager1.add(third);
        manager1.add(fourth);
        manager1.add(fifth);
        manager1.add(sixth);
        manager1.add(seventh);

        Movie[] actual = manager1.getLasts();
        Movie[] expected = new Movie[]{seventh, sixth, fifth, fourth, third};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotGetLastsIfEmpty() {
        Movie[] actual = manager.getLasts();
        Movie[] expected = new Movie[]{};
        assertArrayEquals(expected, actual);
    }
}