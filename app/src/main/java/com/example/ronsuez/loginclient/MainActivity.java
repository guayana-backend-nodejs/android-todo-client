package com.example.ronsuez.loginclient;

import android.content.ClipData;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Message;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ronsuez.loginclient.Api.BaseRequest;
import com.example.ronsuez.loginclient.Api.Status;
import com.example.ronsuez.loginclient.Api.URL;
import com.example.ronsuez.loginclient.Helpers.TodoListViewAdapter;
import com.example.ronsuez.loginclient.Model.Todo;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.InjectViews;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;


public class MainActivity extends ActionBarActivity implements BaseRequest.RequestCallback, TodoListViewAdapter.OnClick {

    private static final String TAG = "todos_response";

    @InjectView(R.id.todoListView)
    ListView mTodosListView;

    TodoListViewAdapter mTodoAdapter;

    ArrayList<Todo> mTodoList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
        mTodoList = new ArrayList<>();
        populateListView();

    }

    private void populateListView() {
        TodoRequest.getTodos(this);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.new_todo) {
            Intent intent = new Intent(MainActivity.this, todoForm.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onSuccess(com.example.ronsuez.loginclient.Api.Response response) {
        Log.i("todos response", response.getResponse().toString());

        Log.i("Response:", response.getStatus().toString());




        switch (response.getStatus()){

           case 200:
               Gson gson = new Gson();

               String json = gson.toJson(response.getResponse());


               Type listType = new TypeToken<List<Todo>>(){}.getType();


               mTodoList = new ArrayList<Todo>((List<Todo>) gson.fromJson(json, listType));

               Log.d(TAG +  " SIZE -->", mTodoList.size()+ "");

               setAdapter(mTodoList);
                break;

          default:
              Log.i("Default Case", response.getStatus().toString());
       }
    }

    private void setAdapter(ArrayList<Todo> todos) {

        try{
            if (mTodoAdapter==null)
                mTodoAdapter = new TodoListViewAdapter(todos, this, this);
            else
                mTodoAdapter.addItems(new ArrayList<Todo>(todos));

            mTodoList = new ArrayList<Todo>(todos);
            mTodosListView.setAdapter(mTodoAdapter);

        } catch (Exception e){
            Log.e(TAG,"Error",e);
        }

    }

    @Override
    public void onError(RetrofitError error) {
        Log.e("todos response", error.toString());
    }

    @Override
    public void onClick(int position) {

        String message = "You clicked # " + position +
                ", which is string: " + mTodoList.get(position).getName();

        Toast.makeText(MainActivity.this, message, Toast.LENGTH_LONG).show();
    }
}
