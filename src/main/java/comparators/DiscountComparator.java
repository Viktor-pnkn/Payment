package comparators;

import model.Payment;

import java.util.Comparator;

public class DiscountComparator implements Comparator<Payment> {
    public int compare(Payment o1, Payment o2) {
        return Integer.compare(o1.getDiscount(), o2.getDiscount());
    }
}
