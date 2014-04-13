package XMLReader;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by ghy459 on 14-4-13 - 20:10.
 */
public class Reader {

    private String FileName;
    private File FilePoint;
    private Document XMLDocument;

    private String WebsiteName;
    private ArrayList StepList;
    private ArrayList TaskList;

    public Reader(String FileName) throws IOException, SAXException, ParserConfigurationException, InterruptedException {

        this.FileName = FileName;

        this.openXMLFile();      //打开xml文件
        this.setXMLDocument();   //获取xml dom结构
        this.setWebsiteName();   //获取网站名称
        this.setStepList();      //获取抓取步骤
        this.setTaskList();      //创建任务队列
    }

    public void setTaskList() throws InterruptedException {

        this.TaskList = new Util().TaskList(this.getStepList());

    }

    public void setStepList() throws InterruptedException {

        this.StepList = new Util().StepList(this.getXMLDocument());
    }

    public void setWebsiteName() {

        this.WebsiteName = new Util().WebsiteName(this.getXMLDocument());
    }

    public void setXMLDocument() throws IOException, SAXException, ParserConfigurationException {

        this.XMLDocument = new Util().XMLDocument(this.getFilePoint());
    }

    public void openXMLFile() {

        this.FilePoint = new Util().OpenFile(this.getFileName());
    }

    public String getFileName() {

        return this.FileName;
    }

    public File getFilePoint() {

        return this.FilePoint;
    }

    public Document getXMLDocument() {

        return this.XMLDocument;
    }

    public String getWebsiteName() {

        return this.WebsiteName;
    }

    public ArrayList getStepList() {

        return this.StepList;
    }

    public ArrayList getTaskList() {

        return this.TaskList;
    }


}
