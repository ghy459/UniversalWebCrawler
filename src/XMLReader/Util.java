package XMLReader;

import Motion.Form;
import Motion.Page;
import Motion.Print;
import Motion.Search;
import Motion.Sleep;
import Motion.Target;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by ghy459 on 14-4-13 - 20:10.
 */
public class Util {


    public Util() {

    }

    public File OpenFile(String FileName) {

        return new File(FileName);
    }

    public Document XMLDocument(File f) throws ParserConfigurationException, IOException, SAXException {

        return DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(f);
    }

    public String WebsiteName(Document d) {

        Element website = (Element) d.getElementsByTagName("website").item(0);
        return website.getAttribute("name");
    }

    public ArrayList<Element> StepList(Document d) throws InterruptedException {

        NodeList c = d.getElementsByTagName("step");
        ArrayList<Element> a = new ArrayList<>();
        for (int i = 0; i < c.getLength(); i++) {
            Node e = c.item(i);
            Element tmp = (Element) e.getFirstChild().getNextSibling();
            a.add(tmp);
            //System.out.println(tmp.getClass().getName());
        }
        //Thread.sleep(1000 * 5);
        return a;
    }

    public ArrayList TaskList(ArrayList a) throws InterruptedException {

        ArrayList<ArrayList> tl = new ArrayList<>();
        for (Object anA : a) {
            Element e = (Element) anA;
            String Motion = e.getTagName();
            switch (Motion) {

                case "form":
                    tl.add(new Form().AnalyzeElement(e));
                    break;
                case "page":
                    tl.add(new Page().AnalyzeElement(e));
                    break;
                case "print":
                    tl.add(new Print().AnalyzeElement(e));
                    break;
                case "search":
                    tl.add(new Search().AnalyzeElement(e));
                    break;
                case "sleep":
                    tl.add(new Sleep().AnalyzeElement(e));
                    break;
                case "target":
                    tl.add(new Target().AnalyzeElement(e));
                    break;
                default:
                    break;

            }
        }
        //print(tl);
        //Thread.sleep(1000 * 5);
        return tl;
    }

    public void print(ArrayList a) {

        for (Object anA : a) {
            if (anA.getClass().getName().equals("ArrayList")) {
                print((ArrayList) anA);
            }
            else {
                System.out.println(anA);
            }
        }

    }

}
