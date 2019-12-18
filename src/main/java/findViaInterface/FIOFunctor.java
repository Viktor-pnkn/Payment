package findViaInterface;

import model.Payment;

public class FIOFunctor implements Functor<String> {
    public boolean check(String obj, Payment p) {
        return p.getFio().equals(obj);
    }
}
