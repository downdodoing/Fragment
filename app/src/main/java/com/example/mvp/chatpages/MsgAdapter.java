package com.example.mvp.chatpages;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class MsgAdapter extends RecyclerView.Adapter<MsgAdapter.ViewHolder> {
    private List<Msg> mMsgList;

    public MsgAdapter(List<Msg> mMsgList) {
        this.mMsgList = mMsgList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int position) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.msg_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        Msg msg = mMsgList.get(position);
        if (msg.getType() == msg.TYPE_RECEIVED) {
            setVisible(viewHolder, View.VISIBLE, View.GONE);
            viewHolder.leftMsg.setText(msg.getContent());
        } else {
            setVisible(viewHolder, View.GONE, View.VISIBLE);
            viewHolder.rightMsg.setText(msg.getContent());
        }
    }

    public void setVisible(ViewHolder viewHolder, int leftLayout, int rightLayout) {
        viewHolder.leftLayout.setVisibility(leftLayout);
        viewHolder.rightLayout.setVisibility(rightLayout);
    }

    @Override
    public int getItemCount() {
        return mMsgList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        LinearLayout leftLayout, rightLayout;
        TextView leftMsg, rightMsg;

        public ViewHolder(View itemView) {
            super(itemView);
            leftLayout = (LinearLayout) itemView.findViewById(R.id.left_layout);
            rightLayout = (LinearLayout) itemView.findViewById(R.id.right_layout);

            leftMsg = (TextView) itemView.findViewById(R.id.left_msg);
            rightMsg = (TextView) itemView.findViewById(R.id.right_msg);
        }
    }
}
