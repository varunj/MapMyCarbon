package com.google.android.gms.location.sample.activityrecognition;

/**
 * Created by siddharthsingh on 28/04/16.
 */

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.IOException;



public class Login extends Activity implements View.OnClickListener {

    private EditText mEmailLogin;
    private EditText mPasswordLogin;
    private TextView _signupLink;
    private Button mLoginbtn;
    private String success_login="false";
    private String result = "";

    public JSONObject json;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mEmailLogin = (EditText) findViewById(R.id.email_login);
        mPasswordLogin = (EditText) findViewById(R.id.password_login);
        mLoginbtn = (Button) findViewById(R.id.btn_login);
        _signupLink = (TextView) findViewById(R.id.link_login);
        mLoginbtn.setOnClickListener(this);
        _signupLink=(TextView)findViewById(R.id.link_login);

    }
    public void signlink(View v)
    {
//        Intent i= new Intent(Login.this, SignUp.class);
//        startActivity(i);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_login:
                // call AsynTask to perform network operation on separate thread
//                ProgressDialog dialog = new ProgressDialog(Login.this);
//                dialog.setMessage("Authenticating..");
//                dialog.show();
                new RequestTask().execute("http://192.168.2.0:4000/viewcredit/"+mEmailLogin.getText().toString()+"/"+mPasswordLogin.getText().toString());
                break;


        }
    }
    class RequestTask extends AsyncTask<String, String, String> {

//        ProgressDialog dialog = new ProgressDialog(getApplicationContext());

        @Override
        protected void onPreExecute() {
            // Show Progress dialog
//            dialog.setMessage("Checking Server..");
//            dialog.show();
        }

        @Override
        protected String doInBackground(String... uri) {
            HttpClient httpclient = new DefaultHttpClient();
            HttpResponse response;
            String responseString = null;
            try {
                response = httpclient.execute(new HttpGet(uri[0]));
                StatusLine statusLine = response.getStatusLine();
                Log.d("serversentdata", statusLine.toString());
                if (statusLine.getStatusCode() == HttpStatus.SC_OK) {
                    ByteArrayOutputStream out = new ByteArrayOutputStream();
                    response.getEntity().writeTo(out);
                    responseString = out.toString();
                    out.close();
                } else {
                    //Closes the connection.
                    response.getEntity().getContent().close();
                    throw new IOException(statusLine.getReasonPhrase());
                }
            } catch (ClientProtocolException e) {
                //TODO Handle problems..
            } catch (IOException e) {
                //TODO Handle problems..
            }
            return responseString;
        }
        @Override
        protected void onPostExecute(String result) {
//            dialog.dismiss();
            super.onPostExecute(result);
            JSONObject jObject;
            String aJsonString = null;
            try {
                jObject = new JSONObject(result);
                aJsonString = jObject.getString("login");
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if(aJsonString.equals("true"))
            {
                Intent i = new Intent(getApplicationContext(), StartActivity.class);
                i.putExtra("username", mEmailLogin.getText().toString());
                i.putExtra("password", mPasswordLogin.getText().toString());
                startActivity(i);
                finish();
            }
        }
    }

}
