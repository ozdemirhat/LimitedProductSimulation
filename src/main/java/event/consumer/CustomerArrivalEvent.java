package event.consumer;

import event.EventGenerator;
import simulation.FutureEventList;
import simulation.Simulation;
import simulation.State;

import java.util.Random;

/**
 * Created by hatice.ozdemir on 27.12.2017.
 */
public class CustomerArrivalEvent extends EventGenerator {

    public CustomerArrivalEvent(Integer currentTime, Integer lastCustomerId){
        Integer interArrival = findInterArrival();
        this.id = lastCustomerId + 1;
        this.time = interArrival + currentTime;
        this.state = "Generated";
    }

    @Override
    public void process(State state, FutureEventList futureEventList){
        CustomerArrivalEvent nextArrivalEvent = new CustomerArrivalEvent(state.clock, this.id);
        futureEventList.addEvent(nextArrivalEvent);

        if (Simulation.amountOfProduct > 0) {
            Simulation.amountOfProduct = Simulation.amountOfProduct - 1;
            setNextEvent(new CartEvent(state.clock, this.id));
            futureEventList.addEvent(getNextEvent());
            System.out.println(this.time + ", Id:" + this.id + ", State: Customer is GENERATED now will proceed CART");
        }
        else if (Simulation.queueCounter < Simulation.maxQueue){
            Simulation.queueCounter = Simulation.queueCounter + 1;
            setNextEvent(new QueueEvent(state.clock, this.id));
            futureEventList.addEvent(getNextEvent());
            System.out.println(this.time + ", Id:" + this.id + ", State: Customer is GENERATED no item left queue is valid QUEUE");
        }
        else {
            state.addCustomer(this.id);
            this.state = "fail";
            System.out.println(this.time + ", Id:" + this.id + ", State: Customer is GENERATED no item left queue is full FAIL");
        }
    }

    @Override
    public Integer findInterArrival(){
        Random random = new Random();
        Integer range = Simulation.customerArrivalY - Simulation.customerArrivalX;
        return random.nextInt(range + 1) + Simulation.customerArrivalX;
    }
}
