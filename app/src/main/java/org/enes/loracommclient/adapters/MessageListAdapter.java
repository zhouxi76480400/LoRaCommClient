package org.enes.loracommclient.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.enes.loracommclient.R;
import org.enes.loracommclient.activities.MessageActivity;

public class MessageListAdapter extends
        RecyclerView.Adapter<MessageListAdapter.MessageListAdapterViewHolder> {


    private MessageListAdapterInterface anInterface;

//    public OnMessageItemClickListener messageItemClickListener;

    private Context ctx;

    public MessageListAdapter(Context context,
                              MessageListAdapterInterface messageListAdapterInterface) {
        super();
        this.ctx = context;
        this.anInterface = messageListAdapterInterface;
        Log.e("testCTX", context.toString());

    }

    @NonNull
    @Override
    public MessageListAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.adapter_message_list,parent,false);

        MessageListAdapterViewHolder viewHolder = new MessageListAdapterViewHolder(view);
        viewHolder.setAdapter(this);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MessageListAdapterViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        if(anInterface != null) {
            return anInterface.getMessageListSize();
        }
        return 0;
    }

    public void onMessageItemClick(int position) {

        Log.e("test", "aaaaaaaaaaaa:" + position);
        MessageActivity.openMessageActivity(ctx);

    }

    static class MessageListAdapterViewHolder extends RecyclerView.ViewHolder implements
            View.OnClickListener {

        public LinearLayout ll_main;

        private MessageListAdapter adapter;

        public MessageListAdapterViewHolder(@NonNull View itemView) {
            super(itemView);
            ll_main = itemView.findViewById(R.id.ll_main);
            ll_main.setOnClickListener(this);

//
        }

        @Override
        public void onClick(View v) {
            if(adapter != null) {
                adapter.onMessageItemClick(getLayoutPosition());
            }
        }

        public void setAdapter(MessageListAdapter messageListAdapter) {
            adapter = messageListAdapter;
        }
    }

    public interface OnMessageItemClickListener {

        public void onMessageItemClick(int position);

    }

    public interface MessageListAdapterInterface {

        public int getMessageListSize();

    }

}
