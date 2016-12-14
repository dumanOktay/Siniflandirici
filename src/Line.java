import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by okt on 12/13/16.
 */
public class Line {

    List<String> words;
    String category;

    public Line(String main) {
        String[] temp = main.split(" ");
        words = new ArrayList<>();
        Collections.addAll(words, temp);

        this.category = temp[temp.length-1];
        words.remove(words.size()-1);
    }

    @Override
    public String toString() {
        String t ="";
        for (String s :
                words) {
            t+= s;
        }
        return  t+ "  *** "+ category;
    }
}
