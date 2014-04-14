package Motion;

import WebCrawler.AirportCode;
import com.gargoylesoftware.htmlunit.html.HtmlForm;
import com.gargoylesoftware.htmlunit.html.HtmlInput;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlSubmitInput;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by ghy459 on 14-4-13.
 */
public class Form {

    public Form() {

        //{"form", {"id", "TSForm", { {"SrcCityName", ""}, {"DstCityName", ""} ... }, {"JavaScript", " " }}}

    }

    public ArrayList<Serializable> AnalyzeElement(Element e) {

        ArrayList<Object> Parameter = new ArrayList<>();
        ArrayList<Serializable> tmp = new ArrayList<>();

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
        ArrayList b = new ArrayList();
        for (int i = 0; i < l.getLength(); i++) {
            Element input = (Element) l.item(i);
            ArrayList<String> a = new ArrayList<>();
            a.add(input.getAttribute("id"));
            a.add(input.getAttribute("value"));
            b.add(a);
        }
        Parameter.add(b);
        Element action = (Element) e.getElementsByTagName("action").item(0);
        ArrayList<String> a = new ArrayList<>();
        a.add(action.getAttribute("type"));
        a.add(action.getAttribute("value"));
        Parameter.add(a);

        tmp.add(Parameter);
        return tmp;
    }

    //{"id", "TSForm", { {"SrcCityName", ""}, {"DstCityName", ""} ... }, {"JavaScript", " " } }


    public HtmlPage ExecTask(ArrayList a, HtmlPage htmlPage) throws IOException, InterruptedException {

        String type = (String) a.get(0);
        String action = (String) ((ArrayList) a.get(3)).get(0);
        if(type.equals("id")) {

            HtmlForm form = (HtmlForm) htmlPage.getElementById((String) a.get(1));
            //System.out.println(form.getElementsByTagName("input").get(0).toString());
            //Thread.sleep(1000 * 5);
            for (Object input : (ArrayList) a.get(2)) {
                String name = (String) ((ArrayList) input).get(0);
                String value = (String) ((ArrayList) input).get(1);
                HtmlInput tmp = form.getInputByName(name);
                tmp.setValueAttribute(value);

                if (name.equals("srcCityName")) {
                    tmp = form.getInputByName("srcCity");
                    tmp.setValueAttribute(new AirportCode().query(value));
                }
                else if (name.equals("dstCityName")) {
                    tmp = form.getInputByName("dstCity");
                    tmp.setValueAttribute(new AirportCode().query(value));
                }
                else {

                }
            }
            if (action.equals("button")) {

                HtmlSubmitInput submit = form.getInputByName((String) ((ArrayList) a.get(3)).get(1));
                return submit.click();
            }
            else {

                return (HtmlPage) htmlPage.executeJavaScript((String) ((ArrayList) a.get(3)).get(1)).getNewPage();
            }
        }
        else {

            HtmlForm form = htmlPage.getFormByName((String) a.get(1));
            for (Object input : (ArrayList) a.get(2)) {
                String name = (String) ((ArrayList) input).get(0);
                String value = (String) ((ArrayList) input).get(1);
                HtmlInput tmp = form.getInputByName(name);
                tmp.setValueAttribute(value);

                if (name.equals("srcCityName")) {
                    tmp = form.getInputByName("srcCity");
                    tmp.setValueAttribute(new AirportCode().query(value));
                }
                else if (name.equals("dstCityName")) {
                    tmp = form.getInputByName("dstCity");
                    tmp.setValueAttribute(new AirportCode().query(value));
                }
                else {

                }
            }
            if (action.equals("button")) {

                HtmlSubmitInput submit = form.getInputByName((String) ((ArrayList) a.get(3)).get(1));
                return submit.click();
            }
            else {

                return (HtmlPage) htmlPage.executeJavaScript((String) ((ArrayList) a.get(3)).get(1)).getNewPage();
            }
        }

    }

}
