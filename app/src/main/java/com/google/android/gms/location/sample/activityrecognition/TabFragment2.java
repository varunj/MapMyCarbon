package com.google.android.gms.location.sample.activityrecognition;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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

public class TabFragment2 extends Fragment implements View.OnClickListener {

    private Button mSendButton;
    private EditText mSendTo, mSendAmount;
    private TextView mCreditAvail;
    private int CreditAvailable;
    public String username, password;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab_fragment_2, container, false);
        username=getActivity().getIntent().getExtras().getString("username");
        password=getActivity().getIntent().getExtras().getString("password");
        mSendButton = (Button) view.findViewById(R.id.sendbutton);
        mSendTo = (EditText) view.findViewById(R.id.edit_sendto);
        mSendAmount = (EditText) view.findViewById(R.id.edit_amount);
        mCreditAvail = (TextView) view.findViewById(R.id.creditview);
        mSendButton.setOnClickListener(this);
        //new RequestTask().execute("http://192.168.2.0:4000/viewcredit/"+username+"/"+password);


//        return inflater.inflate(R.layout.tab_fragment_2, container, false);
        return view;
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.sendbutton)
        {
            if(mSendTo.length()==0 && mSendAmount.length()==0)
            {
                if(mSendTo.length()==0)
                {
                    Toast.makeText(getActivity(),"Please enter username", Toast.LENGTH_LONG).show();
                }
                else if(mSendAmount.length()==0)
                {
                    Toast.makeText(getActivity(),"Please enter amount", Toast.LENGTH_LONG).show();
                }
            }
            else
            {
                if(Integer.parseInt(String.valueOf(mSendAmount.getText()))>CreditAvailable)
                    Toast.makeText(getActivity(),"Please enter amount less than your credits", Toast.LENGTH_LONG).show();
                else
                    new RequestTask2().execute("http://192.168.2.0:4000/transfercredit/"+
                            username+"/"+password+"/"+
                            String.valueOf(mSendAmount.getText())+"/"+String.valueOf(mSendTo.getText()));
            }
            new RequestTask().execute("http://192.168.2.0:4000/viewcredit/"+username+"/"+password);
        }
    }

    class RequestTask extends AsyncTask<String, String, String> {

        ProgressDialog dialog = new ProgressDialog(getActivity());

        @Override
        protected void onPreExecute() {
            // Show Progress dialog
            dialog.setMessage("Checking Server..");
            dialog.show();
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
            dialog.dismiss();
            super.onPostExecute(result);
            //Do anything with response..
            JSONObject jObject;
            String aJsonString = null;
            try {
                jObject = new JSONObject(result);
                aJsonString = jObject.getString("credits");
            } catch (JSONException e) {
                e.printStackTrace();
            }
            CreditAvailable= Integer.parseInt(aJsonString);
            mCreditAvail.setText("Credits : "+aJsonString);
        }
    }

    class RequestTask2 extends AsyncTask<String, String, String> {

        ProgressDialog dialog = new ProgressDialog(getActivity());

        @Override
        protected void onPreExecute() {
            // Show Progress dialog
            dialog.setMessage("Checking Server..");
            dialog.show();
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
            dialog.dismiss();
            super.onPostExecute(result);
            Log.d("result", result);
            if(result.equals("OK"))
                Toast.makeText(getActivity(),"Transfer Successful", Toast.LENGTH_LONG).show();
            else
                Toast.makeText(getActivity(),"Error", Toast.LENGTH_LONG).show();
            mSendTo.setText("");
            mSendAmount.setText("");
        }
    }
}