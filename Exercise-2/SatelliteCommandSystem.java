import java.util.*;
class Satellite {
    private String dir;
    private boolean panelOn;
    private int dataCollected;
    private List<Observer> observers;
    public Satellite() {
        this.dir = "North";
        this.panelOn = false;
        this.dataCollected = 0;
        this.observers = new ArrayList<>();
    }
    public void add(Observer obs) {
        observers.add(obs);
    }
    private void notify(String message) {
        for (Observer obs : observers) {
            obs.update(message);
        }
    }
    public void rotate(String direction) {
        if (!direction.matches("North|South|East|West")) {
            notify("Invalid rotation: " + direction);
            return;
        }
        this.dir = direction;
        notify("Rotated to " + direction);
    }
    public void activatePanels() {
        if (!panelOn) {
            panelOn = true;
            notify("Solar panels activated");
        } else {
            notify("Solar panels already active");
        }
    }
    public void deactivatePanels() {
        if (panelOn) {
            panelOn = false;
            notify("Solar panels deactivated");
        } else {
            notify("Solar panels already inactive");
        }
    }
    public void collectData() {
        if (panelOn) {
            dataCollected += 10;
            notify("Data collected: " + dataCollected);
        } else {
            notify("Cannot collect data: Solar panels off");
        }
    }
    public void showStatus() {
        System.out.println("Direction: " + dir);
        System.out.println("Solar Panels: " + (panelOn ? "On" : "Off"));
        System.out.println("Data Collected: " + dataCollected);
    }
    public String getDir() { return dir; }
    public boolean isPanelOn() { return panelOn; }
    public int getDataCollected() { return dataCollected; }
    public void setDir(String d) { this.dir = d; }
    public void setPanelOn(boolean on) { this.panelOn = on; }
    public void setDataCollected(int data) { this.dataCollected = data; }
}
interface Observer {
    void update(String message);
}
class Status implements Observer {
    public void update(String message) {
        System.out.println("Message: " + message);
    }
}
interface Command {
    void execute();
    void undo();
}
class RotateCommand implements Command {
    private Satellite satellite;
    private String newDirection;
    private String prev;
    public RotateCommand(Satellite sat, String direction) {
        satellite = sat;
        newDirection = direction;
    }
    public void execute() {
        prev = satellite.getDir();
        satellite.rotate(newDirection);
    }
    public void undo() {
        satellite.rotate(prev);
        System.out.println("Performed UNDO - Rotation reverted");
    }
}
class ActivatePanelsCommand implements Command {
    private Satellite satellite;
    private boolean prev;
    public ActivatePanelsCommand(Satellite sat) {
        satellite = sat;
    }
    public void execute() {
        prev = satellite.isPanelOn();
        satellite.activatePanels();
    }
    public void undo() {
        if (!prev) satellite.deactivatePanels();
        System.out.println("Performed UNDO - Solar panels state reverted");
    }
}
class DeactivatePanelsCommand implements Command {
    private Satellite satellite;
    private boolean prev;
    public DeactivatePanelsCommand(Satellite sat) {
        satellite = sat;
    }
    public void execute() {
        prev = satellite.isPanelOn();
        satellite.deactivatePanels();
    }
    public void undo() {
        if (prev) satellite.activatePanels();
        System.out.println("Performed UNDO - Solar panels state reverted");
    }
}
class CollectDataCommand implements Command {
    private Satellite satellite;
    private int prev;
    public CollectDataCommand(Satellite sat) {
        satellite = sat;
    }
    public void execute() {
        prev = satellite.getDataCollected();
        satellite.collectData();
    }
    public void undo() {
        satellite.setDataCollected(prev);
        System.out.println("Performed UNDO - Data collection reverted");
    }
}
class UndoCommand {
    private Stack<Command> history;
    public UndoCommand() {
        history = new Stack<>();
    }
    public void executeCommand(Command cmd) {
        cmd.execute();
        history.push(cmd);
    }
    public void undoCommand() {
        if (!history.isEmpty()) {
            Command last = history.pop();
            last.undo();
        } else {
            System.out.println("Nothing to undo");
        }
    }
}
public class SatelliteCommandSystem {
    private static Scanner scanner = new Scanner(System.in);
    private static Satellite satellite = new Satellite();
    private static UndoCommand undo = new UndoCommand();
    public static void main(String[] args) {
        satellite.add(new Status());
        show();
    }
    private static void show() {
        System.out.println("\nPress");
        System.out.println("1. Activate Panels");
        System.out.println("2. Deactivate Panels");
        System.out.println("3. Rotate Satellite");
        System.out.println("4. Collect Data");
        System.out.println("5. Show Status");
        System.out.println("6. Undo Last Command");
        System.out.println("7. Exit");
        System.out.print("Enter your choice: ");
        try {
            int choice = Integer.parseInt(scanner.nextLine());
            if (choice == 1) {
                undo.executeCommand(new ActivatePanelsCommand(satellite));
            } else if (choice == 2) {
                undo.executeCommand(new DeactivatePanelsCommand(satellite));
            } else if (choice == 3) {
                System.out.print("Enter direction (North/South/East/West): ");
                String dir = scanner.nextLine();
                undo.executeCommand(new RotateCommand(satellite, dir));
            } else if (choice == 4) {
                undo.executeCommand(new CollectDataCommand(satellite));
            } else if (choice == 5) {
                satellite.showStatus();
            } else if (choice == 6) {
                undo.undoCommand();
            } else if (choice == 7) {
                System.out.println("Exiting Satellite System...");
                return;
            } else {
                System.out.println("Invalid choice.");
            }
        } catch (Exception e) {
            System.out.println("Error - Invalid input: " + e.getMessage());
        }
        show();
    }
}
