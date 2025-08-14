public class JavaTechieQuestion {
    public void start(){
        try{
            System.out.println("Starting up ");
            throw new Exception();
        }
        catch(Exception exception){
            System.out.println("Problem ");
            System.exit(0);
        }
        finally {
            System.out.println("Shutting down ");
        }
    }

    public static void main(String[] args) {
        new JavaTechieQuestion().start();
    }
}
