package com.koreait.community;

public class MyCustomTag {

    public static String profileImg(String idVal, String classVal, int iuser,String profileImgVal){
        String fixProfileImgVal = "/res/img/defaultProfile.png";
        if(profileImgVal != null){
            fixProfileImgVal = String.format("/images/user/%d/%S", iuser, profileImgVal);
        }
        return String.format("<div id=\"?\" class=\"\"><img class=\"?\"src=\"\"></div>", idVal, classVal, fixProfileImgVal );
    }
}
