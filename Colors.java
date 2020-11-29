public class Colors {
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_BLACK = "\u001B[30m";
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_YELLOW = "\u001B[33m";
    private static final String ANSI_BLUE = "\u001B[34m";
    private static final String ANSI_PURPLE = "\u001B[35m";
    private static final String ANSI_CYAN = "\u001B[36m";
    private static final String ANSI_WHITE = "\u001B[37m";

    public static String cyan(String str) {
        return print(ANSI_CYAN, str);
    }

    public static String yellow(String str) {
        return print(ANSI_YELLOW, str);
    }

    public static String red(String str) {
        return print(ANSI_RED, str);
    }

    public static String white(String str) {
        return print(ANSI_WHITE, str);
    }

    public static String green(String str) {
        return print(ANSI_GREEN, str);
    }

    public static String purple(String str) {
        return print(ANSI_PURPLE, str);
    }

    private static String print(String color, String str) {
        return color + str + ANSI_RESET;
    }
}
