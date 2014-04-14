package Motion;

import com.gargoylesoftware.htmlunit.html.DomElement;
import com.gargoylesoftware.htmlunit.html.DomNodeList;
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

    public ArrayList ExecTask(ArrayList a, DomNodeList nl) throws InterruptedException {

        String s = (String) a.get(0);
        String e = (String) a.get(1);

        Integer start;
        Integer end;

        if (s.equals("S")) {
            start = 0;
        }
        else if (s.equals("E")) {
            start = nl.size() - 1;
        }
        else {
            start = Integer.parseInt(s) - 1;
        }

        if (e.equals("S")) {
            end = 1;
        }
        else if (e.equals("E")) {
            end = nl.size();
        }
        else {
            end = Integer.parseInt(e);
        }

        ArrayList tmp  = new ArrayList();
        for (int i = start; i < end; i++) {

            DomElement de = (DomElement) nl.item(i);
            tmp.add(de);
        }
        //DomNodeList r = (DomNodeList) tmp;
        //System.out.println(end - start);
        //Thread.sleep(1000 * 5);
        ArrayList r = new ArrayList();
        if (end - start == 1) {
            r.add("DomElement");
            r.add(tmp.get(0));
        }
        else {
            r.add("ArrayList");
            r.add(tmp);
        }
        return r;
    }

}
