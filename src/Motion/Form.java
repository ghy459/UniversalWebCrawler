package Motion;

import org.w3c.dom.Element;

import java.util.ArrayList;

/**
 * Created by ghy459 on 14-4-13.
 */
public class Form {

    public Form() {

    }

    public ArrayList AnalyzeElement(Element e) {

        ArrayList Parameter = new ArrayList();
        ArrayList tmp = new ArrayList();

        tmp.add("form");

        if (e.hasAttribute("id")) {
            Parameter.add({"":""});
        }
        if (e.hasAttribute("name")) {

        }

    }

}
