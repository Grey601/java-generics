package ru.netology.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.repository.Repository;

public class TicketManagerTest {

    Repository repo = new Repository();
    TicketManager manager = new TicketManager(repo);

    Ticket ticket1 = new Ticket(1, 2100, "Sheremetevo", "Adler", 2);
    Ticket ticket2 = new Ticket(2, 1900, "Sheremetevo", "Balandino", 3);
    Ticket ticket3 = new Ticket(3, 1700, "Sheremetevo", "Balandino", 3);
    Ticket ticket4 = new Ticket(4, 2300, "Sheremetevo", "Balandino", 3);
    Ticket ticket5 = new Ticket(5, 2500, "Vnukovo", "Pulkovo", 1);
    Ticket ticket6 = new Ticket(6, 1800, "Vnukovo", "Narimanovo", 2);

    @BeforeEach
    public void setup() {
        manager.save(ticket1);
        manager.save(ticket2);
        manager.save(ticket3);
        manager.save(ticket4);
        manager.save(ticket5);
        manager.save(ticket6);
    }

    @Test
    public void shouldShowReversedItems() {

        Ticket[] expected = {ticket6, ticket5, ticket4, ticket3, ticket2, ticket1};
        Ticket[] actual = manager.getItemsReversed();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldShowItems() {

        Ticket[] expected = {ticket1, ticket2, ticket3, ticket4, ticket5, ticket6};
        Ticket[] actual = manager.getItems();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByFromTo() {

        Ticket[] expected = {ticket3, ticket2, ticket4};
        Ticket[] actual = manager.findAll("Sheremetevo", "Balandino");

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldNotSearchByWrongFromTo() {

        Ticket[] expected = {};
        Ticket[] actual = manager.findAll("Adler", "Balandino");

        Assertions.assertArrayEquals(expected, actual);

    }

}
