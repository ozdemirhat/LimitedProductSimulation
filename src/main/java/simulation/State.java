package simulation;

import java.util.ArrayList;

/**
 * Created by hatice.ozdemir on 27.12.2017.
 */
public class State {
    public Integer clock;
    public ArrayList<Integer> totalCustomerIdList;

    public State(){
        clock = 0;
        totalCustomerIdList = new ArrayList<Integer>();
    }

    public Integer getClock(){return clock;}

    public void setClock(Integer clock){this.clock = clock;}

    public ArrayList<Integer> getTotalCustomerIdList(){return totalCustomerIdList;}

    public void addCustomer(Integer customerId){totalCustomerIdList.add(customerId);}
}
