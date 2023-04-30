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
    public void print(String message){
        if(printOn == true){
            this.message = message;
            System.out.println("Debug:" + tag + ": " + message);
        }
    }
}
