import java.util.*;

interface Playlist {
    void playSongs();
}

class WorkoutPlaylist implements Playlist {
    public void playSongs() {
        System.out.println("Playing high energy workout songs!");
    }
}

class RelaxPlaylist implements Playlist {
    public void playSongs() {
        System.out.println("Playing calm relaxing songs.");
    }
}

class PartyPlaylist implements Playlist {
    public void playSongs() {
        System.out.println("Playing upbeat party songs!");
    }
}

class FocusPlaylist implements Playlist {
    public void playSongs() {
        System.out.println("Playing focus and concentration songs.");
    }
}

class PlaylistFactory {
    public static Playlist create(String type) {
        if(type.equals("workout")) return new WorkoutPlaylist();
        else if(type.equals("relax")) return new RelaxPlaylist();
        else if(type.equals("party")) return new PartyPlaylist();
        else if(type.equals("focus")) return new FocusPlaylist();
        else {
            System.out.println("Unknown type, using Relax Playlist.");
            return new RelaxPlaylist();
        }
    }
}

public class FactoryPattern {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter current mood -workout/relax/party/focus- :");
        String choice = sc.nextLine();
        Playlist p = PlaylistFactory.create(choice);
        p.playSongs();
        sc.close();
    }
}
