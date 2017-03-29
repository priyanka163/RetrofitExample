package com.example.next.githubsample;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.next.githubsample.models.GithubRepoModel;

import java.util.ArrayList;

/**
 * Created by next on 10/3/17.
 */
public class ListAdapter extends BaseAdapter {



    Context context;
    private ArrayList<GithubRepoModel> modelArrayList;
    LayoutInflater inflate;

    public ListAdapter(Context context,ArrayList<GithubRepoModel>  modelArrayList) {
        this.context = context;
        this.modelArrayList = modelArrayList;
        inflate=LayoutInflater.from(context);

        Log.i("constructor", "ListAdapter: "+inflate);
    }

    private   class ViewHolder{
        TextView mTextviewAuthor,mTextviewcommit;

        public ViewHolder(View holder) {
            mTextviewAuthor= (TextView) holder.findViewById(R.id.author);
            mTextviewcommit= (TextView) holder.findViewById(R.id.commit);
        }
    }

    @Override
    public int getCount() {
        Log.d("adapterclass", "getCount: "+modelArrayList.size());
        return modelArrayList.size();

    }

    @Override
    public Object getItem(int position) {
        Log.i("getItem", "getItem: "+modelArrayList.get(position));
        return modelArrayList.get(position);

    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;


        if (convertView == null) {

            convertView = inflate.inflate(R.layout.listitems, parent, false);
            holder = new ViewHolder(convertView);

            convertView.setTag(holder);


        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        modelArrayList.get(position).getSha();
      //  modelArrayList.get(position).getmEmail();
        Log.i("adapter", "getView: "+ modelArrayList.get(position).getSha());
        Log.i("maindata", "getView: "+modelArrayList.get(position).getCommit().getMessage());
        Log.i("maindata", "getView: "+modelArrayList.get(position).getCommit().getCommitter().getName());


        holder.mTextviewAuthor.setText(modelArrayList.get(position).getCommit().getMessage());
        holder.mTextviewcommit.setText(modelArrayList.get(position).getCommit().getCommitter().getName());
        return convertView;
    }
}