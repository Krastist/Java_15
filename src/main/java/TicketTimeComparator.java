import java.util.Comparator;

public class TicketTimeComparator implements Comparator<Ticket> {

    @Override
    public int compare(Ticket t1, Ticket t2) {
        int flightTimeT1 = 0;
        int flightTimeT2 = 0;

        if (t1.getTimeTo() < t1.getTimeFrom()) {
            flightTimeT1 = 24 - t1.getTimeFrom() + t1.getTimeTo();
        } else {
            flightTimeT1 = t1.getTimeTo() - t1.getTimeFrom();
        }
        if (t2.getTimeTo() < t2.getTimeFrom()) {
            flightTimeT2 = 24 - t2.getTimeFrom() + t2.getTimeTo();
        } else {
            flightTimeT2 = t2.getTimeTo() - t2.getTimeFrom();
        }

        if (flightTimeT1 < flightTimeT2) {
            return -1;
        } else if (flightTimeT1 > flightTimeT2) {
            return 1;
        } else {
            return 0;
        }
//        if (t1.getTimeTo() < t1.getTimeFrom()) {
//            return -1;
//        } else if (t1.getTimeTo() > t1.getTimeFrom()) {
//            return 1;
//        } else {
//            return 0;
//        }
    }
}