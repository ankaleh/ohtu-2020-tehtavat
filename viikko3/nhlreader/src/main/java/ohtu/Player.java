
package ohtu;

public class Player implements Comparable<Player> {
    private String name;
    private Integer assists;
    private Integer penalties;
    private String team;
    private String nationality;
    private Integer goals;

    private Integer points;

    public Player() {

    }

    public Player(String name, String nationality, Integer assits, Integer goals, Integer points) {
        this.name = name;
        this.nationality = nationality;
        this.assists = assits;
        this.goals = goals;
        this.points = points;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public Integer getPenalties() {
        return penalties;
    }

    public void setPenalties(Integer penalties) {
        this.penalties = penalties;
    }

    public Integer getAssists() {
        return assists;
    }

    public void setAssists(Integer assists) {
        this.assists = assists;
    }

    public String getName() {
        return name;
    }

    public Integer getGoals() {
        return goals;
    }

    public void setGoals(Integer goals) {
        this.goals = goals;
    }


    @Override
    public String toString() {
        return name + ", team " + team + ", goals " + goals + ", assits " + assists;
    }

    @Override
    public int compareTo(Player p) {
        return p.points - this.points;
    }

}
