package simulation;

import event.EventGenerator;

import java.util.ArrayList;
import java.util.Collections;


/**
 * Created by hatice.ozdemir on 27.12.2017.
 */
public class FutureEventList {
    ArrayList<EventGenerator> futureEventList;

    public FutureEventList(){
        this.futureEventList = new ArrayList<EventGenerator>();
    }


    public void addEvent (EventGenerator event){
        this.futureEventList.add(event);
        Collections.sort(futureEventList, (o1, o2) -> o1.getTime().compareTo(o2.getTime()));
    }

    public Integer nextEventTime (){
        if (futureEventList.size() > 0)
            return futureEventList.get(0).getTime();
        else
            return -1; //burayi dusun
    }

    public EventGenerator popEvent (){
        EventGenerator event = futureEventList.get(0);
        futureEventList.remove(futureEventList.get(0));
        //System.out.println(event.getTime());
        return event;
    }

    public ArrayList<EventGenerator> getFutureEventList (){return futureEventList;}

}
