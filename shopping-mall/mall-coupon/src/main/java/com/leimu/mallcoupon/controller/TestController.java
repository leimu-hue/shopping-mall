package com.leimu.mallcoupon.controller;

import com.leimu.mallcommon.show.Result;
import com.leimu.mallcoupon.config.SystemPropertyConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private SystemPropertyConfig systemPropertyConfig;

//    public TestController(SystemPropertyConfig systemPropertyConfig) {
//        this.systemPropertyConfig = systemPropertyConfig;
//    }


    @GetMapping("/is/test")
    public Result<String> getAllMessage() {
        return new Result<String>().ok("www    " + systemPropertyConfig.getValueTest());
    }

}
