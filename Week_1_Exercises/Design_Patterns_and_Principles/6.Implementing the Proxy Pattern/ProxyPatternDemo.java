public class ProxyPatternDemo {
    public static void main(String[] args) {
        Image image = new ProxyImage("sample.jpg");
        image.display();
        System.out.println("");
        image.display();
    }
}
