package statistics.matcher;

import statistics.Player;

public class And implements Matcher {

    private Matcher[] matchers;

    public And(Matcher... matchers) { //parametrina mätsereitä, esim. HasAtLeast(5, "goals") ja
                                    //PlaysIn("PHI")
        this.matchers = matchers;
    }

    @Override
    public boolean matches(Player p) {
        for (Matcher matcher : matchers) {
            if (!matcher.matches(p)) {
                return false;
            }
        }

        return true;
    }
}
