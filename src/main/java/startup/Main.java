package startup;

import controller.Controller;
import integration.CustomerRegistryHandler;
import integration.LoggerToFile;
import integration.PrinterHandler;
import integration.RepairOrderRegistryHandler;
import integration.RepairTaskRegistryHandler;
import view.View;

/** 
 * Starts the program and creates all the necessary objects that are needed to begin using the program.  
 * 
 */
public class Main {
    /** The main method of the program, creates all of the objects needed to begin using the program. Also runs the demo of the program.
     * 
     * @param args standard java main args, not used for the program.
     */
    public static void main(String[] args) {

        CustomerRegistryHandler customerRegistry = new CustomerRegistryHandler();

        RepairOrderRegistryHandler repairOrderRegistry = new RepairOrderRegistryHandler();

        RepairTaskRegistryHandler repairTaskRegistry = RepairTaskRegistryHandler.getInstance();

        PrinterHandler printer = new PrinterHandler();

        Controller controller = new Controller(customerRegistry, repairOrderRegistry, repairTaskRegistry, printer);

        View view = new View(controller);

        view.setLogger(new LoggerToFile());
        
        view.runDemoExecution();
    }
}
