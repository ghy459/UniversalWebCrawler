package Motion;

import com.gargoylesoftware.htmlunit.html.DomElement;
import com.gargoylesoftware.htmlunit.html.DomNode;
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

    public void ExecTask(ArrayList a, ArrayList nl) {

        if (((String) a.get(0)).equals("asText")) {
            for (Object anE : nl) {
                DomNode e = (DomElement) anE;
                System.out.println(e.asText());
            }
        }
        else {

        }
    }

    public void ExecTask(ArrayList a, DomElement e) {

        if (((String) a.get(0)).equals("asText")) {
            System.out.println(e.asText());
        }
        else {

        }

    }

}
