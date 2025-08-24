package customAnnotations;

public class AnnotationMain {
    public static void main(String[] args) {
        System.out.println(new AnnotationTest().getClass().getAnnotation(MyCustomAnnotations.class));
    }
}
