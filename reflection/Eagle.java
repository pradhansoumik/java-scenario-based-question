public class Eagle extends Bird{
    public boolean canTalk = false;
    public boolean isCanTalk() {
        return canTalk;
    }
    private String breed = "breed";
    public String getBreed() {
        return breed;
    }


    public void eat(){
        System.out.println("Eating ...");
    }
    public void walk(){
        System.out.println("Walking ...");
    }
    private void fly(){
        System.out.println("Flying ...");
    }

    private String beat(boolean val, String name, int range){
        return "Yes => " +val+ " : " +name+ " : " +range;
    }
    public void swim(boolean val, String name, int range){
        System.out.println("I can't swim :: " +val+ " : " +name+ " : " +range);
    }
}
