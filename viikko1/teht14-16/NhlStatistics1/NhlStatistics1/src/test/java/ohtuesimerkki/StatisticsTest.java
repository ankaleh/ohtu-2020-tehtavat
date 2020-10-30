package ohtuesimerkki;

//import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

//import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;



public class StatisticsTest {
 
    Reader readerStub = new Reader() {
 
        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<>();
 
            players.add(new Player("Semenko", "EDM", 4, 12));
            players.add(new Player("Lemieux", "PIT", 45, 54));
            players.add(new Player("Kurri",   "EDM", 37, 53));
            players.add(new Player("Yzerman", "DET", 42, 56));
            players.add(new Player("Gretzky", "EDM", 35, 89));
 
            return players;
        }
    };
 
    Statistics stats;

    @Before
    public void setUp(){
        // luodaan Statistics-olio joka käyttää "stubia"
        stats = new Statistics(readerStub);
    }

    @Test
    public void testTeam() {
        ArrayList<Player> playersOfTeam = new ArrayList<Player>();
        playersOfTeam.add(new Player("Semenko", "EDM", 4, 12));
        playersOfTeam.add(new Player("Kurri",   "EDM", 37, 53));
        playersOfTeam.add(new Player("Gretzky", "EDM", 35, 89));

        assertTrue(playersOfTeam.equals(stats.team("EDM")));
    }

    @Test
    public void testSearch() {
        Player semenko = readerStub.getPlayers().get(0);
        Player player = stats.search("Semenko");
        assertTrue(semenko.equals(player));
        Player somebody = new Player("Somebody", "PIT", 37, 53);
        //somebody.equals(stats.search("Somebody"));
        assertTrue(somebody.equals(stats.search("Somebody")));
    }

    @Test
    public void testTopScorers() {
        ArrayList<Player> playersOnTop = new ArrayList<Player>();
        playersOnTop.add(new Player("Gretzky", "EDM", 35, 89));
        playersOnTop.add(new Player("Lemieux", "PIT", 45, 54));
        playersOnTop.add(new Player("Yzerman", "DET", 42, 56));
        
        assertTrue(playersOnTop.equals(stats.topScorers(3)));

    }
 
}