package com.t3h.chatfun;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface Api {

    @POST("api/user/login")
    Call<LoginRequest> login(@Body LoginRequest request);
    @GET("api/user/friends")
    Call<LoginRequest> getUser(@Header("Authorization") String authorization);
    @GET("api/friend/others")
    Call<LoginRequest> getOtherFriend(@Header("Authorization") String authorization);

}
