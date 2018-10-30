import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Item> phase1 = new ArrayList<>();
        ArrayList<Item> phase2 = new ArrayList<>();

        Simulation simulation = new Simulation();
        try {
            BufferedReader br = new BufferedReader(new FileReader("phase-1.txt"));
            phase1 = simulation.loadItems(br);
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }

        try {
            BufferedReader br = new BufferedReader(new FileReader("phase-2.txt"));
            phase2 = simulation.loadItems(br);
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }

        U1 u1 = new U1();
        u1.printProperties();

        System.out.println("\n");

        U2 u2 = new U2();
        u2.printProperties();

        System.out.println("\n");

        System.out.println("U1 Rocket's budget for Phase-1");
        simulation.loadU1(phase1);
        simulation.runSimulation(simulation.getArrayOfU1());

        System.out.println("\n\n\n");

        System.out.println("U1 Rocket's budget for Phase-2");
        simulation.loadU1(phase2);
        simulation.runSimulation(simulation.getArrayOfU1());

        System.out.println("\n\n\n");

        System.out.println("U2 Rocket's budget for Phase-1");
        simulation.loadU2(phase1);
        simulation.runSimulation(simulation.getArrayOfU2());

        System.out.println("\n\n\n");

        System.out.println("U2 Rocket's budget for Phase-2");
        simulation.loadU2(phase2);
        simulation.runSimulation(simulation.getArrayOfU2());

    }
}
