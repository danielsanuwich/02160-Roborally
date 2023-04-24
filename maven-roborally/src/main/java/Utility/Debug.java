package Utility;

public class Debug {
    private static final boolean DEBUG = true; // Toggle this flag to enable or disable debug messages

    public static void print(String tag, String message) {
        if (DEBUG) {
            System.out.println("[" + tag + "] " + message);
        }
    }
}



// Example of usecase for debugger

//import app.Utility.Debug;
//
//public class ExampleClass {
//    public void exampleMethod() {
//        Debug.print("ExampleClass", "This is a debug message from exampleMethod()");
//    }
//}
