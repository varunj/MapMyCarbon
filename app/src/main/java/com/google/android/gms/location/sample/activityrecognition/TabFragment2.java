package com.google.android.gms.location.sample.activityrecognition;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class TabFragment2 extends Fragment {

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
//        mSendButton = (Button) view.findViewById(R.id.sendbutton);
//        mSendTo = (EditText) view.findViewById(R.id.edit_sendto);
//        mSendAmount = (EditText) view.findViewById(R.id.edit_amount);
        mCreditAvail = (TextView) view.findViewById(R.id.creditview);
        //new RequestTask().execute("http://192.168.2.0:4000/viewcredit/"+username+"/"+password);


//        return inflater.inflate(R.layout.tab_fragment_2, container, false);
        return view;
    }

//    @Override
//    public void onClick(View v) {
//        if(v.getId()==R.id.sendbutton)
//        {
//            if(mSendTo.length()==0 && mSendAmount.length()==0)
//            {
//                if(mSendTo.length()==0)
//                {
//                    Toast.makeText(getActivity(),"Please enter username", Toast.LENGTH_LONG).show();
//                }
//                else if(mSendAmount.length()==0)
//                {
//                    Toast.makeText(getActivity(),"Please enter amount", Toast.LENGTH_LONG).show();
//                }
//            }
//            else
//            {
//                if(Integer.parseInt(String.valueOf(mSendAmount.getText()))>CreditAvailable)
//                    Toast.makeText(getActivity(),"Please enter amount less than your credits", Toast.LENGTH_LONG).show();
////                else
////                    new RequestTask2().execute("http://192.168.2.0:4000/transfercredit/"+
////                            username+"/"+password+"/"+
////                            String.valueOf(mSendAmount.getText())+"/"+String.valueOf(mSendTo.getText()));
//            }
////            new RequestTask().execute("http://192.168.2.0:4000/viewcredit/"+username+"/"+password);
//        }
//    }
}