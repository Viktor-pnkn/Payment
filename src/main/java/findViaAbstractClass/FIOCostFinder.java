package findViaAbstractClass;

import model.Payment;

public class FIOCostFinder<T> extends Finder<T> {
    @Override
    public boolean check(Payment p, Object[] obj) {//obj[0] - fio, obj[1] - cost
        return obj[0].equals(p.getFio()) && p.getCost() == (double) obj[1];
    }
}

