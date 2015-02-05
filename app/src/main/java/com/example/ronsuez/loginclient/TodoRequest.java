package com.example.ronsuez.loginclient;


import com.example.ronsuez.loginclient.Api.BaseRequest;
import com.example.ronsuez.loginclient.Api.Key;
import com.example.ronsuez.loginclient.Api.Response;
import com.example.ronsuez.loginclient.Api.ResponseCallback;
import com.example.ronsuez.loginclient.Api.URL;

import retrofit.Callback;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
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
    public static void a(String name, RequestCallback callbacks) {

        getApiTodo().addTodo(name, new ResponseCallback(callbacks));
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
    }
}