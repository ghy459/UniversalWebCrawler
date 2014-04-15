package WebCrawler;

import Motion.Form;
import Motion.Page;
import Motion.Print;
import Motion.Search;
import Motion.Sleep;
import Motion.Target;
import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.DomElement;
import com.gargoylesoftware.htmlunit.html.DomNodeList;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.apache.commons.logging.LogFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;

/**
 * Created by ghy459 on 14-4-13 - 21:34.
 */
public class Crawler {

    private ArrayList TaskQueue;
    private ArrayList Task;

    private WebClient webClient;
    private HtmlPage htmlPage;
    private DomElement domElement;
    private DomNodeList domNodeList;
    private ArrayList domArray;

    private String NowType = "";

    ///Users/ghy459/Desktop/tmall.xml

    public Crawler(ArrayList TaskQueue) throws IOException, InterruptedException {

        this.TaskQueue = TaskQueue;

        this.InitialWebClient();    //初始化webClient
        this.AnalyzeTaskQueue();
    }

    public void InitialWebClient() {

        this.webClient = new WebClient(BrowserVersion.CHROME);
        this.webClient.getOptions().setJavaScriptEnabled(true);
        this.webClient.getOptions().setThrowExceptionOnScriptError(false);
        this.webClient.getOptions().setPrintContentOnFailingStatusCode(false);
        LogFactory.getFactory().setAttribute("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.NoOpLog");
        java.util.logging.Logger.getLogger("com.gargoylesoftware").setLevel(Level.OFF);
    }

    public void AnalyzeTaskQueue() throws IOException, InterruptedException {

        for (Object aTask : this.TaskQueue) {
            this.Task = (ArrayList) aTask;
            AnalyzeTask();
        }
    }

    public void AnalyzeTask() throws IOException, InterruptedException {


            //ArrayList a = (ArrayList) o;
            ArrayList a;
            switch ((String) this.Task.get(0)) {

                case "form":
                    setHtmlPage(new Form().ExecTask((ArrayList) this.Task.get(1), this.getHtmlPage()));
                    break;
                case "page":
                    setHtmlPage(new Page().ExecTask((ArrayList) this.Task.get(1), this.getWebClient()));
                    break;
                case "print":
                    if (this.getNowType().equals("DomElement")) {
                        new Print().ExecTask((ArrayList) this.Task.get(1), this.getDomElement());
                    }
                    else {
                        new Print().ExecTask((ArrayList) this.Task.get(1), this.getDomArray());
                    }
                    break;
                case "search":
                    if (this.getNowType().equals("DomElement")) {
                        a = new Search().ExecTask((ArrayList) this.Task.get(1), this.getDomElement());
                    }
                    else {
                        a = new Search().ExecTask((ArrayList) this.Task.get(1), this.getHtmlPage());
                    }
                    this.setNowType((String) a.get(0));
                    if (this.getNowType().equals("DomElement")) {
                        this.setDomElement((DomElement) a.get(1));
                    }
                    else if (this.getNowType().equals("DomNodeList")) {
                        this.setDomNodeList((DomNodeList) a.get(1));
                    }
                    else {

                    }
                    break;
                case "sleep":
                    new Sleep().ExecTask((ArrayList) this.Task.get(1));
                    break;
                case "target":
                    if (this.getNowType().equals("ArrayList")) {
                        a = new Target().ExecTask((ArrayList) this.Task.get(1), this.getDomArray());
                    }
                    else {
                        a = new Target().ExecTask((ArrayList) this.Task.get(1), this.getDomNodeList());
                    }
                    this.setNowType((String) a.get(0));
                    if (this.getNowType().equals("DomElement")) {
                        this.setDomElement((DomElement) a.get(1));
                    }
                    else if (this.getNowType().equals("ArrayList")) {
                        this.setDomArray((ArrayList) a.get(1));
                    }
                    else {

                    }
                    break;
                default:
                    break;
            }

    }

    public ArrayList getDomArray() {

        return this.domArray;
    }

    public String getNowType() {

        return this.NowType;
    }

    public DomNodeList getDomNodeList() {

        return this.domNodeList;
    }

    public DomElement getDomElement() {

        return this.domElement;
    }

    public HtmlPage getHtmlPage() {

        return this.htmlPage;
    }

    public WebClient getWebClient() {

        return this.webClient;
    }

    public void setWebClient(WebClient webClient) {

        this.webClient = webClient;
    }

    public void setHtmlPage(HtmlPage htmlPage) {

        this.htmlPage = htmlPage;
    }

    public void setDomElement(DomElement domElement) {

        this.domElement = domElement;
    }

    public void setDomNodeList(DomNodeList domNodeList) {

        this.domNodeList = domNodeList;
    }

    public void setNowType (String NowType) {

        this.NowType = NowType;
    }

    public void setDomArray (ArrayList domArray) {

        this.domArray = domArray;
    }

}
