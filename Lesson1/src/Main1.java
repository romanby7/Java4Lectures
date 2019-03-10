public class Main1 {

    private static int b;

    public static void main(String[] args) {
//        int a = 5;
//        System.out.println(a);
//        System.out.println(b);
//
//        String str = new String("str");
//        String str2 = "str";
//        String str3 = "str";
//
//        System.out.println(str == str2);
//        System.out.println(str3 == str2);
//        System.out.println(str.equals(str2));
//
//        Person p1 = new Person(30, "Pavel");
//        Person p2 = new Person(30, "Pavel");
//
//        System.out.println("-----------");
//        System.out.println(p1 == p2);
//        System.out.println(p1.equals(p2));

        int a = 5;
        System.out.println("a = " + a);
        a = testPrimitive(a);
//        testPrimitive(5);
        System.out.println("a = " + a);

        System.out.println("----------");

        String str = "555";//#001
        System.out.println("str = " + str);
        testString(str);
//        testPrimitive(#001);
        System.out.println("str = " + str);

        Person p1 = new Person(30, "Pavel");//#001
        System.out.println(p1);
        testPerson(p1);//001
        System.out.println(p1);

        Integer aaa = 5;
    }

    private static void testPerson(Person p1) {
        p1.setName("Andrey");//001
    }

    private static void testString(String str) {
        //String str = #001;
        System.out.println("str = " + str);
        str = "777";//#002
        System.out.println("str = " + str);
    }

    private static int testPrimitive(int a/*5*/) {
//        int a = 5;
        System.out.println("a = " + a);
        a = 10;
        System.out.println("a = " + a);
        return a;
    }
}
