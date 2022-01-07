package com.koreait.community.user;

import com.koreait.community.Const;
import com.koreait.community.model.UserEntity;
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
        if(result != 1){
            switch (result){
                case 0://알수없는 에러 발생
                    res.addFlashAttribute(Const.MSG, Const.ERR_1);
                    break;
                case 2: // 없는 아이디
                    res.addFlashAttribute(Const.MSG, Const.ERR_2);
                    break;
                case 3: // 비밀번호 틀림
                    res.addFlashAttribute(Const.MSG, Const.ERR_3);
                    break;
            }
            res.addFlashAttribute("errId",entity.getUid());
            return "redirect:/user/login";
        }
        return "redirect:/board/list"; // 로그인 성공
    }

    @GetMapping("/join")
    public void join() {}

    @PostMapping("/join")
    public String joinProc(UserEntity entity, RedirectAttributes reAttr){
        int result = service.join(entity);
        if(result ==0){
            reAttr.addFlashAttribute(Const.MSG,Const.ERR_4);
            return  "redirect:/user/join";
        }
        service.login(entity); //회원가입 성공 후 로그인 처리리
        return "reirect:/board/list";
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
