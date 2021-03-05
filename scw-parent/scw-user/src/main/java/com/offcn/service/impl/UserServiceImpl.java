package com.offcn.service.impl;

import com.offcn.enums.UserExceptionEnum;
import com.offcn.exception.UserException;
import com.offcn.user.mapper.TMemberMapper;
import com.offcn.user.po.TMember;
import com.offcn.user.po.TMemberExample;
import com.offcn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private TMemberMapper memberMapper;
    @Override
    public void registUser(TMember member) {
        /*TMemberExample example = new TMemberExample();
        example.createCriteria().andLoginacctEqualTo(member.getLoginacct());
        long l = memberMapper.countByExample(example);
        if(l > 0 ){//手机号码已经被注册了
            throw new UserException(UserExceptionEnum.LOGINACCT_EXIST);
        }
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encode = encoder.encode(member.getUserpswd());//密码加密
        member.setUserpswd(encode);//设置密码
        member.setAuthstatus("0");//未实名认证
        member.setUsertype("0");
        member.setAccttype("2");
        member.setUsername(member.getLoginacct());//设置用户名
        memberMapper.insertSelective(member);
        System.out.println("数据插入成功");*/
        TMemberExample example = new TMemberExample();
        example.createCriteria().andLoginacctEqualTo(member.getLoginacct());
        long l = memberMapper.countByExample(example);
        if (l>0){//手机号码被注册
            throw new UserException(UserExceptionEnum.LOGINACCT_EXIST);
        }
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encode = encoder.encode(member.getUserpswd());
        member.setUserpswd(encode);
        member.setAuthstatus("0");//未实名认证
        member.setUsertype("0");
        member.setAccttype("2");
        member.setUsername(member.getLoginacct());//设置用户名
        memberMapper.insertSelective(member);
        System.out.println("数据插入成功");


    }
    //登录成功后发放令牌
    @Override
    public TMember login(String username, String password) {
        //密码加密
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        TMemberExample example = new TMemberExample();
        example.createCriteria().andLoginacctEqualTo(username);
        List<TMember> tMembers = memberMapper.selectByExample(example);
        if (tMembers!=null&&tMembers.size()==1){
            TMember member = tMembers.get(0);
            //将输入的密码与数据库中加密后的比较
            boolean matches = encoder.matches(password,member.getUserpswd());
            return matches?member:null;
        }


        return null;
    }

    @Override
    public TMember findTMemberById(Integer id) {
        TMember member = memberMapper.selectByPrimaryKey(id);
        return member;
    }
}
