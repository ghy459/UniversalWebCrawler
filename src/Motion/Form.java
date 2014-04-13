package Motion;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by ghy459 on 14-4-13.
 */
public class Form {

    public Form() {

        //{"form", {"id", "TSForm", {"SrcCityName", ""}, {"DstCityName", ""}, ... }, {"JavaScript", " " }}

    }

    public ArrayList<Serializable> AnalyzeElement(Element e) {

        ArrayList<Object> Parameter = new ArrayList<Object>();
        ArrayList<Serializable> tmp = new ArrayList<Serializable>();

        tmp.add("form");

        if (e.hasAttribute("id")) {
            Parameter.add("id");
            Parameter.add(e.getAttribute("id"));
        }
        if (e.hasAttribute("name")) {
            Parameter.add("name");
            Parameter.add(e.getAttribute("name"));
        }
        NodeList l = e.getElementsByTagName("input");
        for (int i = 0; i < l.getLength(); i++) {
            Element input = (Element) l.item(i);
            ArrayList<String> a = new ArrayList<String>();
            a.add(input.getAttribute("id"));
            a.add(input.getAttribute("value"));
            Parameter.add(a);
        }
        Element action = (Element) e.getElementsByTagName("action").item(0);
        ArrayList<String> a = new ArrayList<String>();
        a.add(action.getAttribute("type"));
        a.add(action.getAttribute("value"));
        Parameter.add(action);

        tmp.add(Parameter);
        return tmp;
    }

}
