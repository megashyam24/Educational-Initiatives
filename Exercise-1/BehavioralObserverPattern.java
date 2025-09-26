import java.util.*;
interface Subscriber {
    void receive(String msg);
}
class User implements Subscriber {
    String n;

    User(String name) {
        n = name;
    }
    public void receive(String m) {
        System.out.println(n + " got a new message : " + m);
    }
}
class Pub {
    String t;
    Subscriber subs[] = new Subscriber[10];
    int cnt = 0;
    Pub(String topic) {
        t = topic;
    }
    public void sub(Subscriber s) {
        if (cnt < subs.length) {
            subs[cnt] = s;
            cnt++;
        }
    }
    public void pubMsg(String m) {
        for (int i = 0; i < cnt; i++) {
            subs[i].receive("Subscribed for " + t + ":" + m);
        }
    }
}
public class BehavioralObserverPattern {
    public static void main(String arg[]) {
        Scanner sc = new Scanner(System.in);
        Pub sp = new Pub("Sports");
        Pub nw = new Pub("News");
        Pub ent = new Pub("Entertainment");
        System.out.print("how many users:");
        int x = sc.nextInt();
        sc.nextLine();
        User u[] = new User[x];
        for (int i = 0; i < x; i++) {
            System.out.print("user name:");
            String n = sc.nextLine();
            u[i] = new User(n);
            System.out.print("subscribe to news,sports,entertainment : ");
            String s = sc.nextLine();
            String arr[] = s.split(",");
            for (String p : arr) {
                p = p.trim().toLowerCase();
                if (p.equals("news")) {
                    nw.sub(u[i]);
                } else if (p.equals("sports")) {
                    sp.sub(u[i]);
                } else if (p.equals("entertainment")) {
                    ent.sub(u[i]);
                }
            }
        }
        System.out.print("sports update:");
        String msg = sc.nextLine();
        sp.pubMsg(msg);
        System.out.print("news update:");
        String msg2 = sc.nextLine();
        nw.pubMsg(msg2);
        System.out.print("entertainment update:");
        String msg3 = sc.nextLine();
        ent.pubMsg(msg3);
    }
}
