package com.airmoll.easymap;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.smarteist.autoimageslider.SliderViewAdapter;

public class SliderAdapter extends SliderViewAdapter<SliderAdapter.SliderHolder> {

    private String[] data;

    public SliderAdapter(String[] data) {
        this.data = data;
    }

    @Override
    public SliderHolder onCreateViewHolder(ViewGroup parent) {
        return new SliderHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.slider_card, parent, false));
    }

    @Override
    public void onBindViewHolder(SliderHolder viewHolder, int position) {

        viewHolder.textView.setText(data[position]);
    }

    @Override
    public int getCount() {
        return data.length;
    }

    public class SliderHolder extends SliderViewAdapter.ViewHolder
    {

        TextView textView;
        public SliderHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.slider_text);
        }
    }
}
