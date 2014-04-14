package Motion;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.w3c.dom.Element;

import java.io.IOException;
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

    public HtmlPage ExecTask(ArrayList Parameter, WebClient webClient) throws IOException {

        return webClient.getPage((String) Parameter.get(0));
    }

}
