package Motion;

import org.w3c.dom.Element;

import java.util.ArrayList;

/**
 * Created by ghy459 on 14-4-13.
 */
public class Print {

    public Print() {

        //{"print", {"asText"} }

    }

    public ArrayList AnalyzeElement(Element e) {

        ArrayList Parameter = new ArrayList();
        ArrayList tmp = new ArrayList();

        tmp.add("print");
        Parameter.add(e.getAttribute("type"));

        tmp.add(Parameter);
        return tmp;
    }

}
