package Motion;

import org.w3c.dom.Element;

import java.util.ArrayList;

/**
 * Created by ghy459 on 14-4-13.
 */
public class Target {

    public Target() {

        //{"target", {"S", "E"} }

    }

    public ArrayList AnalyzeElement(Element e) {

        ArrayList Parameter = new ArrayList();
        ArrayList tmp = new ArrayList();

        tmp.add("target");
        String path = e.getAttribute("path");

        Parameter.add(path.split("-")[0]);
        Parameter.add(path.split("-")[1]);

        tmp.add(Parameter);
        return tmp;

    }

}
