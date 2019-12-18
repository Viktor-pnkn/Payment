package model;

import comparators.DiscountComparator;
import comparators.FIOComparator;
import comparators.MyComparator;
import findViaAbstractClass.FIOFinder;
import findViaAbstractClass.Finder;
import findViaInterface.Functor;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class PaymentList implements Iterable<Payment> {
    private ArrayList<Payment> payments;

    public PaymentList() {
        payments = new ArrayList<Payment>();
    }

    public static void writeData(Map<String, ArrayList<Payment>> map) throws IOException {
        for (Map.Entry<String, ArrayList<Payment>> entry : map.entrySet()) {
            BufferedWriter bw = new BufferedWriter(new FileWriter(entry.getKey()));
            for (Payment p : entry.getValue()) {
                bw.write(p.getFio() + " " + p.getTeleOperator() + " " + p.getDateOfSpeaking() + " " + p.getCost() + " " + p.getDiscount() + "\n");
            }
            bw.close();
        }
    }

    public static PaymentList loadData(String fileName) throws IOException, ParseException {
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        SimpleDateFormat f = new SimpleDateFormat("dd.MM.yyyy");
        PaymentList list = new PaymentList();
        while (br.ready()) {
            String s = br.readLine();
            String[] split = s.split(";");
            Payment payment = new Payment(split[0], split[1], f.parse(split[2]), Double.parseDouble(split[3]), Integer.parseInt(split[4]));
            list.add(payment);
        }
        return list;
    }

    public void add(Payment payment) {
        this.payments.add(payment);
    }

    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < payments.size(); i++) {
            s += payments.get(i) + "\n";
        }
        return s;
    }

    public <T> ArrayList<Payment> find(T obj, Functor<T> f) {
        ArrayList<Payment> list = new ArrayList<Payment>();
        for (Payment p : this) {
            if (f.check(obj, p)) {
                list.add(p);
            }
        }
        return list;
    }

    public <T> ArrayList<Payment> findAbstract(Finder<T> f, T... obj) {
        ArrayList<Payment> list = new ArrayList<Payment>();
        for (Payment p : this) {
            if (f.check(p, obj)) {
                list.add(p);
            }
        }
        return list;
    }

    /**
     * Сортировка по цене с учетом скидки
     */
    public void discountSorter() {
        this.sort(new Comparator<Payment>() {
            @Override
            public int compare(Payment o1, Payment o2) {
                if (o1.getDiscount() * o1.getCost() > o2.getDiscount() * o2.getCost()) {
                    return 1;
                } else if (o1.getDiscount() * o1.getCost() < o2.getDiscount() * o2.getCost()) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });
    }

    public Payment[] getArray() {
        Payment[] payments = this.payments.toArray(new Payment[0]);
        Arrays.sort(payments);
        return payments;
    }

    public Iterator<Payment> iterator() {
        return this.payments.iterator();
    }

    public void sort(Comparator f) {
        this.payments.sort(f);
    }

    public static Map<String, ArrayList<Payment>> operatorsPayments(PaymentList list) {
        Map<String, ArrayList<Payment>> map = new HashMap<>();
        for (Payment p : list) {
            if (!map.containsKey(p.getTeleOperator())) {
                ArrayList<Payment> payment = new ArrayList<>();
                payment.add(p);
                map.put(p.getTeleOperator(), payment);
            } else {
                map.get(p.getTeleOperator()).add(p);
            }
        }
        return map;
    }
}
