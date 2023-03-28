package com.xl.shirodemo02;

import org.apache.shiro.authc.*;
import org.apache.shiro.realm.Realm;

/**
 * Author: xl
 * date :2020/12/25 21:55
 * description:了解Realm接口  ,需要实现3个方法,此时可以理解成并没有注册进shiro中,需要在配置文件中进行注册
 * History:
 * <author>      <time>     <version>       <desc>
 * 作者姓名      修改时间    版本号          描述
 */
public class ShiroDemo02 implements Realm {

    @Override
    public String getName() {
        return "myRealm02";
    }

    @Override
    public boolean supports(AuthenticationToken authenticationToken) {
        //return false;
        return authenticationToken instanceof UsernamePasswordToken; //仅支持UsernamePasswordToken类型的Token
    }

    @Override//Realm的核心
    public AuthenticationInfo getAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String username = (String)authenticationToken.getPrincipal();  //得到用户名
        String password = new String((char[])authenticationToken.getCredentials()); //得到密码
        if(!"zhang".equals(username)) {
            throw new UnknownAccountException(); //如果用户名错误
        }
        if(!"123".equals(password)) {
            throw new IncorrectCredentialsException(); //如果密码错误
        }
        //如果身份认证验证成功，返回一个AuthenticationInfo实现；
        return new SimpleAuthenticationInfo(username, password, getName());
    }
}
