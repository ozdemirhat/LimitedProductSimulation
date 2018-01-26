package simulation;


import event.EventGenerator;
import event.consumer.CustomerArrivalEvent;
import product.InternalProduct;
import product.Product;

import java.util.ArrayList;

/**
 * Created by hatice.ozdemir on 27.12.2017.
 */
public class Simulation {
    public static Integer customerArrivalX;
    public static Integer customerArrivalY;
    public static Integer internalProductOrderX;
    public static Integer internalProductOrderY;
    public static Integer externalProductOrderX;
    public static Integer externalProductOrderY;
    public static Integer customerQueueX;
    public static Integer customerQueueY;
    public static Integer cartWaitTime;
    public static Integer amountOfProduct;
    public static Integer maxQueue;
    public static Integer queueCounter;
    public static Integer orderThreshold;

    private Integer totalNumberOfCustomers;

    public static ArrayList<Product> productList;


    public Simulation(){

        //Inter arrival parameters
        this.customerArrivalX = 0;
        this.customerArrivalY = 60;
        this.customerQueueX = 5;
        this.customerQueueY = 15;
        this.internalProductOrderX = 50;
        this.internalProductOrderY = 100;
        this.externalProductOrderX = 100;
        this.externalProductOrderY = 150;

        //Other parameters
        this.amountOfProduct = 10;
        this.maxQueue = 5;
        this.cartWaitTime = 15;
        this.orderThreshold = 5;
        this.totalNumberOfCustomers = 100;


        //Counters and lists
        this.productList = new ArrayList<>();
        this.queueCounter = 0;
    }

    public void simulate() {

        FutureEventList fel = new FutureEventList();
        State state = new State();

        for(int i = 0; i < amountOfProduct; i++ ){
            productList.add(new InternalProduct());
        }

        CustomerArrivalEvent customerArrivalEvent = new CustomerArrivalEvent(0, 0);
        fel.addEvent(customerArrivalEvent);

        while (fel.nextEventTime() != -1 && state.getTotalCustomerIdList().size() < totalNumberOfCustomers){
            state.setClock(fel.nextEventTime());
            EventGenerator currentEvent = fel.popEvent();
            currentEvent.process(state, fel);
        }
        System.out.println("--------RESULTS--------");
        System.out.println("Number of Success: " + state.getNumberOfSuccess());
        System.out.println("Number of Fails: " + state.getNumberOfFails());

    }

}
