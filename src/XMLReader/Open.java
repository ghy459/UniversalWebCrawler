package XMLReader;

import java.io.File;

/**
 * Created by ghy459 on 14-4-13.
 */
public class Open {

    private String FileName;

    public Open() {

    }

    public File OpenFile(String FileName) {

        return new File(FileName);
    }

}
