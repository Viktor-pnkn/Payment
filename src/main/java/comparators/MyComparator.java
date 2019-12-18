package comparators;

import model.Payment;

import java.util.Comparator;


public interface MyComparator<T> extends Comparator<T> {
    int compare(Payment o1, Payment o2);
}
