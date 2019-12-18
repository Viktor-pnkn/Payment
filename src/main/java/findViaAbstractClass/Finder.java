package findViaAbstractClass;

import model.Payment;

public abstract class Finder<T> {
    public abstract boolean check( Payment p, T... obj);
}


