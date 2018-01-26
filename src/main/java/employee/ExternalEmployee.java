package employee;

import java.util.ArrayList;

/**
 * Created by hatice.ozdemir on 28.12.2017.
 */
public class ExternalEmployee extends AbstractEmployee {

    public ExternalEmployee(String source){
        this.source = source;
        sourceList = new ArrayList<String>();
        sourceList.add("operator");
        sourceList.add("internal");
        sourceList.add("external");
    }

    @Override
    protected void handleRequest (String message){
        System.out.println("ExternalEmployee: Processing request. " + message);
    }
}
