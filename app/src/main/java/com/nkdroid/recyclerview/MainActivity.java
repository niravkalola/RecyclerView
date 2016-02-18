package com.nkdroid.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView vertical_recycler_view,horizontal_recycler_view;
    private ArrayList<String> horizontalList,verticalList;
    private HorizontalAdapter horizontalAdapter;
    private  VerticalAdapter verticalAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        vertical_recycler_view= (RecyclerView) findViewById(R.id.vertical_recycler_view);
        horizontal_recycler_view= (RecyclerView) findViewById(R.id.horizontal_recycler_view);

        horizontalList=new ArrayList<>();
        horizontalList.add("horizontal 1");
        horizontalList.add("horizontal 2");
        horizontalList.add("horizontal 3");
        horizontalList.add("horizontal 4");
        horizontalList.add("horizontal 5");
        horizontalList.add("horizontal 6");
        horizontalList.add("horizontal 7");
        horizontalList.add("horizontal 8");
        horizontalList.add("horizontal 9");
        horizontalList.add("horizontal 10");


        verticalList=new ArrayList<>();
        verticalList.add("verticallist 1");
        verticalList.add("verticallist 2");
        verticalList.add("verticallist 3");
        verticalList.add("verticallist 4");
        verticalList.add("verticallist 5");
        verticalList.add("verticallist 6");
        verticalList.add("verticallist 7");
        verticalList.add("verticallist 8");
        verticalList.add("verticallist 9");
        verticalList.add("verticallist 10");

        horizontalAdapter=new HorizontalAdapter(horizontalList);
        verticalAdapter=new VerticalAdapter(verticalList);


        LinearLayoutManager verticalLayoutmanager
                = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false);
        vertical_recycler_view.setLayoutManager(verticalLayoutmanager);
//        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
//        vertical_recycler_view.setLayoutManager(mLayoutManager);
        LinearLayoutManager horizontalLayoutManagaer
                = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL, false);
        horizontal_recycler_view.setLayoutManager(horizontalLayoutManagaer);

        vertical_recycler_view.setAdapter(verticalAdapter);
        horizontal_recycler_view.setAdapter(horizontalAdapter);
    }



    public class HorizontalAdapter extends RecyclerView.Adapter<HorizontalAdapter.MyViewHolder> {

        private List<String> horizontalList;

        public class MyViewHolder extends RecyclerView.ViewHolder {
            public TextView txtView;

            public MyViewHolder(View view) {
                super(view);
                txtView = (TextView) view.findViewById(R.id.txtView);

            }
        }


        public HorizontalAdapter(List<String> horizontalList) {
            this.horizontalList = horizontalList;
        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.horizontal_item_view, parent, false);

            return new MyViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(final MyViewHolder holder, final int position) {
            holder.txtView.setText(horizontalList.get(position));

            holder.txtView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(MainActivity.this,holder.txtView.getText().toString(),Toast.LENGTH_SHORT).show();
                }
            });
        }

        @Override
        public int getItemCount() {
            return horizontalList.size();
        }
    }



    public class VerticalAdapter extends RecyclerView.Adapter<VerticalAdapter.MyViewHolder> {

        private List<String> verticalList;

        public class MyViewHolder extends RecyclerView.ViewHolder {
            public TextView txtView;

            public MyViewHolder(View view) {
                super(view);
                txtView = (TextView) view.findViewById(R.id.txtView);

            }
        }


        public VerticalAdapter(List<String> verticalList) {
            this.verticalList = verticalList;
        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.vertical_item_view, parent, false);

            return new MyViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(final MyViewHolder holder, final int position) {

            holder.txtView.setText(verticalList.get(position));
            holder.txtView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Toast.makeText(MainActivity.this,holder.txtView.getText().toString(),Toast.LENGTH_SHORT).show();
                }
            });
        }

        @Override
        public int getItemCount() {
            return verticalList.size();
        }
    }
}
