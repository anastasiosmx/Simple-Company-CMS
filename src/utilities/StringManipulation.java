package utilities;
import java.util.Objects;


public class StringManipulation {
    public int[] StringDateTokenizer(String object){
        String[] object_split = object.split("/");
        int b_day   = Integer.parseInt(object_split[0]);
        int b_month = Integer.parseInt(object_split[1]);
        int b_year  = Integer.parseInt(object_split[2]);

        return new int[]{b_day,b_month,b_year};
    }

    public boolean IsTrue(String object){return Objects.equals("Y", object.toUpperCase());}
}
