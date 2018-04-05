package com.farmer.farmerloginservice;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name="database wali service")                     //need to change
public class FeignProxy {

}
