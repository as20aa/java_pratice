package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

/***
 * 服务主线程
 */
@RestController//必须要restcontroller，否则会出现服务报错
@RequestMapping(value="/test")
public class MainService {
    @Autowired
    private Subthread subThread;
    @RequestMapping(value="/test", method= RequestMethod.GET)
    public int test() {
        System.out.println("main service start!");
        //根据核心数创建线程数
        int coreCount = Runtime.getRuntime().availableProcessors();
        for (int i = 0; i< coreCount; i++){
            subThread.run();
        }
        System.out.println("main service exit!");


        String[] dirs = new String[]{"1", "2", "3", "4", "5", "6", "7", "8"};
        String[][] outDirs = splitDirs(dirs);
        for (String[] singleDirs:outDirs) {
            System.out.println("singleDirs:" + Arrays.deepToString(singleDirs));
        }
        return 1;
    }

    private String[][] splitDirs(String[] dirs) {
        int coreCount = Runtime.getRuntime().availableProcessors();
        int length = dirs.length / coreCount;//保证length向上取整
        length = length * coreCount == dirs.length ? length : length + 1;
        String[][] outDirs = new String[coreCount][];
        for (int i = 0; i < coreCount - 1; i++) {
            outDirs[i] = Arrays.copyOfRange(dirs, i*length, (i+1)*length);
        }
        outDirs[coreCount-1] = Arrays.copyOfRange(dirs, (coreCount-1)*length, dirs.length);
        System.out.println(Arrays.deepToString(outDirs));
        return outDirs;
    }
}
