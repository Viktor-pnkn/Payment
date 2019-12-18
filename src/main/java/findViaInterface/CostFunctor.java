package findViaInterface;

import model.Payment;

public class CostFunctor implements Functor<Double> {
    public boolean check(Double obj, Payment p) {
        return obj == p.getCost();
    }
}
