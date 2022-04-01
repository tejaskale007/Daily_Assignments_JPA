
import java.io.IOException;

public class DriverApplication {
    public static void main(String[] args) throws IOException, InterruptedException {
        BatchOperation.batchInsert();
        System.out.println("First Batch Insert is getting performed\n\nProgram stopped for 12 seconds, check database to confirm commit");
        Thread.sleep(12000);
        BatchOperation.batchDelete();
    }
}