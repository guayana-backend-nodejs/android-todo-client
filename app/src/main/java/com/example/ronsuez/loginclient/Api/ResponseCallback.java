package com.example.ronsuez.loginclient.Api;

import android.util.Log;

import com.example.ronsuez.loginclient.Api.BaseRequest;
import com.example.ronsuez.loginclient.Api.Response;

import retrofit.Callback;
import retrofit.RetrofitError;

/**
 * Created by Mariangela Salcedo on 16/08/14.
 */
public class ResponseCallback implements Callback<Response> {
    /* ***********************************************
     *************** CONSTANTS ***********************
     * ********************************************* */

    private static final String TAG = "TAG_ResponseCallback";

    /* ***********************************************
     *************** FIELDS **************************
     * ********************************************* */

    /** */
    private BaseRequest.RequestCallback mRequestCallbacks;

    /* ***********************************************
     *************** METHODS *************************
     * ********************************************* */

    public ResponseCallback(BaseRequest.RequestCallback requestCallbacks) {
        mRequestCallbacks = requestCallbacks;
    }

    @Override
    public void success(Response response, retrofit.client.Response retrofitResponse) {
        Log.i(TAG, "success");

        if (retrofitResponse != null) {
            Log.i(TAG, retrofitResponse.getReason());
            Log.i(TAG, retrofitResponse.toString());
        }

        mRequestCallbacks.onSuccess(response);
    }

    @Override
    public void failure(RetrofitError error) {
        Log.e(TAG, "failure");

        if (error != null) {
//            Log.e(TAG, error.getLocalizedMessage());
            Log.e(TAG, error.toString());
            error.printStackTrace();
        }

        mRequestCallbacks.onError(error);
    }
}

