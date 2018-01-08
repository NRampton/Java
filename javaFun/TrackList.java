import java.util.HashMap;

public class TrackList {
  public static void main(String[] args) {
    HashMap<String, String> tracks = new HashMap<>();
    tracks.put("Starlight", "Far away, this ship is taking me far away...");
    tracks.put("Supermassive Black Hole", "Something about a black hole, probably...");
    tracks.put("Map of the Problematique", "Not looking up any more Muse lyrics for this exercise...");
    tracks.put("Exo-Politics", "One more set of lyrics should go here...");
    System.out.println("Getting lyrics by key 'Supermassive Black Hole'...");
    System.out.println(tracks.get("Supermassive Black Hole"));
    System.out.println("Getting song titles and lyrics...");
    for (HashMap.Entry<String, String> entry : tracks.entrySet()) {
      System.out.format("%s: %s", entry.getKey(), entry.getValue());
      System.out.println();
    }
  }
}