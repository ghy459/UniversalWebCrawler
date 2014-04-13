package WebCrawler;

import Motion.*;
import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.apache.commons.logging.LogFactory;

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

    public Crawler(ArrayList TaskQueue) {

        this.TaskQueue = TaskQueue;

        this.InitialWebClient();    //初始化webClient
        this.AnalyzeTaskQueue();
    }

    public void InitialWebClient() {

        this.webClient = new WebClient(BrowserVersion.CHROME);
        this.webClient.getOptions().setJavaScriptEnabled(true);
        this.webClient.getOptions().setThrowExceptionOnScriptError(false);
        this.webClient.getOptions().setPrintContentOnFailingStatusCode(false);
        LogFactory.getFactory().setAttribute("org.apache.commons.logging.Log","org.apache.commons.logging.impl.NoOpLog");
        java.util.logging.Logger.getLogger("com.gargoylesoftware").setLevel(Level.OFF);
    }

    public void AnalyzeTaskQueue() {

        for (Object aTask : this.TaskQueue) {
            this.Task = (ArrayList) aTask;
            AnalyzeTask();
        }
    }

    public void AnalyzeTask() {

        for (Object o : this.Task) {
            ArrayList a = (ArrayList) o;
            switch ((String) a.get(0)) {

                case "form":
                    setWebClient(new Form().ExecTask(this.getWebClient()));
                    break;
                case "page":
                    setWebClient(new Page().ExecTask(this.getWebClient()));
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
    }

    public WebClient getWebClient() {

        return this.webClient;
    }

    public void setWebClient(WebClient webClient) {

        this.webClient = webClient;
    }

}
