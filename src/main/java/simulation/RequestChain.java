package simulation;

import employee.AbstractEmployee;
import employee.ExternalEmployee;
import employee.InternalEmployee;
import employee.OperatorEmployee;

/**
 * Created by hatice.ozdemir on 28.12.2017.
 */
public class RequestChain {

    public  static AbstractEmployee getRequestChain(){


        AbstractEmployee operatorEmployee = new OperatorEmployee("operator");
        AbstractEmployee internalEmployee = new InternalEmployee("internal");
        AbstractEmployee externalEmployee = new ExternalEmployee("external");

        operatorEmployee.setNextEmployee(internalEmployee);
        internalEmployee.setNextEmployee(externalEmployee);

        return operatorEmployee;
    }
}


