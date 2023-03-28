package dubboprovider.service.impl;

import dubbointerface.service.ProviderService;

/**
 * Author: xl
 * date :2020/11/29 12:13
 * description:
 * History:
 * <author>      <time>     <version>       <desc>
 * 作者姓名      修改时间    版本号          描述
 */
public class ProviderServiceImpl implements ProviderService {


    public String sayHello(String word) {
        return word;
    }
}
