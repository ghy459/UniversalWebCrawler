package Motion;

import org.w3c.dom.Element;

import java.util.ArrayList;

/**
 * Created by ghy459 on 14-4-13.
 */
public class Search {

    public Search() {

        //{"search", {"id", "@(#&@"} }
        //{"search", {"tag", "@(#&@"} }

    }

    public ArrayList AnalyzeElement(Element e) {

        ArrayList Parameter = new ArrayList();
        ArrayList tmp = new ArrayList();

        tmp.add("search");
        Parameter.add(e.getAttribute("type"));
        Parameter.add(e.getAttribute("value"));

        tmp.add(Parameter);
        return tmp;
    }

}
