package com.xl.springboot5wxgzh.controller;

import com.xl.springboot5wxgzh.domain.AccessToken;
import com.xl.springboot5wxgzh.domain.event.*;
import com.xl.springboot5wxgzh.domain.msg.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
public class WXController {
    /**
     * 接入微信平台需要用到
     */
    private static final String token = "congerfei";


    /**
     *   获取token需要用到
     */
    private static final String APP_ID = "wx7cf88fdd41679125";
    private static final String APP_SECRET = "477f780ae411e53dd709ab0a37f9ac15";
    private static final String GET_ACCESS_TOKEN = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET".replace("APPID", APP_ID).replace("APPSECRET", APP_SECRET);

    /**
     * 微信URL接入验证   是GET方法   和下面一个接收消息的方法 url一致，但是接收消息的是POST方法
     * @param signature
     * @param timestamp
     * @param nonce
     * @param echostr
     * @return
     */
    @GetMapping("/wechat")
    public String access(@RequestParam("signature") String signature,
                         @RequestParam("timestamp") String timestamp,
                         @RequestParam("nonce") String nonce,
                         @RequestParam("echostr") String echostr) {

        log.info("微信URL接入验证时候传入的参数："+"signature--"+signature+"  timestamp--"+timestamp+"  nonce--"+nonce+"  echostr--"+echostr);
        String[] params = new String[]{token, timestamp, nonce};
        Arrays.sort(params);

        String joinParams = StringUtils.join(params);
        String sha1Params = DigestUtils.sha1Hex(joinParams);
        if (sha1Params.equals(signature)) {
            log.info("接入微信公众平台成功！");
            return echostr;
        } else {
            log.info("接入微信公众平台失败！");
            return "illegal";
        }
    }


    @Autowired
    private RestTemplate restTemplate;
    private AccessToken accessToken;

    @GetMapping("/wechat/getAccessToken")
    public AccessToken getAccessToken() {
        if (accessToken == null ) {
            accessToken = restTemplate.getForObject(GET_ACCESS_TOKEN, AccessToken.class);//rest风格的调用方式，第一个参数url，第二个参数响应报文根据json报文自己封装的对象
            if("".equals(accessToken.getErrcode())){
                log.info("获取AccessToken失败!  token = "+accessToken);
            }
        }
        return accessToken;
    }

    /**
     *  接收消息
     * @param body
     * @return
     */
    @PostMapping(value = "/wechat", produces = "application/xml;charset=UTF-8")
    public String notification(@RequestBody String body) {
        try {
            log.info("接收消息的请求体："+body);
            Map<String, String> parse = parseXmlToMap(body);
            String msgType = parse.get("msgType");
            log.info("信息类型MsgType:"+msgType);
            switch (msgType) {
                case "text":
                    TextMessage textMessage = new TextMessage();
                    BeanUtils.populate(textMessage, parse);
                    log.info("{}", textMessage);
                    break;
                case "image":
                    ImageMessage imageMessage = new ImageMessage();
                    BeanUtils.populate(imageMessage, parse);
                    log.info("{}", imageMessage);
                    break;
                case "voice":
                    VoiceMessage voiceMessage = new VoiceMessage();
                    BeanUtils.populate(voiceMessage, parse);
                    log.info("{}", voiceMessage);
                    break;
                case "video":
                    VideoMessage videoMessage = new VideoMessage();
                    BeanUtils.populate(videoMessage, parse);
                    log.info("{}", videoMessage);
                    break;
                case "location":
                    LocationMessage locationMessage = new LocationMessage();
                    BeanUtils.populate(locationMessage, parse);
                    log.info("{}", locationMessage);
                    break;
                case "link":
                    LinkMessage linkMessage = new LinkMessage();
                    BeanUtils.populate(linkMessage, parse);
                    log.info("{}", linkMessage);
                    break;
                case "file":
                    FileMessage fileMessage = new FileMessage();
                    BeanUtils.populate(fileMessage, parse);
                    log.info("{}", fileMessage);
                    break;
                case "event":
                    eventHandle(parse);
                    break;
                default:
                    log.info("{}", "未知消息!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "error";
    }






    private String eventHandle(Map<String, String> parse) {
        try {
            String event = parse.get("event");
            String eventKey = parse.get("eventKey");
            if (eventKey == null || eventKey.equals("")) {
                switch (event) {
                    case "subscribe"://订阅事件
                        BaseEventMessage subEventMessage = new BaseEventMessage();
                        BeanUtils.populate(subEventMessage, parse);
                        log.info("subscribe={}", subEventMessage);
                        break;
                    case "unsubscribe"://取消订阅
                        BaseEventMessage unSubEventMessage = new BaseEventMessage();
                        BeanUtils.populate(unSubEventMessage, parse);
                        log.info("unsubscribe={}", unSubEventMessage);
                        break;
                    case "LOCATION"://上报位置
                        LocationEventMessage locationEventMessage = new LocationEventMessage();
                        BeanUtils.populate(locationEventMessage, parse);
                        log.info("{}", locationEventMessage);
                        break;
                    default:
                        log.info("{}", "未知事件!");
                }
            } else {
                switch (event) {
                    case "subscribe"://如果用户还未关注公众号，则用户可以关注公众号，关注后微信会将带场景值关注事件推送给开发者。
                        TicketEventMessage subsTicketEventMessage = new TicketEventMessage();
                        BeanUtils.populate(subsTicketEventMessage, parse);
                        log.info("subs={}", subsTicketEventMessage);
                        break;
                    case "SCAN"://如果用户已经关注公众号，在用户扫描后会自动进入会话，微信也会将带场景值扫描事件推送给开发者。
                        TicketEventMessage scanTicketEventMessage = new TicketEventMessage();
                        BeanUtils.populate(scanTicketEventMessage, parse);
                        log.info("scan={}", scanTicketEventMessage);
                        break;
                    case "CLICK"://菜单按钮
                        ClickEventMessage clickEventMessage = new ClickEventMessage();
                        BeanUtils.populate(clickEventMessage, parse);
                        log.info("{}", clickEventMessage);
                        break;
                    case "VIEW"://菜单链接
                        ViewEventMessage viewEventMessage = new ViewEventMessage();
                        BeanUtils.populate(viewEventMessage, parse);
                        log.info("{}", viewEventMessage);
                        break;
                    default:
                        log.info("{}", "未知事件!");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "error";
    }




    //将Xml字符串解析为Map对象
    private Map<String, String> parseXmlToMap(String body) {
        Map<String, String> map = new HashMap<>();
        try {
            Document document = DocumentHelper.parseText(body);
            Element root = document.getRootElement();
            List<Element> elements = root.elements();
            for (Element element : elements) {
                String key = element.getName();
                String val = element.getStringValue();
                map.put(StringUtils.uncapitalize(key), val);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }

}

