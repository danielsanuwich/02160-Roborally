public class Debug{
    // Debug attributes 
    private boolean printOn = true;
    private String tag;
    private String message;

    // Debug constructor 
    public Debug(String tag){
        this.tag = tag;
    }

    // Debug print
    public print(String message){
        this.message = message;
        System.out.println("Debug:" + tag + ": " + message);
    }
}
