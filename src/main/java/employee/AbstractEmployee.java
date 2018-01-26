package employee;

import java.util.ArrayList;

/**
 * Created by hatice.ozdemir on 28.12.2017.
 */
public abstract class AbstractEmployee {

    protected String source;

    protected ArrayList<String> sourceList;

    protected AbstractEmployee nextEmployee;

    public void setNextEmployee (AbstractEmployee employee){
        this.nextEmployee=employee;
    }

    public void requestItem (String source, String message){
        if(sourceList.indexOf(this.source) <= sourceList.indexOf(source)){
            handleRequest(message);
            if (nextEmployee != null)
                nextEmployee.requestItem(source, message);
        }
    }

    abstract protected void handleRequest(String message);
}