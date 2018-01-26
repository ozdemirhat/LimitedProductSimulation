package simulation;


import event.consumer.CustomerArrivalEvent;
import event.EventGenerator;
import employee.AbstractEmployee;
import event.generator.ExternalProductOrderEvent;
import event.generator.InternalProductOrderEvent;
import product.ExternalProduct;
import product.InternalProduct;
import product.Product;
import product.combine.Shirt;
import product.combine.Shoe;
import product.combine.Skirt;

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

    public static ArrayList<Product> productList;


    public Simulation(Integer customerArrivalX, Integer customerArrivalY, Integer customerQueueX, Integer customerQueueY, Integer amountOfProduct, Integer maxQueue, Integer cartWaitTime, Integer internalProductOrderX, Integer internalProductOrderY, Integer externalProductOrderX, Integer externalProductOrderY){
        this.customerArrivalX = customerArrivalX;
        this.customerArrivalY = customerArrivalY;

        this.internalProductOrderX = internalProductOrderX;
        this.internalProductOrderY = internalProductOrderY;
        this.externalProductOrderX = externalProductOrderX;
        this.externalProductOrderY = externalProductOrderY;

        this.customerQueueX = customerQueueX;
        this.customerQueueY = customerQueueY;

        this.amountOfProduct = amountOfProduct;
        this.maxQueue = maxQueue;
        this.queueCounter = 0;
        this.cartWaitTime = cartWaitTime;
        this.productList = new ArrayList<Product>();
    }

    public void simulate() {

        FutureEventList fel = new FutureEventList();
        State state = new State();

        for(int i = 0; i < amountOfProduct; i++ ){
            productList.add(new InternalProduct());
        }

        CustomerArrivalEvent customerArrivalEvent = new CustomerArrivalEvent(0, 0);
        fel.addEvent(customerArrivalEvent);

        while (fel.nextEventTime() != -1 && state.getTotalCustomerIdList().size() < 50){
            state.setClock(fel.nextEventTime());
            EventGenerator currentEvent = fel.popEvent();
            currentEvent.process(state, fel);
        }

    }

}
