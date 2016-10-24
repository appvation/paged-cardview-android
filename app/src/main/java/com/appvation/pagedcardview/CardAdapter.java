/*
 * CardAdapter.java
 * PagedCardView
 *
 * Appvation Pty Ltd
 * 202/147 Pirie Street
 * ADELAIDE SA 5000
 * w: www.appvation.com
 * p: +61 8 7200 5577
 *
 * Copyright © 2016 Appvation Pty. Ltd. All rights reserved.
 */

package com.appvation.pagedcardview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

class CardAdapter extends RecyclerView.Adapter<CardAdapter.ViewHolder> {

    private Context context;
    private List<LocationInformation> items;


    public CardAdapter(Context context) {
        this.context = context;
        this.items = new ArrayList<>();
    }

    public void setItems(List<LocationInformation> items) {
        this.items = items;
        notifyDataSetChanged();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView txtTitle;
        private TextView txtCaption;

        public ViewHolder(View itemView) {
            super(itemView);

            this.txtTitle = (TextView)itemView.findViewById(R.id.text_title);
            this.txtCaption = (TextView)itemView.findViewById(R.id.text_caption);
        }

        public void bind(LocationInformation locationInformation) {
            this.txtTitle.setText(locationInformation.getName());
            this.txtCaption.setText(locationInformation.getAddress());
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View cardView = LayoutInflater.from(this.context).inflate(R.layout.item_card, parent, false);
        return new ViewHolder(cardView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bind(this.items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }


}
