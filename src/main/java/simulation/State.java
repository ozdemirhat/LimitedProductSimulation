package simulation;

import java.util.ArrayList;

/**
 * Created by hatice.ozdemir on 27.12.2017.
 */
public class State {
    private Integer clock;
    private ArrayList<Integer> totalCustomerIdList;
    private Integer numberOfFails;
    private Integer numberOfSuccess;

    public State(){
        numberOfFails = 0;
        numberOfSuccess = 0;
        clock = 0;
        totalCustomerIdList = new ArrayList<Integer>();
    }

    public Integer getClock(){return clock;}
    public void setClock(Integer clock){this.clock = clock;}

    public ArrayList<Integer> getTotalCustomerIdList(){return totalCustomerIdList;}
    public void addCustomer(Integer customerId){totalCustomerIdList.add(customerId);}

    public Integer getNumberOfFails () {return this.numberOfFails;}
    public void setNumberOfFails(Integer numberOfFails){this.numberOfFails = numberOfFails;}

    public Integer getNumberOfSuccess() {return this.numberOfSuccess;}
    public void setNumberOfSuccess(Integer numberOfSuccess) {this.numberOfSuccess = numberOfSuccess;}
}
