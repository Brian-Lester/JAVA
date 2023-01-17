public class TestPuzzle {
    public static void main(String[] args){

        PuzzleJava appTest = new PuzzleJava();

        for (int i = 0; i < appTest.array10().length; i++){
            System.out.println(appTest.array10()[i]);
        }
        System.out.println(appTest.randomChar());
        System.out.println(appTest.randomPassword());
        System.out.println(appTest.randomPassword(26));
    }
}

