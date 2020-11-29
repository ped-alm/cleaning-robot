public class Robot {

    private static final int X = 0;
    private static final int Y = 1;
    private static boolean DEBUG = false;
    private static int DEBUG_SPEED = 1;

    private static int[][] buildBaseVisitedMap(char[][] map) {
        var width = map.length; // X
        var height = map[0].length; // Y
        var visited = new int[width][height];

        for (var w = 0; w < width; w++) {
            for (var h = 0; h < height; h++) {
                visited[w][h] = 0;
            }
        }

        return visited;
    }

    private static int countFloorSpaces(char[][] map) {
        var width = map.length; // X
        var height = map[0].length; // Y
        var count = 0;

        for (var w = 1; w < width - 1; w++) {
            for (var h = 1; h < height - 1; h++) {
                if (map[w][h] == '0')
                    count++;
            }
        }

        return count;
    }

    private static int[] findEntrance(char[][] map) {
        var width = map.length; // X
        var height = map[0].length; // Y

        for (var w = 1; w < width - 1; w++) {
            if (map[w][height - 1] == 'S')
                return new int[]{w, height - 2};
        }

        for (var w = 1; w < width - 1; w++) {
            if (map[w][0] == 'S')
                return new int[]{w, 1};
        }

        for (var h = 1; h < height - 1; h++) {
            if (map[width - 1][h] == 'S')
                return new int[]{width - 2, h};
        }

        for (var h = 1; h < height - 1; h++) {
            if (map[0][h] == 'S')
                return new int[]{1, h};
        }

        return null;
    }

    public static void clean(char[][] map) {
        var visitedMap = buildBaseVisitedMap(map);
        var floorCounter = countFloorSpaces(map);
        var entrance = findEntrance(map);

        visitedMap[entrance[X]][entrance[Y]] = 1; // First position
        floorCounter--;

        clean(map, visitedMap, entrance, floorCounter);
    }

    private static void clean(char[][] map, int[][] visitedMap, int[] currentPos, int floorCounter) {
        tryMove(map, visitedMap, moveUp(currentPos), currentPos, floorCounter);
        tryMove(map, visitedMap, moveRight(currentPos), currentPos, floorCounter);
        tryMove(map, visitedMap, moveDown(currentPos), currentPos, floorCounter);
        tryMove(map, visitedMap, moveLeft(currentPos), currentPos, floorCounter);
    }

    private static void tryMove(char[][] map, int[][] visitedMap, int[] newPos, int[] currentPos, int floorCounter) {
        if (canMove(map, visitedMap, newPos, currentPos)) {
            if (visitedMap[newPos[X]][newPos[Y]] == 0) floorCounter--;
            moveVisited(map, visitedMap, newPos);
            if (floorCounter == 0) return;
            clean(map, visitedMap, newPos, floorCounter);
        }
    }

    private static boolean canMove(char[][] map, int[][] visitedMap, int[] newPos, int[] currentPos) {
        return map[newPos[X]][newPos[Y]] == '0' && visitedMap[newPos[X]][newPos[Y]] < visitedMap[currentPos[X]][currentPos[Y]];
    }

    private static int[] moveUp(int[] pos) {
        return new int[]{pos[X], pos[Y] + 1};
    }

    private static int[] moveRight(int[] pos) {
        return new int[]{pos[X] + 1, pos[Y]};
    }

    private static int[] moveDown(int[] pos) {
        return new int[]{pos[X], pos[Y] - 1};
    }

    private static int[] moveLeft(int[] pos) {
        return new int[]{pos[X] - 1, pos[Y]};
    }

    private static void moveVisited(char[][] map, int[][] visitedMap, int[] newPos) {
        visitedMap[newPos[X]][newPos[Y]] += 1;

        if (DEBUG) {
            Map.print(map);
            debugVisitedPrint(visitedMap);
            try {
                Thread.sleep(DEBUG_SPEED);
            } catch (Exception e) {
            }
        }
    }

    private static void debugVisitedPrint(int[][] map) {
        var width = map.length; // X
        var height = map[0].length; // Y
        var builder = new StringBuilder();

        builder.append("\n");
        for (var h = height - 1; h >= 0; h--) {
            for (var w = 0; w < width - 1; w++) {
                builder.append(debugVisitedColorfy(map[w][h]));
                builder.append(" ");
            }

            builder.append(debugVisitedColorfy(map[width - 1][h]));
            builder.append("\n");
        }

        System.out.print(builder.toString());
    }

    private static String debugVisitedColorfy(int i) {
        var str = Integer.toString(i);
        switch (i) {
            case 0:
                return Colors.cyan(str);
            case 1:
            case 2:
            case 3:
                return Colors.green(str);
            case 4:
            case 5:
            case 6:
                return Colors.yellow(str);
            case 7:
            case 8:
            case 9:
                return Colors.red(str);
            default:
                return Colors.purple("X");
        }
    }

    public static void setDebug(boolean b) {
        DEBUG = b;
    }

    public static void setDebugSpeed(int i) {
        DEBUG_SPEED = i;
    }
}
