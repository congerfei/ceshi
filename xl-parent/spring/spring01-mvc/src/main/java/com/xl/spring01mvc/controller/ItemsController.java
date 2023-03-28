package com.xl.spring01mvc.controller;

import com.xl.spring01mvc.pojo.Items;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import java.util.ArrayList;
import java.util.List;

/**
 * Author: xl
 * date :2020/11/26 10:31
 * description:
 * History:
 * <author>      <time>     <version>       <desc>
 * 作者姓名      修改时间    版本号          描述
 */
@Controller
public class ItemsController {
    //指定url到请求方法的映射
    @RequestMapping("/list")
    public ModelAndView listItems() throws Exception{

        //静态数据模拟dao返回的数据
        List<Items> itemList = new ArrayList<>();

        //商品列表
        Items items_1 = new Items();
        items_1.setName("联想笔记本_3");
        items_1.setPrice(6000f);
        items_1.setDetail("ThinkPad T430 联想笔记本电脑！");

        Items items_2 = new Items();
        items_2.setName("苹果手机");
        items_2.setPrice(5000f);
        items_2.setDetail("iphone6苹果手机！");

        itemList.add(items_1);
        itemList.add(items_2);
        //创建modelandView对象
        //model模型对象存放了返回页面的数据，view视图指定了返回的页面的路径
        ModelAndView modelAndView = new ModelAndView();
        //添加model，类似request.setAttribute()
        modelAndView.addObject("itemList",itemList);
        //添加视图
        modelAndView.setViewName("/WEB-INF/jsp/itemList.jsp");
        //modelAndView.setViewName("itemsList");
        return modelAndView;
    }
}
