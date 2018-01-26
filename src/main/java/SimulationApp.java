import simulation.Simulation;

/**
 * Created by hatice.ozdemir on 26.12.2017.
 */
public class SimulationApp {
    public static void main(String[] args) {
        System.out.println("This is a simulation app");

        Simulation simulation = new Simulation();
        simulation.simulate();
    }
}
