public class PdfDocument implements Document {
    @Override
    public void open() {
        System.out.println("Opening PDF documen");
    }

    @Override
    public void save() {
        System.out.println("Saving PDF document");
    }

    @Override
    public void close() {
        System.out.println("Closing PDF document");
    }
}
