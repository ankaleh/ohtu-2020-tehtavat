package statistics.matcher;

import statistics.Player;

public class Or implements Matcher {

    private Matcher[] matchers;

    public Or(Matcher... matchers) { //parametrina mätsereitä, esim. HasAtLeast(5, "goals") ja
                                    //PlaysIn("PHI")
        this.matchers = matchers;
    }

    @Override
    public boolean matches(Player p) { 
        for (Matcher matcher : matchers) {
            if (matcher.matches(p)) {
                //System.out.println(p.getName());
                return true;
            }
        }  
       
        return false;

    }
    
}
