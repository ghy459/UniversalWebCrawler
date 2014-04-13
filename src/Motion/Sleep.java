package Motion;

import org.w3c.dom.Element;

import java.util.ArrayList;

/**
 * Created by ghy459 on 14-4-13.
 */
public class Sleep {

    public Sleep() {

        //{"sleep", {"5"} }

    }

    public ArrayList AnalyzeElement(Element e) {

        ArrayList Parameter = new ArrayList();
        ArrayList tmp = new ArrayList();

        String time = e.getAttribute("value");
        Parameter.add(time);
        tmp.add("sleep");
        tmp.add(Parameter);
        return tmp;

    }

}
