import java.util.Random;

public class Map {
    public static char[][] build(int width, int height, int obstacles) {
        width += 2;
        height += 2;

        var map = new char[width][height];
        var random = new Random();

        for (var i = 0; i < width; i++) {
            for (var j = 0; j < height; j++) {
                map[i][j] = '0';
            }
        }

        for (var w = 0; w < width; w++) {
            map[w][0] = '1';
        }

        for (var w = 0; w < width; w++) {
            map[w][height - 1] = '1';
        }

        for (var h = 0; h < height; h++) {
            map[0][h] = '1';
        }

        for (var h = 0; h < height; h++) {
            map[width - 1][h] = '1';
        }

        var isHorizontalExit = random.nextBoolean();
        var sW = 0;
        var sH = 0;

        if (isHorizontalExit) {
            sW = random.nextInt(width);
            sH = random.nextInt(2) * (height - 1);
        } else {
            sH = random.nextInt(height);
            sW = random.nextInt(2) * (width - 1);
        }

        map[sW][sH] = 'S';

        for (var i = 0; i < obstacles; i++) {
            var w = 0;
            var h = 0;

            while (map[w][h] == '1' || map[w][h] == 'S') {
                w = random.nextInt(width);
                h = random.nextInt(height);
            }

            map[w][h] = '1';
        }

        return map;
    }

    public static void print(char[][] map) {
        var width = map.length;
        var height = map[0].length;
        var builder = new StringBuilder();

        builder.append("\n");
        for (var h = height - 1; h >= 0; h--) {
            for (var w = 0; w < width - 1; w++) {
                builder.append(colorfy(map[w][h]));
                builder.append(" ");
            }

            builder.append(colorfy(map[width - 1][h]));
            builder.append("\n");
        }

        System.out.print(builder.toString());
    }

    private static String colorfy(char c) {
        var str = String.valueOf(c);

        switch (c) {
            case '1':
                return Colors.cyan(str);
            case '0':
                return Colors.yellow(str);
            case 'S':
                return Colors.red(str);
            default:
                return null;
        }
    }
}