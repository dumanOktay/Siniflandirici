/**
 * Created by okt on 12/13/16.
 */
public class Main {

    private static String fileNames[] = {
            "ekonomi", "c.txt", "python.txt"
    };

    public static void main(String arg[])
    {
        MyFile myFile = new MyFile(fileNames[0]);

        myFile.kiyasla(new Line("Today the range of fields of study examining the economy revolve around the social science of economics, but may include sociology (economic sociology), history (economic history), anthropology (economic anthropology), and geography (economic geography). Practical fields directly related to the human activities involving production, distribution, exchange, and consumption of goods and services as a whole, are engineering, management, business administration, applied science, and finance."));
    }
}
