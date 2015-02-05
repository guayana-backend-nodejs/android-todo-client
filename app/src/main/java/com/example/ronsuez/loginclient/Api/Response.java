package com.example.ronsuez.loginclient.Api;

import com.example.ronsuez.loginclient.Api.Key;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Mariangela Salcedo on 05/08/14.
 */
public class Response {
    /* ***********************************************
     *************** CONSTANTS ***********************
     * ********************************************* */

    /* ***********************************************
     *************** FIELDS **************************
     * ********************************************* */
    @SerializedName(Key.RESPONSE_STATUS)
    @Expose
    private Integer status;
    @SerializedName(Key.RESPONSE_RESPONSE)
    @Expose
    private Object response;

    /* ***********************************************
     *************** METHODS *************************
     * ********************************************* */

    public Integer getStatus() {
        return status;
    }

    public Object getResponse() {
        return response;
    }

    @Override
    public String toString() {

        return "Response{" +
                "status=" + status +
                ", response=" + response +
                '}';
    }
}
