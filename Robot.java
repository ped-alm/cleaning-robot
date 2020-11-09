public class Robot {
    public static void clean(char[][] pMap) {
        var map = pMap.clone();
        var entrance = findEntrance(map);
    }

    private static int[] findEntrance(char[][] map) {
        var width = map.length;
        var height = map[0].length;

        for(var w=1; w<width-1; w++) {
            if(map[w][height-1] == 'S')
                return new int[]{w, height-2};
        }

        for(var w=1; w<width-1; w++) {
            if(map[w][0] == 'S')
                return new int[]{w, 1};
        }

        for(var h=1; h<height-1; h++) {
            if(map[width-1][h] == 'S')
                return new int[]{width-2, h};
        }

        for(var h=1; h<height-1; h++) {
            if(map[0][h] == 'S')
                return new int[]{1, h};
        }

        return null;
    }
}
