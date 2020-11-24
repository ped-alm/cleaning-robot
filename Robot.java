public class Robot {

    private static final int W = 0;
    private static final int H = 1;

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

    public static int[][] findPath(char[][] map) {
        var visitedMap = buildBaseVisitedMap(map);
        var floorCount = countFloorSpaces(map);
        var entrance = findEntrance(map);

        visitedMap[entrance[0]][entrance[1]] = 1; // First position
        floorCount--;

        return findPath(map, visitedMap, floorCount, 1, entrance);
    }

    private static int[][] findPath(char[][] map, int[][] visitedMap, int floorCount, int move, int[] pos) {
        Map.print(map);
        Map.print(visitedMap);
        try { Thread.sleep(500);} catch (Exception e) {}

        if (floorCount == 0)
            return visitedMap;

        var result = tryMove(map, visitedMap, floorCount, move, moveUp(pos));
        if(result != null) return result;

        result = tryMove(map, visitedMap, floorCount, move, moveRight(pos));
        if(result != null) return result;

        result = tryMove(map, visitedMap, floorCount, move, moveDown(pos));
        if(result != null) return result;

        result = tryMove(map, visitedMap, floorCount, move, moveLeft(pos));
        if(result != null) return result;

        return null;
    }

    private static int[][] tryMove(char[][] map, int[][] visitedMap, int floorCount, int move, int[] newPos) {
        if(canMove(map, visitedMap, newPos)){
            visitedMap[newPos[W]][newPos[H]] = ++move;
            floorCount--;

            var result = findPath(map, visitedMap, floorCount, move, newPos);
            if(result != null) return result;

            move--;
            visitedMap[newPos[W]][newPos[H]] = 0;
            floorCount++;
        }

        return null;
    }

    private static boolean canMove(char[][] map, int[][] visitedMap, int[] pos) {
        return map[pos[W]][pos[H]] == '0' && visitedMap[pos[W]][pos[H]] == 0;
    }

    private static int[] moveUp(int[] pos) {
        return new int[]{pos[W], pos[H] + 1};
    }

    private static int[] moveRight(int[] pos) {
        return new int[]{pos[W] + 1, pos[H]};
    }

    private static int[] moveDown(int[] pos) {
        return new int[]{pos[W], pos[H] - 1};
    }

    private static int[] moveLeft(int[] pos) {
        return new int[]{pos[W] - 1, pos[H]};
    }
}
