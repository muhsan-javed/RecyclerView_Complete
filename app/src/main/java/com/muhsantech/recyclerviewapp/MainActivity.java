package com.muhsantech.recyclerviewapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.muhsantech.recyclerviewapp.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    ArrayList<ContactModel> arrContact = new ArrayList<>();
    RecyclerContactAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


       ///binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));

//        ContactModel mode = new ContactModel(R.drawable.book1,"Mushsan", "03083227352");
        arrContact.add(new ContactModel(R.drawable.book1,"Muhsan Javed", "03083227352"));
        arrContact.add(new ContactModel(R.drawable.book2,"Tahmoor Ali", "035154842154"));
        arrContact.add(new ContactModel(R.drawable.book3,"Uziar Ali", "03548413465465"));
        arrContact.add(new ContactModel(R.drawable.book4,"Sahid khan", "03056412164"));
        arrContact.add(new ContactModel(R.drawable.book5,"Rahid khan", "03085627352"));
        arrContact.add(new ContactModel(R.drawable.book6,"Ali khan", "03576567352"));
        arrContact.add(new ContactModel(R.drawable.book7,"Haider Ali", "035254546854"));
        arrContact.add(new ContactModel(R.drawable.book8,"Khan ali", "03045481684"));
        arrContact.add(new ContactModel(R.drawable.book9,"Khalid", "032154854654"));
        arrContact.add(new ContactModel(R.drawable.book1,"Muhsan Javed", "03083227352"));
        arrContact.add(new ContactModel(R.drawable.book2,"Tahmoor Ali", "035154842154"));
        arrContact.add(new ContactModel(R.drawable.book3,"Uziar Ali", "03548413465465"));
        arrContact.add(new ContactModel(R.drawable.book4,"Sahid khan", "03056412164"));
        arrContact.add(new ContactModel(R.drawable.book5,"Rahid khan", "03085627352"));
        arrContact.add(new ContactModel(R.drawable.book6,"Ali khan", "03576567352"));
        arrContact.add(new ContactModel(R.drawable.book7,"Haider Ali", "035254546854"));
        arrContact.add(new ContactModel(R.drawable.book8,"Khan ali", "03045481684"));
        arrContact.add(new ContactModel(R.drawable.book9,"Khalid", "032154854654"));
        arrContact.add(new ContactModel(R.drawable.book1,"Muhsan Javed", "03083227352"));
        arrContact.add(new ContactModel(R.drawable.book2,"Tahmoor Ali", "035154842154"));
        arrContact.add(new ContactModel(R.drawable.book3,"Uziar Ali", "03548413465465"));
        arrContact.add(new ContactModel(R.drawable.book4,"Sahid khan", "03056412164"));
        arrContact.add(new ContactModel(R.drawable.book5,"Rahid khan", "03085627352"));
        arrContact.add(new ContactModel(R.drawable.book6,"Ali khan", "03576567352"));
        arrContact.add(new ContactModel(R.drawable.book7,"Haider Ali", "035254546854"));
        arrContact.add(new ContactModel(R.drawable.book8,"Khan ali", "03045481684"));
        arrContact.add(new ContactModel(R.drawable.book9,"Khalid", "032154854654"));


        LinearLayoutManager manager = new LinearLayoutManager(this);
        binding.recyclerView.setLayoutManager(manager);

        adapter = new RecyclerContactAdapter(this,arrContact);
        binding.recyclerView.setAdapter(adapter);


        binding.btnOpenDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Dialog dialog = new Dialog(MainActivity.this);
                dialog.setContentView(R.layout.add_update_lay);

                EditText edName = dialog.findViewById(R.id.edName);
                EditText edNumber = dialog.findViewById(R.id.edNumber);
                Button btnAction = dialog.findViewById(R.id.btnAction);

                btnAction.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        String name = "", number = "";

                        if (!edName.getText().toString().equals("")) {
                             name = edName.getText().toString();
                        }else {
                            Toast.makeText(getApplicationContext(), "Please Enter Contact Name", Toast.LENGTH_SHORT).show();
                        }
                        if (!edNumber.getText().toString().equals("")){
                             number = edNumber.getText().toString();
                        }else {
                            Toast.makeText(getApplicationContext(), "Please Enter Contact Number ", Toast.LENGTH_SHORT).show();
                        }

//                        if (name.equals("") || number.equals("")){
//                            Toast.makeText(getApplicationContext(), "Please Enter Contact Name or Number", Toast.LENGTH_SHORT).show();
//                        }

                        arrContact.add(new ContactModel(R.drawable.book1,name,number));
                        adapter.notifyItemInserted(arrContact.size()-1);

                        binding.recyclerView.scrollToPosition(arrContact.size()-1);

                        dialog.dismiss();

                    }
                });
                dialog.show();
            }
        });


    }
}