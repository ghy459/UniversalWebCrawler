package WebCrawler;

import Motion.Form;
import Motion.Page;
import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
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

    ///Users/ghy459/Desktop/qunar.xml

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
            switch ((String) this.Task.get(0)) {

                case "form":
                    setHtmlPage(new Form().ExecTask((ArrayList) this.Task.get(1), this.getHtmlPage()));
                    System.out.println(this.getHtmlPage().getUrl().toString());
                    Thread.sleep(1000 * 5);
                    break;
                case "page":
                    setHtmlPage(new Page().ExecTask((ArrayList) this.Task.get(1), this.getWebClient()));
                    break;
                /*
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
                */
                default:
                    break;
            }

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

}
