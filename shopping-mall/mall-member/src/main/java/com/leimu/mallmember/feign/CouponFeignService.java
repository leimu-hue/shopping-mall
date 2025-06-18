package com.leimu.mallmember.feign;

import com.leimu.mallcommon.show.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "mall-coupon")
public interface CouponFeignService {

    @GetMapping("/is/test")
    Result<String> getAllMessage();

}
