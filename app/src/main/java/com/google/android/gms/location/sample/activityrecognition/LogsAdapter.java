package com.google.android.gms.location.sample.activityrecognition;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class LogsAdapter extends RecyclerView.Adapter<LogsAdapter.ContactViewHolder> {

    private List<LogsInfo> contactList;

    public LogsAdapter(List<LogsInfo> contactList) {
        this.contactList = contactList;
    }


    @Override
    public int getItemCount() {
        return contactList.size();
    }

    @Override
    public void onBindViewHolder(ContactViewHolder contactViewHolder, int i) {
        LogsInfo ci = contactList.get(i);
        contactViewHolder.Carbon.setText(ci.Carbon_FootPrint);
        contactViewHolder.Activity.setText(ci.Activity);
        contactViewHolder.Distance.setText(ci.Distance);
        contactViewHolder.Date.setText(ci.Date);
    }

    @Override
    public ContactViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.
                from(viewGroup.getContext()).
                inflate(R.layout.card_layout, viewGroup, false);

        return new ContactViewHolder(itemView);
    }

    public static class ContactViewHolder extends RecyclerView.ViewHolder {

        protected TextView Carbon;
        protected TextView Distance;
        protected TextView Activity;
        protected TextView Date;

        public ContactViewHolder(View v) {
            super(v);
            Carbon =  (TextView) v.findViewById(R.id.Carbon);
            Distance = (TextView)  v.findViewById(R.id.Distance);
            Activity = (TextView)  v.findViewById(R.id.Activity);
            Date = (TextView) v.findViewById(R.id.Date);
        }
    }
}