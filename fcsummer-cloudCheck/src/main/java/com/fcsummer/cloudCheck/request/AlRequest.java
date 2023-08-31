package com.fcsummer.cloudCheck.request;

import cn.hutool.core.date.DateUtil;
import cn.hutool.extra.mail.MailUtil;
import cn.hutool.json.JSONUtil;
import com.fcsummer.cloudCheck.Domain.al.AlDomain;
import com.fcsummer.cloudCheck.Domain.al.AlSignInResultDomain;
import com.fcsummer.cloudCheck.Domain.al.AlSignInDomain;
import com.fcsummer.cloudCheck.util.FcDateUtils;
import com.fcsummer.cloudCheck.util.FcMailUtil;
import lombok.SneakyThrows;
import okhttp3.*;
import org.springframework.beans.factory.annotation.Value;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Title: AlRequest
 * @Author Fcsummer
 * @Package com.fcsummer.cloudCheck.request
 * @Date 2023/8/26 19:08
 * @description: 阿里请求
 */
public class AlRequest {


//    @Value("${al.sign.url}")
    private static String SIGN_URL="https://member.aliyundrive.com/v1/activity/sign_in_list?_rx-s=mobile";


//    @Value("${al.update.url}")
    private static  String UPDATE_URL="https://auth.aliyundrive.com/v2/account/token";


//    @Value("${al.refresh.token}")
    private static String REFRESH_TOKEN="524efeb45f2e4beba9c245296f7f9f9c";

    private static final OkHttpClient httpClient=new OkHttpClient();

    private static final List<String> checkList=new ArrayList<>();
    static {
        checkList.add(REFRESH_TOKEN);
    }
    //进行签到
    @SneakyThrows
    public static void sign_in(String accessToken) {
        OkHttpClient client = new OkHttpClient();
        MediaType mediaType = MediaType.parse("application/json");
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("isReward",false);
        String jsonStr = JSONUtil.toJsonStr(hashMap);
        RequestBody body = RequestBody.create(mediaType, jsonStr);

        Request request = new Request.Builder()
                .url(SIGN_URL)
                .post(body)
                .addHeader("Authorization", accessToken)
                .addHeader("Content-Type", "application/json")
                .build();

        Response response = client.newCall(request).execute();
        String responseBody = response.body().string();
        AlSignInDomain alSignInDomain = JSONUtil.toBean(responseBody, AlSignInDomain.class);
        Boolean success = alSignInDomain.getSuccess();
        if(success){
            AlSignInResultDomain result = alSignInDomain.getResult();
            Integer signInCount = result.getSignInCount();
            String notice = result.getSignInLogs().get(signInCount-1).getReward().getNotice();
            FcMailUtil.sendMailSuccess(notice);
        }else{
           FcMailUtil.sendMailFail();
        }
        FcMailUtil.sendMail();
    }


    public static void getStart(){
        for (String refreshToken : checkList) {
            String accessToken = getAccessToken(refreshToken);
            sign_in(accessToken);
        }
    }

    @SneakyThrows
    public static String getAccessToken(String refreshToken){
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("grant_type","refresh_token");
        hashMap.put("refresh_token",refreshToken);
        String jsonStr = JSONUtil.toJsonStr(hashMap);
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, jsonStr);

        Request request = new Request.Builder()
                .url(UPDATE_URL)
                .post(body)
                .addHeader("Content-Type", "application/json")
                .build();

        Response response = httpClient.newCall(request).execute();
        String responseBody = response.body().string();
        AlDomain alDomain = JSONUtil.toBean(responseBody, AlDomain.class);
        System.out.println(alDomain.getAccessToken());
        return alDomain.getAccessToken();
    }
}
