public class Main {
    // Optimal values to print on console already
    private static final int WIDTH = 15;
    private static final int HEIGHT = 10;
    private static final int OBSTACLES = 20;
    private static final boolean WITH_WALLS = true;

    public static void main(String[] args) {
        // If the map is not printed, the amount of obstacles is too high and the Map Builder couldn't
        // fit so many obstacles, entering into a infinite loop
        var map = Map.build(WIDTH, HEIGHT, OBSTACLES, WITH_WALLS);
        Map.print(map);

        // Disable the debug if you want to see the end result only
        Robot.setDebug(true);
        // Used only when debug = true; Defines how many milliseconds between each robot step print
        Robot.setDebugSpeed(300);

        Robot.clean(map);
    }
}
