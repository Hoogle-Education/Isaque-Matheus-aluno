public class Main {
    public static void main(String[] args) throws Exception {
       
        Queue queue = new Queue();

        queue.add(new Job("job 1", 0, 4));
        queue.add(new Job("job 2", 2, 2));
        queue.add(new Job("job 3", 6, 6));
        queue.add(new Job("job 4", 8, 3));
        queue.add(new Job("job 5", 9, 3));
        queue.add(new Job("job 6", 10, 3));

        System.out.println("Average turnround time: " + queue.get_averageTurnroundTime());
        System.out.println("Average time: " + queue.get_average());

        queue.startPool();

    }
}
