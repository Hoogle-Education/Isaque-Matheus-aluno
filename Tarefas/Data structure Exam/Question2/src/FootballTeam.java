public class FootballTeam implements Comparable<FootballTeam>{
  
  private String teamName;
  private double budget;
  private int leaguePosition;
  
  public FootballTeam(String teamName, double budget, int leaguePosition) {
    this.teamName = teamName;
    this.budget = budget;
    this.leaguePosition = leaguePosition;
  }

  public String getTeamName() {
    return teamName;
  }

  public void setTeamName(String teamName) {
    this.teamName = teamName;
  }

  public double getBudget() {
    return budget;
  }

  public void setBudget(double budget) {
    this.budget = budget;
  }

  public int getLeaguePosition() {
    return leaguePosition;
  }

  public void setLeaguePosition(int leaguePosition) {
    this.leaguePosition = leaguePosition;
  }

  @Override
  public int compareTo(FootballTeam other) {
    return Integer.compare(leaguePosition, other.getLeaguePosition());
  }

  @Override
  public String toString() {
    return "FootballTeam [budget=" + budget + ", leaguePosition=" + leaguePosition + ", teamName=" + teamName + "]";
  }


}
