package com.offcn.service;

import com.offcn.user.po.TMember;
import org.springframework.data.redis.core.StringRedisTemplate;

public interface UserService {
    public void registUser(TMember member);
    public TMember login(String username,String password );
    public TMember findTMemberById(Integer id);
}
