package com.app.notesculture.view.api;
import com.app.notesculture.view.utills.Const;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import java.io.IOException;
import okhttp3.Credentials;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    private static Retrofit retrofit = null;
    private static String credentials=null;

 public static Retrofit getClientNew(){
     OkHttpClient.Builder clientBuilder = new OkHttpClient.Builder();
     credentials=Credentials.basic(Const.USER, Const.PASSWORD);


     /*//Basic Auth
     if (!TextUtils.isEmpty(username)
             && !TextUtils.isEmpty(password)) {
         authToken = Credentials.basic(username, password);
     }
*/
     //Create a new Interceptor.
     Interceptor headerAuthorizationInterceptor = new Interceptor() {
         @Override
         public okhttp3.Response intercept(Chain chain) throws IOException {
             okhttp3.Request request = chain.request();
             Headers headers = request.headers().newBuilder().add("Authorization", credentials).build();
             request = request.newBuilder().headers(headers).build();
             return chain.proceed(request);
         }
     };

     //Add the interceptor to the client builder.
     clientBuilder.addInterceptor(headerAuthorizationInterceptor);

     return new Retrofit.Builder().baseUrl(Const.BASE_URL)
             .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
             .addConverterFactory(GsonConverterFactory.create())
             .build();
 }

    //For request with header
    public static Retrofit getClientWithHeader(){


        credentials = Credentials.basic(Const.USER, Const.PASSWORD);
        OkHttpClient.Builder clientBuilder = new OkHttpClient.Builder();

        //Create a new Interceptor.
        Interceptor headerAuthorizationInterceptor = new Interceptor() {
            @Override
            public okhttp3.Response intercept(Chain chain) throws IOException {
                okhttp3.Request request = chain.request();
                Headers.Builder builder = new Headers.Builder();
                builder.add("Authorization", credentials);
                builder.add("Accept", "application/json");
                builder.add("api_key", Const.API_KEY);
                Headers headers = request.headers().newBuilder().add("api_key", Const.API_KEY).build();
                request = request.newBuilder().headers(headers).build();
                return chain.proceed(request);
            }
        };
        //Add the interceptor to the client builder.
        clientBuilder.addInterceptor(headerAuthorizationInterceptor);

        return new Retrofit.Builder().baseUrl(Const.BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    //For request without header

    public static Retrofit getClient() {
        if (retrofit==null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(Const.BASE_URL)

                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }


}
