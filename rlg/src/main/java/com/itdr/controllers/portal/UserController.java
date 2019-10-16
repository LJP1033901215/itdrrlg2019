package com.itdr.controllers.portal;

import com.itdr.common.Const;
import com.itdr.common.ServerResponse;
import com.itdr.pojo.Users;
import com.itdr.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpSession;

/*
* 用户操作控制层*/
//创建控制层注解
@Controller
//返回JOSN格式
@ResponseBody
//创建公用的路径
@RequestMapping("/user/")

public class UserController  {
    @Autowired
    UserService userService;
    //用户登录
    @PostMapping("login.do")
    public ServerResponse<Users> login(String username, String password, HttpSession session){
        ServerResponse<Users> sr = userService.login(username,password,session);

        return sr ;
    }
    //用户注册
    @PostMapping("register.do")
    public ServerResponse<Users> register(Users users){
        ServerResponse<Users> sr = userService.register(users);
        return sr ;
    }
    //判断用户或邮箱是否存在
    @PostMapping("check_valid.do")
    public ServerResponse<Users> checkUsername(String str,String type){
        ServerResponse<Users> sr = userService.checkUsername(str,type);
        return sr ;
    }
    //返回登录情况下的Session中的值
    @PostMapping("get_user_info.do")
    public ServerResponse<Users> getUser(HttpSession session){
        Users attribute = (Users) session.getAttribute(Const.LOGINUSER);
        if (attribute==null){
            return ServerResponse.defeatedRs(Const.UsersEnum.NO_LOGIN.getCode(),Const.UsersEnum.NO_LOGIN.getDesc());
        }else{
            return ServerResponse.successRs(attribute);
        }
    }
    //退出登录
    @PostMapping("logout.do")
    public ServerResponse<Users> logOut(HttpSession session){
       session.removeAttribute(Const.LOGINUSER);
       return ServerResponse.successRs("退出登录");
    }
    //获取当前登录用户的详细信息
    @PostMapping("get_inforamtion.do")
    public ServerResponse<Users> getInforamtion(HttpSession session){
        Users users =(Users)session.getAttribute(Const.LOGINUSER);
       ServerResponse<Users> sr =  userService.getInforamtion(users);
        return sr;
    }
    //登录状态更改个人信息
    @PostMapping("update_information.do")
    public ServerResponse<Users> updateInformation(Users u,HttpSession session){
        Users users =(Users)session.getAttribute(Const.LOGINUSER);
        if (users==null){
            return ServerResponse.defeatedRs(Const.UsersEnum.NO_LOGIN.getCode(),Const.UsersEnum.NO_LOGIN.getDesc());
        }else{
            u.setId(users.getId());
            u.setUsername(users.getUsername());
            ServerResponse<Users> sr =  userService.updateInformation(u);
            session.setAttribute(Const.LOGINUSER,u);
            return sr;
        }

    }

    //忘记密码
    @PostMapping("forget_get_question.do")
    public ServerResponse<Users> forgetGetQuestion(String username){
        return userService.forgetGetQuestion(username);
    }
    //提交密保问题答案，验证
    @PostMapping("forget_check_answer.do")
    public ServerResponse<Users> forgetCheckAnswer(String username,String question,String answer){
        return userService.forgetCheckAnswer(username,question,answer);
    }
    //忘记密码重设密码
    @PostMapping("forget_reset_password.do")
    public ServerResponse<Users> forgetResetPassword(String username,String passwordNew,String forgetToken){
        return userService.forgetResetPassword(username,passwordNew,forgetToken);
    }
    //登录中状态重置密码
    @PostMapping("reset_password.do")
    public ServerResponse<Users> resetPassword(String passwordOld,String passwordNew,HttpSession session){
        Users users = (Users)session.getAttribute(Const.LOGINUSER);
        if (users==null){
            return ServerResponse.defeatedRs("用户未登录");
        }
        return userService.reset_password(users,passwordOld,passwordNew);
    }
 }
