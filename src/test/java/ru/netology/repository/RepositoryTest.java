package ru.netology.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.domain.NotFoundException;
import ru.netology.domain.Ticket;

public class RepositoryTest {

    Repository repo = new Repository();
    Ticket ticket1 = new Ticket(1, 2100, "Sheremetevo", "Adler", 2);
    Ticket ticket2 = new Ticket(2, 1900, "Sheremetevo", "Balandino", 3);
    Ticket ticket3 = new Ticket(3, 1700, "Sheremetevo", "Balandino", 3);
    Ticket ticket4 = new Ticket(4, 2300, "Sheremetevo", "Balandino", 3);
    Ticket ticket5 = new Ticket(5, 2500, "Vnukovo", "Pulkovo", 1);
    Ticket ticket6 = new Ticket(6, 1800, "Vnukovo", "Narimanovo", 2);


    @Test
    public void shouldSaveTest() {
        repo.save(ticket1);
        repo.save(ticket2);
        repo.save(ticket3);
        repo.save(ticket4);
        repo.save(ticket5);
        repo.save(ticket6);

        Ticket[] expected = {ticket1, ticket2, ticket3, ticket4, ticket5, ticket6};
        Ticket[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveByIdTest() {
        repo.save(ticket1);
        repo.save(ticket2);
        repo.save(ticket3);
        repo.save(ticket4);
        repo.save(ticket5);
        repo.save(ticket6);
        repo.removeById(2);

        Ticket[] expected = {ticket1, ticket3, ticket4, ticket5, ticket6};
        Ticket[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveByIdTest2() {
        repo.save(ticket1);
        repo.removeById(1);

        Ticket[] expected = {};
        Ticket[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotRemoveByWrongIdTest() {
        repo.save(ticket1);
        repo.save(ticket2);
        repo.save(ticket3);
        repo.save(ticket4);
        repo.save(ticket5);
        repo.save(ticket6);

        Assertions.assertThrows(NotFoundException.class, () -> repo.removeById(7));
    }

}
