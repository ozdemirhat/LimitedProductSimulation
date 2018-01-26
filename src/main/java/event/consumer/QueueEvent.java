package event.consumer;

import event.EventGenerator;
import simulation.FutureEventList;
import simulation.Simulation;
import simulation.State;

import java.util.Random;

/**
 * Created by hatice.ozdemir on 27.12.2017.
 */
public class QueueEvent extends EventGenerator {

    public QueueEvent (Integer currentTime, Integer lastCustomerId){
        Integer interArrival = findInterArrival();
        this.id = lastCustomerId;
        this.time = interArrival + currentTime;
        this.state = "queue";
    }

    @Override
    public void process(State state, FutureEventList futureEventList){

        if (Simulation.amountOfProduct > 0) {
            setNextEvent(new CartEvent(state.clock, this.id));
            futureEventList.addEvent(getNextEvent());
            Simulation.amountOfProduct = Simulation.amountOfProduct - 1;
            Simulation.queueCounter = Simulation.queueCounter - 1;
            System.out.println(this.time + ", Id:" + this.id + ", State: Customer waited in QUEUE now will proceed CART");
        }

        else{
            state.addCustomer(this.id);
            this.state = "fail";
            Simulation.queueCounter = Simulation.queueCounter - 1;
            System.out.println(this.time + ", Id:" + this.id + ", State: Customer waited in QUEUE still no item left FAIL");
        }
    }

    @Override
    public Integer findInterArrival(){
        Random random = new Random();
        Integer range = Simulation.customerArrivalY - Simulation.customerArrivalX;
        return random.nextInt(range + 1) + Simulation.customerArrivalX;
    }
}
