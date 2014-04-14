package Motion;

import com.gargoylesoftware.htmlunit.html.DomElement;
import com.gargoylesoftware.htmlunit.html.DomNodeList;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
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

    public ArrayList ExecTask(ArrayList a, HtmlPage htmlPage) {

        ArrayList r = new ArrayList();
        String type = (String) a.get(0);
        if (type.equals("id")) {

            DomElement dom = htmlPage.getElementById((String) a.get(1));
            r.add("DomElement");
            r.add(dom);
        }
        else if (type.equals("tag")) {

            DomNodeList l = htmlPage.getElementsByTagName((String) a.get(1));
            r.add("DomNodeList");
            r.add(l);
        }
        else {

        }
        return r;

    }

    public ArrayList ExecTask(ArrayList a, DomElement d) {

        ArrayList r = new ArrayList();
        String type = (String) a.get(0);
        DomNodeList l = d.getElementsByTagName((String) a.get(1));
        r.add("DomNodeList");
        r.add(l);
        return r;

    }

}
