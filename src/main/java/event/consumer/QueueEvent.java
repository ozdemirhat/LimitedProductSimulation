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
        setId(lastCustomerId);
        setTime(interArrival + currentTime);
        setState("queue");
    }

    @Override
    public void process(State state, FutureEventList futureEventList){

        if (Simulation.amountOfProduct > 0) {
            setNextEvent(new CartEvent(state.getClock(), this.getId()));
            futureEventList.addEvent(getNextEvent());
            Simulation.amountOfProduct = Simulation.amountOfProduct - 1;
            Simulation.queueCounter = Simulation.queueCounter - 1;
            System.out.println(this.getTime() + ", Id:" + this.getId() + ", State: Customer waited in QUEUE now will proceed CART");
        }

        else{
            state.addCustomer(this.getId());
            setState("fail");
            Simulation.queueCounter = Simulation.queueCounter - 1;
            System.out.println(this.getTime() + ", Id:" + this.getId() + ", State: Customer waited in QUEUE still no item left FAIL");
        }
    }

    @Override
    public Integer findInterArrival(){
        Random random = new Random();
        Integer range = Simulation.customerArrivalY - Simulation.customerArrivalX;
        return random.nextInt(range + 1) + Simulation.customerArrivalX;
    }
}
