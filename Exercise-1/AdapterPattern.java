import java.util.*;
interface MemoryCard{
    void readData();
}
class SDCard implements MemoryCard{
    public void readData(){
        System.out.println("Reading from SD Card");
    }
}
class MicroSDCard implements MemoryCard{
    public void readData(){
        System.out.println("Reading from MicroSD Card");
    }
}
interface USBPort{
    void connect();
}
class CardAdapter implements USBPort{
    MemoryCard card;
    CardAdapter(MemoryCard c){
        card = c;
    }
    public void connect(){
        System.out.print("Connected: ");
        card.readData();
    }
}
public class AdapterPattern{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose card to connect (sd/micro):");
        String choice = sc.nextLine().toLowerCase();
        MemoryCard card;
        if(choice.equals("sd")){
            card = new SDCard();
        } else if(choice.equals("micro")){
            card = new MicroSDCard();
        } else {
            System.out.println("Invalid choice, defaulting to SD Card");
            card = new SDCard();
        }
        USBPort usb = new CardAdapter(card);
        usb.connect();
    }
}
