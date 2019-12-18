package findViaAbstractClass;

import model.Payment;

public class FIOFinder<T> extends Finder<String> {

    @Override
    public boolean check( Payment p, String... obj) {
        return obj[0].equals(p.getFio());
    }
}
