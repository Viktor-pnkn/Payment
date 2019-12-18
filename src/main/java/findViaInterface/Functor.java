package findViaInterface;

import model.Payment;

public interface Functor<T> {
    boolean check(T obj, Payment p);
}
