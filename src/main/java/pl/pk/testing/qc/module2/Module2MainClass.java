package pl.pk.testing.qc.module2;

public class Module2MainClass {

    public static void twoTwoExercise() {
        System.out.println("PK");
        System.out.println("P");
        System.out.println(34);
        System.out.println("K");
    }

    public static Object[] twoThreeExercise() {
        String someString = "text";
        Integer someInt = 5;
        Long someLong = 3L;

        Object[] variables = {someString, someInt, someLong};
        return variables;
    }

    public static void twoNineExercise() {
        Notebook notebook = new Notebook(600, 1000, 2018);
        Notebook goodNotebook = new Notebook(2000, 1500, 2019);
        System.out.println(notebook.prepareOpinion());
        System.out.println(goodNotebook.checkPrice());
    }
}
