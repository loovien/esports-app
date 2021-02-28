package com.esportsmore.web;

import org.junit.Test;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.math.BigInteger;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

public class HttpTest {

    @Test
    public void httpTest() throws IOException, InterruptedException {
//        HttpRequest request = HttpRequest.newBuilder(URI.create("https://www.zhanqi.tv"))
//                .setHeader("content-type", "application/json;charset=utf-8")
//                .GET().build();
//        HttpResponse.BodyHandler<String> response = HttpResponse.BodyHandlers.ofString(StandardCharsets.UTF_8);
//        HttpClient build = HttpClient.newBuilder().followRedirects(HttpClient.Redirect.NORMAL).build();
//        HttpResponse<String> result = build.send(request, HttpResponse.BodyHandlers.ofString(StandardCharsets.UTF_8));
//        System.out.println(result.body());
//        System.out.println(result.statusCode());


        String postdata = "{\"name\":\"luowen\", \"age\": 13}";
        postdata = "name=luowen&age=304";
        HttpRequest.BodyPublisher bodyPublisher = HttpRequest.BodyPublishers.ofString(postdata, StandardCharsets.UTF_8);
        HttpRequest request = HttpRequest.newBuilder(URI.create("http://localhost:8080/test"))
                // .setHeader("content-type", "application/json;charset=utf-8")
                .setHeader("content-type", "application/x-www-form-urlencoded")
                .POST(bodyPublisher).build();

        HttpResponse<String> httpResponse = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(httpResponse.body());


//        CompletableFuture<HttpResponse<String>> completableFuture = HttpClient.newBuilder().followRedirects(HttpClient.Redirect.NORMAL)
//                .cookieHandler(cookieHandler).build().sendAsync(request, response);
//        completableFuture.thenApply(HttpResponse::body).thenAccept(System.out::println);
//        completableFuture.thenApply(HttpResponse::body).thenAccept(System.out::println);
    }

    @Test
    public void md5Test() throws NoSuchAlgorithmException {
        MessageDigest md5 = MessageDigest.getInstance("md5");
        md5.update("luowen".getBytes(StandardCharsets.UTF_8));
        String result = new BigInteger(1, md5.digest()).toString(16);
        System.out.println(result);

    }
}
