import java.util.*;
interface Strategy{
    String edit(String doc);
}
class UpperCaseStrategy implements Strategy{
    public String edit(String doc){
        return doc.toUpperCase();
    }
}
class LowerCaseStrategy implements Strategy{
    public String edit(String doc){
        return doc.toLowerCase();
    }
}
class ReverseStrategy implements Strategy{
    public String edit(String doc){
        return new StringBuilder(doc).reverse().toString();
    }
}
class DocumentEditor{
    Strategy s;
    void setStrategy(Strategy st){
        s = st;
    }
    void performEdit(String doc){
        String res = s.edit(doc);
        System.out.println("Edited Document: "+res);
    }
}
public class StrategyPattern{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        DocumentEditor ed = new DocumentEditor();
        System.out.print("Enter your document text:");
        String d = sc.nextLine();
        System.out.print("Choose strategy: uppercase or lowercase or reverse: ");
        String ch = sc.nextLine();
        if(ch.equals("uppercase")) ed.setStrategy(new UpperCaseStrategy());
        else if(ch.equals("lowercase")) ed.setStrategy(new LowerCaseStrategy());
        else if(ch.equals("reverse")) ed.setStrategy(new ReverseStrategy());
        else {
            System.out.println("Invalid choice, defaulting to uppercase");
            ed.setStrategy(new UpperCaseStrategy());
        }
        ed.performEdit(d);
    }
}
