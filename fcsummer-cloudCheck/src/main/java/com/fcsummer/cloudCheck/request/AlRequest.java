package com.fcsummer.cloudCheck.request;

import cn.hutool.json.JSON;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONUtil;
import com.fcsummer.cloudCheck.Domain.AlDomain;
import lombok.SneakyThrows;
import okhttp3.*;
import org.apache.http.client.HttpClient;
import org.springframework.beans.factory.annotation.Value;

import java.util.HashMap;
import java.util.Objects;

/**
 * @Title: AlRequest
 * @Author Fcsummer
 * @Package com.fcsummer.cloudCheck.request
 * @Date 2023/8/26 19:08
 * @description: 阿里请求
 */
public class AlRequest {


    @Value("${al.sign.url}")
    private static String SIGN_URL;


    @Value("${al.update.url}")
    private static  String UPDATE_URL;


    @Value("${al.refresh.token}")
    private static String REFRESH_TOKEN;

    private static final OkHttpClient httpClient=new OkHttpClient();
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

        System.out.println(responseBody);
    }

    public static void main(String[] args) {
        String accessToken = getAccessToken(REFRESH_TOKEN);
        sign_in(accessToken);
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
