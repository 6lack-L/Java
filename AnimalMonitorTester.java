public class AnimalMonitorTester {
    public static void main(String[] args) 
    {
        AnimalMonitor monitor = new AnimalMonitor();
        
        // Default test values
        String filename = "sightings.csv";
        String animal = "Topi";
        int period = 0;
        int spotter = 0;

        // Allow overriding defaults via command-line arguments:
        // args[0] = animal name
        // args[1] = period (int)
        // args[2] = spotter id (int)
        if (args != null) {
            if (args.length > 0 && args[0] != null && !args[0].isEmpty()) {
                animal = args[0];
            }
            if (args.length > 1) {
                try {
                    period = Integer.parseInt(args[1]);
                } catch (NumberFormatException e) {
                    // keep default period
                }
            }
            if (args.length > 2) {
                try {
                    spotter = Integer.parseInt(args[2]);
                } catch (NumberFormatException e) {
                    // keep default spotter
                }
            }
        }
        
        monitor.addSightings(filename);

        System.out.println("\nprint all sightings:");
        monitor.printList();

        System.out.printf("\nprint all sightings of %s:\n", animal);
        monitor.printSightingsOf(animal);

        System.out.printf("\nprinting count of sightings of %s:\n", animal);
        System.out.println(monitor.getCount(animal));

        System.out.printf("\nSightings of %s during period %d\n",animal,period);
        monitor.printSightingsOfDuring(animal, period);

        System.out.printf("\nSightings during period %d\n",period);
        monitor.printSightingsDuring(period);

        System.out.printf("\nSightings in period %d by spotter: %d\n",period,spotter);
        monitor.printSightingsBySpotter(spotter, period);
    }
}
