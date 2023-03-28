package com.xl.springbootxl.configs.security.service;

import com.xl.springbootxl.mapper.TUsrInfMapper;
import com.xl.springbootxl.pojo.TUsrInf;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 *
 */
@Service
@Log
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private TUsrInfMapper tUsrInfMapper;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;
    /**
     * 将传过来的用户ID 和数据库的进行比对，如果存在则从数据库查出来的账号密码封装到UserDetails对象当中，作为方法返回值返回
     * @param s
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        //用户ID 就是手机号
        log.info("正在登陆用户："+s);
        // 1.根据username查询数据库，判断用户名是否存在
        TUsrInf tUsrInf = tUsrInfMapper.queryById(s);
        if (tUsrInf == null) {
            throw new UsernameNotFoundException("用户不存在！");
        }

        // 2.将数据库当中查出来的username和pwd封装到user对象当中返回 第三个参数表示权限
        List<GrantedAuthority> auths =
                AuthorityUtils.commaSeparatedStringToAuthorityList("role");
        //并对数据库中的密码进行加密，正常数据库的密码都是已经经过加密的
        return new User(tUsrInf.getUsrId(),bCryptPasswordEncoder.encode(tUsrInf.getPswd()), auths);
    }
}
