package com.example.ronsuez.loginclient.Api;

import retrofit.RestAdapter;
import retrofit.RetrofitError;

/**
 * Created by Mariangela Salcedo on 15/08/14.
 */
public class BaseRequest {
    /* ***********************************************
     *************** CONSTANTS ***********************
     * ********************************************* */

    private static final String TAG = "TAG_BaseRequest";

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
    protected static RestAdapter getInstanceRestAdapter(){
        return new RestAdapter.Builder()
                .setEndpoint(URL.API_BASE)
                .build();
    }

    /* ***********************************************
     *************** INTERFACES **********************
     * ********************************************* */

    /**
     *
     */
    public interface RequestCallback {
       public void onSuccess(Response response);
       public void onError(RetrofitError error);
    }
}
