package org.example;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/****
 * 第二个线程
 */
@Service
public class Subthread {
    @Async("asyncServiceExecutor")
    public void run() {
        System.out.println("sub thread start!");
        for (int i=0; i<100000;i++);
        System.out.println("sub thread exit!");
    }
}
