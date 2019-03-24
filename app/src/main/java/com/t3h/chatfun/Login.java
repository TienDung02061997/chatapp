package com.t3h.chatfun;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class Login extends AppCompatActivity implements View.OnClickListener {
    private EditText edEmail,edtPassword;
    private Button btn_login,btn_register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        edEmail= (EditText) findViewById(R.id.edEmail);
        edtPassword= (EditText) findViewById(R.id.edPassword);
        btn_login= (Button) findViewById(R.id.btn_login);
        btn_register= (Button) findViewById(R.id.btn_login);
        btn_login.setOnClickListener(this);
        btn_register.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
         switch (v.getId()){
            case R.id.btn_login:
             String email=  edEmail.getText().toString();
           String passowrd=     edtPassword.getText().toString();
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("http://192.168.1.150:8080")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                //localhost:8080/api/user/login ten phuong thuc
                Api api =retrofit.create(Api.class); // ten class lay du lieu
                LoginRequest loginRequest= new LoginRequest();
                loginRequest.setPassword(passowrd);
                loginRequest.setUsername(email);
                api.login(loginRequest)
                        .enqueue(new Callback<LoginRequest>() {
                            @Override
                            public void onResponse(Call<LoginRequest> call, Response<LoginRequest> response) {
                                System.out.println("result :"+response.body());
                                OpenFriend();
                            }

                            @Override
                            public void onFailure(Call<LoginRequest> call, Throwable t) {
                                System.out.println("result :" +t.getMessage());
                            }
                        });

                break;

         }
    }
    private void OpenFriend(){
        Intent intent=new Intent();
        intent.setClass(this,FriendActivity.class);
        startActivity(intent);
    }
}
