package com.leimu.mallmember.controller;

import com.leimu.mallcommon.show.Result;
import com.leimu.mallmember.feign.CouponFeignService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    private final CouponFeignService couponFeignService;

    public TestController(CouponFeignService couponFeignService) {
        this.couponFeignService = couponFeignService;
    }

    @GetMapping("/is/test")
    public Result<String> getAllMessage() {
        return couponFeignService.getAllMessage();
    }

}
