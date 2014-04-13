package Motion;

import org.w3c.dom.Element;

import java.util.ArrayList;

/**
 * Created by ghy459 on 14-4-13.
 */
public class Page {

    public Page() {

        //{"page", {"#$*(#)%U)"} }

    }

    public ArrayList AnalyzeElement(Element e) {

        ArrayList Parameter = new ArrayList();
        ArrayList tmp = new ArrayList();

        String home = e.getAttribute("value");
        Parameter.add(home);
        tmp.add("page");
        tmp.add(Parameter);
        return tmp;

    }

}
