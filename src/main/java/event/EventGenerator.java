package event;

import simulation.FutureEventList;
import simulation.State;

/**
 * Created by hatice.ozdemir on 27.12.2017.
 */
public abstract class EventGenerator {
    private Integer time;
    private Integer id;
    private String state;
    private EventGenerator nextEvent;

    public Integer getTime(){return time;}
    public Integer getId(){return id;}
    public String getState(){return state;}
    public EventGenerator getNextEvent(){return nextEvent;}

    public void setTime(Integer time){this.time = time;}
    public void setId(Integer id){this.id = id;}
    public void setState(String state){this.state = state;}
    public void setNextEvent (EventGenerator event) {this.nextEvent = event;}

    public abstract void process(State state, FutureEventList futureEventList);

    public abstract Integer findInterArrival();
}
