package event.consumer;

import employee.AbstractEmployee;
import event.EventGenerator;
import event.generator.ExternalProductOrderEvent;
import event.generator.InternalProductOrderEvent;
import product.Product;
import product.combine.Shirt;
import product.combine.Shoe;
import product.combine.Skirt;
import simulation.FutureEventList;
import simulation.RequestChain;
import simulation.Simulation;
import simulation.State;

import java.util.Random;

/**
 * Created by hatice.ozdemir on 27.12.2017.
 */

public class CartEvent extends EventGenerator {
    private AbstractEmployee abstractEmployee;

    public CartEvent(Integer currentTime, Integer lastCustomerId){
        Integer interArrival = findInterArrival();
        setId(lastCustomerId);
        setTime(interArrival + currentTime);
        setState("cart");
        this.abstractEmployee =  RequestChain.getRequestChain();
    }

    @Override
    public void process(State state, FutureEventList futureEventList){
        Double random = Math.random();

        if (random < 0.7){
            state.addCustomer(this.getId());
            setState("success");
            state.setNumberOfSuccess(state.getNumberOfSuccess() + 1);
            System.out.println(this.getTime() + ", Id:" + this.getId() + ", State: Customer has PURCHASED item SUCCESS");
            Product product = Simulation.productList.get(0);
            Simulation.productList.remove(Simulation.productList.get(0));
            decorator(product);
            if (Simulation.amountOfProduct < Simulation.orderThreshold){
                orderProduct(state, futureEventList);
            }
        }
        else{
            state.addCustomer(this.getId());
            setState("fail");
            state.setNumberOfFails(state.getNumberOfFails() + 1);
            Simulation.amountOfProduct = Simulation.amountOfProduct + 1;
            System.out.println(this.getTime() + ", Id:" + this.getId() + ", State: Customer has CHANGED his mind FAIL");
        }
    }

    @Override
    public Integer findInterArrival(){
        Random random = new Random();
        return random.nextInt(Simulation.cartWaitTime + 1);
    }

    public void decorator(Product product){
        Double random = Math.random();
        if (random < 0.1){
            product = new Shirt(product);
            product = new Skirt(product);
            product = new Shoe(product);
        }
        else if (random < 0.3){
            product = new Shirt(product);
            product = new Shoe(product);
        }
        else if (random < 0.5){
            product = new Shirt(product);
        }
        System.out.println("User " + this.getId() + " purchased " + product.getDescription() + " item cost: " + product.cost() + " " + Simulation.amountOfProduct + " item left");
    }

    public void orderProduct(State state, FutureEventList futureEventList){
        Double random = Math.random();
        if (random < 0.8){
            setNextEvent(new InternalProductOrderEvent(state.getClock(), this.abstractEmployee));
            futureEventList.addEvent(getNextEvent());
            System.out.println(this.getTime() + ", State: Internal product is ORDERED");
        }
        else {
            setNextEvent(new ExternalProductOrderEvent(state.getClock(), this.abstractEmployee));
            futureEventList.addEvent(getNextEvent());
            System.out.println(this.getTime() + ", State: External product is ORDERED");
        }
    }

}
