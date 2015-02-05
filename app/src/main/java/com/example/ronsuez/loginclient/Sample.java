/* 
 * Copyright Vilna LTD 2014
 *
 * */
package com.example.ronsuez.loginclient;

import android.util.Log;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.mime.TypedByteArray;

/**
 * Created by Mariangela Salcedo on 22/05/14.
 */
public class Sample {

    /* ***********************************************
     *************** CONSTANTS ***********************
     * ********************************************* */
    private static final String TAG = "TAG_Sample";

    /* ***********************************************
     *************** FIELDS **************************
     * ********************************************* */

    /* ***********************************************
     *************** METHODS *************************
     * ********************************************* */

    // subir la imagen con TypedByteArray
    static class FileTypedByteArray {
        TypedByteArray file;
    }
//    interface SaveFileTypedByteArray {
//        @POST("/save_picture.php")
//        public void saveFile(@Body FileTypedByteArray body, Callback<Response> callback);
//    }

//    public static void uploadFile(URI uri) throws IOException {
//        RestAdapter adapter  = new RestAdapter.Builder()
//                .setEndpoint("http://192.168.0.104/tests")
//                .build();
//
//        FileTypedByteArray fileBody = new FileTypedByteArray();
//        fileBody.file = new TypedByteArray(
//                "image/*", IOUtils.toByteArray(uri));
//
//        SaveFileTypedByteArray saveFile = adapter.create(SaveFileTypedByteArray.class);
//        saveFile.saveFile(fileBody, callback);
//    }

    /**
     *
     *
     *
     *
     *
     *
     */
    public static void uploadFile(String base64) {

        RestAdapter adapter  = new RestAdapter.Builder()
                .setEndpoint("http://192.168.0.104")
                .build();

        SaveFileBase64 saveFileBase64 = adapter.create(SaveFileBase64.class);
        saveFileBase64.saveFile(base64, callback);
    }
    interface SaveFileBase64 {
        @FormUrlEncoded
        @POST("/tests/save_file.php")
        public void saveFile(@Field("base64") String base64, Callback<Response> callback);
    }



    /**
     *
     *
     *
     *
     *
     */
    static class User {
        String name;
        String age;
        String gender;

        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    ", age='" + age + '\'' +
                    ", gender='" + gender + '\'' +
                    '}';
        }
    }

    interface GetUser {
        @GET("/tests/getuser.php")
        public void getUser(Callback<User> callback);
    }

    public static void getUser() {

        RestAdapter adapter = new RestAdapter.Builder()
                .setEndpoint("http://192.168.0.104")
                .build();

        adapter.create(GetUser.class).getUser(new Callback<User>() {
            @Override
            public void success(User user, retrofit.client.Response response) {
                Log.d(TAG, user.toString());
            }

            @Override
            public void failure(RetrofitError retrofitError) {
                Log.e(TAG, retrofitError.toString());
            }
        });

    }


    /**
     *
     *
     *
     *
     *
     */
    static Callback<Response> callback = new Callback<Response>() {
        @Override
        public void success(Response response, retrofit.client.Response response2) {
            Log.d(TAG, response.message);
        }

        @Override
        public void failure(RetrofitError retrofitError) {
            Log.d(TAG, retrofitError.toString());
        }
    };
    // respuesta
    static class Response {
        boolean success;
        String message;

        @Override
        public String toString() {
            return "Response{" +
                    "success=" + success +
                    ", message='" + message + '\'' +
                    '}';
        }
    }

}
