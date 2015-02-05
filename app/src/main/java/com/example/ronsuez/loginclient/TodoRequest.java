package com.example.ronsuez.loginclient;


import com.example.ronsuez.loginclient.Api.BaseRequest;
import com.example.ronsuez.loginclient.Api.Key;
import com.example.ronsuez.loginclient.Api.Response;
import com.example.ronsuez.loginclient.Api.ResponseCallback;
import com.example.ronsuez.loginclient.Api.URL;
import com.example.ronsuez.loginclient.Model.Todo;

import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.GET;
import retrofit.http.POST;

/**
 * Based on UserRequest Class by Mariangela Salcedo on 05/08/14.
 *
 */

public class TodoRequest extends BaseRequest {

    /* ***********************************************
     *************** CONSTANTS ***********************
     * ********************************************* */

    private static final String TAG = "TAG_UserRequest";

    /* ***********************************************
     *************** FIELDS **************************
     * ********************************************* */


    /* ***********************************************
     *************** METHODS *************************
     * ********************************************* */

    /**
     *
     * @return
     */
    private static ApiTodo getApiTodo() {
        return getInstanceRestAdapter().create(ApiTodo.class);
    }

    /**
     *
     * @param name
     */
    public static void addTodo(String name, RequestCallback callbacks) {

        getApiTodo().addTodo(name, new ResponseCallback(callbacks));

    }


    public static void getTodos(RequestCallback callbacks) {

        getApiTodo().getTodo( new ResponseCallback(callbacks));

    }

    /* ***********************************************
     *************** INTERFACES **********************
     * ********************************************* */
    /**
     *
     */
    public interface ApiTodo {

        /**
         * @param name
         * @param callback
         */
        @FormUrlEncoded
        @POST(URL.ADD_TODO)
        public void addTodo(
                @Field(Key.TODO_NAME) String name,
                Callback<Response> callback);

        /**
         *
         * @param callback
         */
        @GET(URL.TODOS)
        public void getTodo(Callback<Response> callback);
    }
}