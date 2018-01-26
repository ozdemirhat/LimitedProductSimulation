import simulation.Simulation;

/**
 * Created by hatice.ozdemir on 26.12.2017.
 */
public class SimulationApp {
    public static void main(String[] args) {
        System.out.println("This is a simulation app");

        Simulation simulation = new Simulation(0,60, 5,15,5, 3, 15, 50, 100, 100,150);
        simulation.simulate();
    }
}
