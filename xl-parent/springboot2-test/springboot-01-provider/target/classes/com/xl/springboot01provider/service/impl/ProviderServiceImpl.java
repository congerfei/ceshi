package com.xl.springboot01provider.service.impl;

import com.xl.springboot01provider.service.ProviderService;

/**
 * Author: xl
 * date :2020/12/3 16:21
 * description:
 * History:
 * <author>      <time>     <version>       <desc>
 * 作者姓名      修改时间    版本号          描述
 */

public class ProviderServiceImpl  implements ProviderService {

    @Override
    public String say() {
        return "Hello";
    }

}
