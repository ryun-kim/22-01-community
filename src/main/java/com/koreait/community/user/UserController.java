package com.koreait.community.user;

import com.koreait.community.Const;
import com.koreait.community.user.model.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    public UserService service;

    @GetMapping("/login")
    public void login(){}

    @PostMapping("/login")
    public String loginProc(UserEntity entity, RedirectAttributes res){
        int result = service.login(entity);
        switch (result){
            case 0://알수없는 에러 발생
                res.addFlashAttribute(Const.MSG, Const.ERR_1);
                break;
            case 1:// 로그인 성공
                return "redirect:/board/list";
            case 2: // 없는 아이디
                res.addFlashAttribute(Const.MSG, Const.ERR_2);
                break;
            case 3: // 비밀번호 틀림
                res.addFlashAttribute(Const.MSG, Const.ERR_3);
                break;
        }
        return "redirect:/user/login";
    }

    @GetMapping("/join")
    public void join() {}

    @PostMapping("/join")
    public String joinProc(UserEntity entity){
        // TODO 회원가입 성공하면 로그인 처리
        int result = service.join(entity);
        return "redirect:/user/login";
    }

    @GetMapping("/idChk/{uid}")
    @ResponseBody
    public Map<String, Integer> idChk(@PathVariable String uid) {
        System.out.println("uid :" + uid);
        Map<String, Integer > res = new HashMap<>();
        res.put("result", service.idChk(uid));
        return res;
    }
}
