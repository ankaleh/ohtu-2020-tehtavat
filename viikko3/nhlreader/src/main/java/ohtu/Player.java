
package ohtu;

public class Player {
    private String name;
    private Integer assists;
    private Integer penalties;
    private String team;
    private String nationality;
    private Integer goals;

    public void setName(String name) {
        this.name = name;
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

    @Override
    public String toString() {
        return name + ", team " + team + ", goals " + goals + ", assits " + assists;
    }
      
}
