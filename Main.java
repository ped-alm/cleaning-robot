public class Main {
    public static void main(String[] args) {
        var testMap1 = new char[][]{
                {'1', '1', '1', '1', '1', '1', '1', '1', '1', '1'},
                {'1', '0', '0', '0', '0', '1', '0', '1', '0', '1'},
                {'1', '0', '0', '0', '0', '0', '0', '0', '0', '1'},
                {'1', '0', '0', '0', '0', '0', '1', '0', '0', '1'},
                {'1', '1', '0', '1', '0', '0', '0', '1', '0', '1'},
                {'1', '0', '1', '1', '1', '0', '0', '0', '0', '1'},
                {'1', '0', '1', '0', '0', '0', '1', '0', '1', '1'},
                {'1', '0', '0', '1', '0', '0', '1', '0', '0', '1'},
                {'S', '0', '1', '0', '0', '0', '0', '0', '0', '1'},
                {'1', '0', '1', '1', '0', '0', '0', '0', '0', '1'},
                {'1', '0', '0', '0', '0', '0', '0', '0', '0', '1'},
                {'1', '0', '0', '0', '0', '0', '0', '0', '0', '1'},
                {'1', '1', '0', '0', '0', '0', '0', '0', '0', '1'},
                {'1', '0', '0', '1', '0', '0', '1', '0', '0', '1'},
                {'1', '1', '1', '1', '1', '1', '1', '1', '1', '1'},
        };

//        var testMap2 = new char[][]{
//                {'1', '1', '1', '1', '1', '1', '1', '1', '1', '1'},
//                {'1', '0', '0', '0', '0', '0', '0', '0', '0', '1'},
//                {'1', '0', '0', '0', '0', '0', '0', '0', '0', '1'},
//                {'1', '0', '0', '1', '0', '1', '0', '1', '0', '1'},
//                {'1', '0', '0', '0', '0', '0', '0', '0', '0', '1'},
//                {'1', '0', '0', '0', '0', '0', '0', '0', '0', '1'},
//                {'1', '0', '1', '0', '0', '1', '0', '0', '0', '1'},
//                {'1', '0', '0', '0', '0', '0', '0', '0', '0', '1'},
//                {'1', '0', '0', '0', '0', '0', '0', '1', '0', '1'},
//                {'1', '0', '0', '1', '0', '1', '0', '0', '0', '1'},
//                {'1', '0', '0', '0', '0', '0', '0', '0', '0', '1'},
//                {'1', '0', '0', '0', '1', '0', '0', '0', '0', '1'},
//                {'1', '0', '0', '0', '0', '0', '0', '1', '0', '1'},
//                {'1', '0', '0', '0', '0', '0', '0', '0', '0', '1'},
//                {'1', 'S', '1', '1', '1', '1', '1', '1', '1', '1'},
//        };

        Map.print(testMap1);
        Robot.clean(testMap1);
        System.out.println("ok");
        Map.print(testMap1);
//        var map = Map.build(15, 10, 10);

//        for(var i=0; i<map.length; i++) {
//            for(var j=0; j<map[0].length; j++) {
//                System.out.print("\'" + map[i][j] + "\', " );
//            }
//            System.out.println("\n");
//        }
    }

    //TODO nao voltar para o 0 no backtrack. Passar a incrementar o movimento sempre e analisar para movimentor pra
    // casa que possuir o menor valor
}
