package xyz.doikki.dkplayer.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import xyz.doikki.dkplayer.R;
import xyz.doikki.dkplayer.bean.VideoBeanDk;
import xyz.doikki.dkplayer.adapter.listener.OnItemChildClickListenerDk;
import xyz.doikki.videocontroller.component.PrepareView;

import java.util.List;

public class VideoListViewAdapterDk extends BaseAdapter {

    private List<VideoBeanDk> videos;

    private OnItemChildClickListenerDk mOnItemChildClickListener;

    private ViewGroup mListView;

    public VideoListViewAdapterDk(List<VideoBeanDk> videos) {
        this.videos = videos;
    }

    @Override
    public int getCount() {
        return videos.size();
    }

    @Override
    public Object getItem(int position) {
        return videos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        mListView = parent;
        ViewHolder viewHolder;
        VideoBeanDk videoBean = videos.get(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_videodk, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Glide.with(viewHolder.mThumb.getContext())
                .load(videoBean.getThumb())
                .placeholder(android.R.color.darker_gray)
                .into(viewHolder.mThumb);

        viewHolder.mTitle.setText(videoBean.getTitle());

        viewHolder.mPosition = position;

        return convertView;
    }


    public class ViewHolder implements View.OnClickListener {

        public int mPosition;
        public FrameLayout mPlayerContainer;
        public TextView mTitle;
        public ImageView mThumb;
        public PrepareView mPrepareView;

        ViewHolder(View itemView) {
            mPlayerContainer = itemView.findViewById(R.id.player_container);
            mTitle = itemView.findViewById(R.id.tv_title);
            mPrepareView = itemView.findViewById(R.id.prepare_view);
            mThumb = mPrepareView.findViewById(xyz.doikki.videocontroller.R.id.thumb);
            mPlayerContainer.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (mOnItemChildClickListener != null) {
                mOnItemChildClickListener.onItemChildClick(mPosition);
            }
        }
    }

    public void setOnItemChildClickListener(OnItemChildClickListenerDk onItemChildClickListener) {
        mOnItemChildClickListener = onItemChildClickListener;
    }

    public View getItemView(int position) {
        int count = mListView.getChildCount();
        for (int i = 0; i < count; i++){
            View itemView = mListView.getChildAt(i);
            ViewHolder viewHolder = (ViewHolder) itemView.getTag();
            if (position == viewHolder.mPosition) {
                return itemView;
            }
        }
        return null;
    }
}