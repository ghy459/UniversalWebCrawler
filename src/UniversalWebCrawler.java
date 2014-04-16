import XMLReader.Reader;
import org.xml.sax.SAXException;
import WebCrawler.Crawler;

import javax.xml.parsers.ParserConfigurationException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by ghy459 on 14-4-13.
 */
public class UniversalWebCrawler {  //程序入口

    public static void main(String[] args) throws IOException, InterruptedException, SAXException, ParserConfigurationException {

        BufferedReader b = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("***************************************");
        System.out.println("*                                     *");
        System.out.println("* Welcome to use Universal WebCrawler *");
        System.out.println("*                                     *");
        System.out.println("***************************************");

        System.out.print("请输入配置文件路径：");
        String FileName = b.readLine();
        System.out.println("");

        if (FileName.endsWith(" ")) {   //去掉文件路径的最后一个空格
            FileName = FileName.substring(0, FileName.length() - 1);
        }

        Reader r = new Reader(FileName);
        new Crawler(r.getTaskList());

    }

}


