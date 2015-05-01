public class Task252 {

    private static final int S0 = 290797;
    private static final int MOD = 50515093;

    private static final int MAX = 2000;
    private static final int OFFSET = 1000;

    private static long current = S0;

    private static final int TOTAL_POINTS = 500;

    private static int nextRandom() {
        current = current*current % MOD;
        return (int)current;
    }

    private static int nextCoordinate() {
        return nextRandom()%MAX - OFFSET;
    }

    static class Point {
        public final int x;
        public final int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static Point points[] = new Point[TOTAL_POINTS];

    public static void main(String[] args) {
        for(int i=0;i<TOTAL_POINTS;i++) {
            points[i] = new Point(nextCoordinate(), nextCoordinate());
        }
        // total number of pairs: 500*500 = 250000
        // возьмем пару и будем строить от нее полигон 
        //       добавляя треугольники проверяя не попала ли какая вершина в треугольник
        // если попала берем следующий треугольник
        // может ли одна и таже грань (направленая) попасть в два полигона? - возможно может
    }

}