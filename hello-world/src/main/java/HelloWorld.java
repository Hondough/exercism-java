public class HelloWorld {
    public static String hello(String name) {
        String nameOut = name;
        if (nameOut == null || "".equals(nameOut)) {
            nameOut = "World";
        }
        return "Hello, " + nameOut + "!";
    }
}
