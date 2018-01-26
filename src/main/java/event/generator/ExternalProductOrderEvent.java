package event.generator;

import employee.AbstractEmployee;
import event.EventGenerator;
import product.ExternalProduct;
import product.InternalProduct;
import simulation.FutureEventList;
import simulation.Simulation;
import simulation.State;

import java.util.Random;


/**
 * Created by hatice.ozdemir on 28.12.2017.
 */
public class ExternalProductOrderEvent extends EventGenerator {

    private AbstractEmployee abstactEmployee;

    public ExternalProductOrderEvent(Integer currentTime, AbstractEmployee abstactEmployee){
        this.abstactEmployee = abstactEmployee;

        Integer interArrival = findInterArrival();
        this.setTime(interArrival + currentTime);

        abstactEmployee.requestItem("external", "New External Product Request is Generated");
    }

    @Override
    public void process(State state, FutureEventList futureEventList){
        Simulation.productList.add(new ExternalProduct());
        Simulation.amountOfProduct = Simulation.amountOfProduct + 1;
        System.out.println(this.getTime() + ", State: EXTERNAL product has ARRIVED");
    }

    @Override
    public Integer findInterArrival(){
        Random random = new Random();
        Integer range = Simulation.externalProductOrderY - Simulation.externalProductOrderX;
        return random.nextInt(range + 1) + Simulation.externalProductOrderX;
    }
}
