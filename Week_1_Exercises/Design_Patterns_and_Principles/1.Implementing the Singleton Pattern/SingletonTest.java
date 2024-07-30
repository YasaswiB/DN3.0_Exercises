public class SingletonTest {
 public static void main(String[] args) {
     Logger log1 = Logger.getInstance();
     Logger log2 = Logger.getInstance();

     
     if (log1 == log2) {
         System.out.println("Both logger1 and logger2 reference the same instance.");
     } else {
         System.out.println("Different instances exist.");
     }

     
     log1.log("This is a log message.");
 }
}