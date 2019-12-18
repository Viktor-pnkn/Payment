package program;

import comparators.DiscountComparator;
import comparators.FIOComparator;
import findViaAbstractClass.FIOCostFinder;
import findViaAbstractClass.FIOFinder;
import findViaAbstractClass.Finder;
import findViaInterface.CostFunctor;
import model.Payment;
import model.PaymentList;
import findViaInterface.FIOFunctor;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Map;

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
