import java.util.*;
interface Avatar{
    void show();
}

class BaseAvatar implements Avatar{
    public void show(){
        System.out.println("Avatar");
    }
}

class Hat implements Avatar{
    Avatar avatar;
    Hat(Avatar a){ avatar=a; }
    public void show(){
        avatar.show();
        System.out.println("Hat");
    }
}

class Glasses implements Avatar{
    Avatar avatar;
    Glasses(Avatar a){ avatar=a; }
    public void show(){
        avatar.show();
        System.out.println("Glasses");
    }
}

class Beard implements Avatar{
    Avatar avatar;
    Beard(Avatar a){ avatar=a; }
    public void show(){
        avatar.show();
        System.out.println("Beard");
    }
}

class Costume implements Avatar{
    Avatar avatar;
    Costume(Avatar a){ avatar=a; }
    public void show(){
        avatar.show();
        System.out.println("Costume");
    }
}

public class DecoratorPattern{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        Avatar avatar = new BaseAvatar();
        System.out.println("Add features: hat/glasses/beard/costume, type done to finish");
        while(true){
            String c = sc.nextLine().toLowerCase().trim();
            if(c.equals("done")) break;
            if(c.equals("hat")) avatar = new Hat(avatar);
            else if(c.equals("glasses")) avatar = new Glasses(avatar);
            else if(c.equals("beard")) avatar = new Beard(avatar);
            else if(c.equals("costume")) avatar = new Costume(avatar);
            else System.out.println("Unknown feature");
        }
        System.out.println("Your avatar ready:");
        avatar.show();
        sc.close();
    }
}
