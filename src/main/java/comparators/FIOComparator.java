package comparators;

import model.Payment;

import java.util.Comparator;


public class FIOComparator implements Comparator<Payment> {
    public int compare(Payment o1, Payment o2) {
        return o1.getFio().compareTo(o2.getFio());
    }
}
