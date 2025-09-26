import java.util.Scanner;
class PrinterManager {
    private static PrinterManager instance;
    private int jobs;
    private PrinterManager() {
        jobs = 0;
        System.out.println("Printer Manager ready");
    }
    public static PrinterManager getInstance() {
        if(instance == null) {
            instance = new PrinterManager();
        }
        return instance;
    }
    public void print(String doc) {
        jobs++;
        System.out.println("Printing doc #" + jobs + ": " + doc);
    }
    public void totalJobs() {
        System.out.println("Total docs printed: " + jobs);
    }
}
public class SingleTonPattern {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        PrinterManager pm1 = PrinterManager.getInstance();
        PrinterManager pm2 = PrinterManager.getInstance();
        System.out.print("Enter total number of prints: ");
        int n = sc.nextInt();
        sc.nextLine();
        for(int i = 0; i < n; i++) {
            System.out.println("Enter document name " + (i+1) + ":");
            String doc = sc.nextLine();
            if(i % 2 == 0) {
                pm1.print(doc);
            } else {
                pm2.print(doc);
            }
        }
        pm1.totalJobs();
    }
}
