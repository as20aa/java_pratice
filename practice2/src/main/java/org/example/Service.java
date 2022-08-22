package org.example;

import org.springframework.web.bind.annotation.*;

/***
 * 测试服务
 */
@RestController
@RequestMapping(value="/test")
public class Service {
    @RequestMapping(value="/test", method= RequestMethod.POST)
    @ResponseBody
    public Hero test(@RequestBody Hero info) {
        System.out.println(getClass()+"input: " + info.toString());
        return info;
    }
}
