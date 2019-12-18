package program;

import model.Payment;
import model.PaymentList;

import java.io.IOException;
import java.text.ParseException;

public class Program {
    public static void main(String[] args)  {
        try {
            PaymentList list = PaymentList.loadData("payment.csv");
            for(Payment h : list){
                System.out.println(h);
            }
            System.out.println();
            System.out.println();
            list.discountSorter();
            for(Payment h : list){
                System.out.println(h);
            }
            /*list.sort(new DiscountComparator());
            // list.fioSort(); сортировка через Comparator (по ФИО)
            *//*list.discountSort();
            for(Payment h : list){
                System.out.println(h);
            }*//*
            ArrayList<Payment> pva = list.findAbstract( new FIOCostFinder<>(),"PVA", 10.0);
            //System.out.println(pva);
            System.out.println(list.getArray());*/
            /*Map<String, ArrayList<Payment>> map = PaymentList.operatorsPayments(list);
            PaymentList.writeData(map);*/
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
