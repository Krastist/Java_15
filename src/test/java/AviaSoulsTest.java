import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class AviaSoulsTest {
    AviaSouls aviaSouls = new AviaSouls();
    TicketTimeComparator comparator = new TicketTimeComparator();
    Ticket ticket1 = new Ticket("Moscov", "Surgut", 10_000, 6, 13); //Время полета 7
    Ticket ticket2 = new Ticket("Moscov", "Surgut", 11_000, 2, 7);  //Время полета 5
    Ticket ticket3 = new Ticket("Moscov", "Surgut", 10_000, 4, 9);  //Время полета 5
    Ticket ticket4 = new Ticket("Moscov", "Surgut", 13_000, 1, 5);  //Время полета 4
    Ticket ticket5 = new Ticket("Moscov", "Surgut", 9_000, 20, 4);  //Время полета 8

    @BeforeEach
    public void addTicket() {
        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);
    }

    @Test
    public void compareToTest() {

        Assertions.assertEquals(-1, ticket1.compareTo(ticket2));
        Assertions.assertEquals(1, ticket4.compareTo(ticket5));
        Assertions.assertEquals(0, ticket1.compareTo(ticket3));
    }

    @Test
    public void searchTest() {

        Ticket[] expected = {ticket5, ticket1, ticket3, ticket2, ticket4};
        Ticket[] actual = aviaSouls.search("Moscov", "Surgut");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void comparatorTest() {

        Assertions.assertEquals(-1, comparator.compare(ticket4, ticket5));
        Assertions.assertEquals(0, comparator.compare(ticket2, ticket3));
        Assertions.assertEquals(1, comparator.compare(ticket1, ticket2));
    }

    @Test
    public void searchAndSortByTest() {

        Ticket[] expected = {ticket4, ticket2, ticket3, ticket1, ticket5};
        Ticket[] actual = aviaSouls.searchAndSortBy("Moscov", "Surgut", comparator);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void findAllTest() {

        Ticket[] tickets = aviaSouls.findAll();
        Arrays.sort(tickets);

        Ticket[] expected = {ticket5, ticket1, ticket3, ticket2, ticket4};
        Ticket[] actual = aviaSouls.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }
}
