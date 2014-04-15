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

        //{"target", {"start", "end", "1"} }

    }

    public ArrayList AnalyzeElement(Element e) {

        ArrayList Parameter = new ArrayList();
        ArrayList tmp = new ArrayList();

        tmp.add("target");
        String startIndex = e.getAttribute("startIndex");
        String endIndex = e.getAttribute("endIndex");
        String step = e.getAttribute("step");

        Parameter.add(startIndex);
        Parameter.add(endIndex);
        Parameter.add(step);

        tmp.add(Parameter);
        return tmp;

    }

    public ArrayList ExecTask(ArrayList a, DomNodeList nl) throws InterruptedException {

        String s = (String) a.get(0);
        String e = (String) a.get(1);
        String p = (String) a.get(2);

        Integer start;
        Integer end;
        Integer step;

        if (s.equals("start")) {
            start = 0;
        }
        else if (s.equals("end")) {
            start = nl.size() - 1;
        }
        else {
            start = Integer.parseInt(s) - 1;
        }

        if (e.equals("start")) {
            end = 1;
        }
        else if (e.equals("end")) {
            end = nl.size();
        }
        else {
            end = Integer.parseInt(e);
        }

        step = Integer.parseInt(p);

        ArrayList tmp  = new ArrayList();
        for (int i = start; i < end; i = i + step) {

            DomElement de = (DomElement) nl.item(i);
            tmp.add(de);
        }
        //DomNodeList r = (DomNodeList) tmp;
        //System.out.println(tmp.size());
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

    public ArrayList ExecTask(ArrayList a, ArrayList nl) throws InterruptedException {

        String s = (String) a.get(0);
        String e = (String) a.get(1);
        String p = (String) a.get(2);

        Integer start;
        Integer end;
        Integer step;

        if (s.equals("start")) {
            start = 0;
        }
        else if (s.equals("end")) {
            start = nl.size() - 1;
        }
        else {
            start = Integer.parseInt(s) - 1;
        }

        if (e.equals("start")) {
            end = 1;
        }
        else if (e.equals("end")) {
            end = nl.size();
        }
        else {
            end = Integer.parseInt(e);
        }

        step = Integer.parseInt(p);

        ArrayList tmp  = new ArrayList();
        for (int i = start; i < end; i = i + step) {

            DomElement de = (DomElement) nl.get(i);
            tmp.add(de);
        }
        //DomNodeList r = (DomNodeList) tmp;
        //System.out.println(tmp.size());
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
