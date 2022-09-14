package com.example.custom_recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements OnItemClick {

    RecyclerView recyclerView_h,/*recyclerView_h1,recyclerView_h2*/recyclerView_v;
    //Horizontal
    UserModel userModel;
    UserAdapter userAdapter;
    List<UserModel> userModelList=new ArrayList<>();

    //Vertical
    GameModel gameModel;
    GameAdapter gameAdapter;
    List<GameModel> gameModelList=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView_h=findViewById(R.id.recycler_h);
      //  recyclerView_h1=findViewById(R.id.);
       // recyclerView_h2=findViewById(R.id.recycler_h2);
        recyclerView_v=findViewById(R.id.recycler_v);

        recyclerView_h.setHasFixedSize(true);
       // recyclerView_h1.setHasFixedSize(true);
       // recyclerView_h2.setHasFixedSize(true);
        recyclerView_v.setHasFixedSize(true);
        //Layout Manger
        recyclerView_h.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
      //  recyclerView_h1.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        //recyclerView_h2.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        recyclerView_v.setLayoutManager(new LinearLayoutManager(this));

        userAdapter=new UserAdapter(getApplicationContext(),userModelList);
        recyclerView_h.setAdapter(userAdapter);
      //  recyclerView_h1.setAdapter(userAdapter);
       // recyclerView_h2.setAdapter(userAdapter);

        //Vertical Adapter
        gameAdapter=new GameAdapter(getApplicationContext(),gameModelList,this);
        recyclerView_v.setAdapter(gameAdapter);

        loadHorizontalMethod();
        loadVerticalMethod();

    }

    private void loadVerticalMethod() {
        gameModel=new GameModel("Cricket","India","11");
        gameModelList.add(gameModel);
        gameModel=new GameModel("Hocky","India","11");
        gameModelList.add(gameModel);
        gameModel=new GameModel("Badminton","India","2");
        gameModelList.add(gameModel);
        gameModel=new GameModel("carrom","India","4");
        gameModelList.add(gameModel);
        gameModel=new GameModel("Football","India","11");
        gameModelList.add(gameModel);
        gameModel=new GameModel("Chess","India ","2");
        gameModelList.add(gameModel);
        gameAdapter.notifyDataSetChanged();
    }


    private void loadHorizontalMethod() {
        userModel=new UserModel(R.drawable.emp2,"Sanjay");
        userModelList.add(userModel);
        userModel=new UserModel(R.drawable.emp2,"Ramkrishna");
        userModelList.add(userModel);
        userModel=new UserModel(R.drawable.emp2,"Sai");
        userModelList.add(userModel);
        userModel=new UserModel(R.drawable.emp2,"Raju");
        userModelList.add(userModel);
        userModel=new UserModel(R.drawable.emp1,"Ruksana");
        userModelList.add(userModel);
        userModel=new UserModel(R.drawable.emp5,"Aishwarya");
        userModelList.add(userModel);

        userAdapter.notifyDataSetChanged();
    }

    @Override
    public void onClick(int position) {

        Toast.makeText(this, ""+gameModelList.get(position).getName(), Toast.LENGTH_SHORT).show();
    }
}