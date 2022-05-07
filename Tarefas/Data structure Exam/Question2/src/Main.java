public class Main {
    public static void main(String[] args) throws Exception {
       
        BinarySearchTree<FootballTeam> rankTree = new BinarySearchTree<>();

        rankTree.add(new FootballTeam("Team 1", 100.0, 10));
        rankTree.add(new FootballTeam("Team 2", 100.0, 9));
        rankTree.add(new FootballTeam("Team 3", 100.0, 8));
        rankTree.add(new FootballTeam("Team 4", 550.0, 3));
        rankTree.add(new FootballTeam("Team 5", 1123.0, 17));
        rankTree.add(new FootballTeam("Team 6", 100.0, 15));
        rankTree.add(new FootballTeam("Team 7", 100.0, 13));
        rankTree.add(new FootballTeam("Team 8", 107.0, 6));
        rankTree.add(new FootballTeam("Team 9", 10070.0, 25));
        rankTree.add(new FootballTeam("Team 10", 100.8, 7));
        

        System.out.println("---------------------------");
        System.out.println("teams: " + rankTree.count());

        System.out.println("---------------------------");
        System.out.println("the leader: " + rankTree.min() );

        System.out.println("---------------------------");
        System.out.println("the worst team: " + rankTree.max() );

        System.out.println("---------------------------");
        System.out.println(rankTree);

        System.out.println("---------------------------");        

    }
}
