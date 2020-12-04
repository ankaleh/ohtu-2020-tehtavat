package statistics.matcher;

public class QueryBuilder {
    Matcher matcher;  

    public QueryBuilder() {
        
    }
    
    public Matcher build() {
        if (matcher==null) {
            return new All();
        }
        return matcher;
    }

    public QueryBuilder oneOf(Matcher m1, Matcher m2) {
        this.matcher = new Or(m1, m2);
        return this;
    }

    public QueryBuilder playsIn(String team) {
        //if (this.matcher==null) {
            this.matcher = new PlaysIn(team);
        /* } else {
            this.matcher = new And(this.matcher, new PlaysIn(team));
        } */
        return this; //palauttaa viitteen itseensä (QueryBuilderiin), jolla on oliomuuttujana kyseinen matcher,
        //mikä mahdollistaa sen, että metodikutsuja voi ketjuttaa
    }

    public QueryBuilder hasAtLeast(int value, String category) {
        if (this.matcher==null) {
            this.matcher = new HasAtLeast(value, category);
        } else {
            this.matcher = new And(this.matcher, new HasAtLeast(value, category));
        }
        
        return this;
    }

    public QueryBuilder hasFewerThan(int value, String category) {
        if (this.matcher==null) {
            this.matcher = new HasFewerThan(value, category);
        } else {
            this.matcher = new And(this.matcher, new HasFewerThan(value, category));
        }
        
        return this;
    }


}
