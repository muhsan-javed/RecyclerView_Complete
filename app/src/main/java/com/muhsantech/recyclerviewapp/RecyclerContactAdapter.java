package com.muhsantech.recyclerviewapp;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerContactAdapter extends RecyclerView.Adapter<RecyclerContactAdapter.ViewHolder> {

    Context context;
    ArrayList<ContactModel> arrContact;
    private int lastPosition = -1;

    RecyclerContactAdapter(Context context, ArrayList<ContactModel> arrContact){
        this.context = context;
        this.arrContact = arrContact;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.contact_row,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        ///holder.img.setImageResource(arrContact.get(position).getImg());
//      // holder.txtName.setText(arrContact.get(position).getName());
//      //  holder.txtNumber.setText(arrContact.get(position).getNumber());

        ContactModel model = (ContactModel) arrContact.get(position);
        holder.img.setImageResource(model.img);
        holder.txtName.setText(model.name);
        holder.txtNumber.setText(model.number);

        setAnimation(holder.itemView, position);

        holder.linearLayoutRow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.add_update_lay);

                EditText edName = dialog.findViewById(R.id.edName);
                EditText edNumber = dialog.findViewById(R.id.edNumber);
                Button btnAction = dialog.findViewById(R.id.btnAction);
                TextView tvTitle = dialog.findViewById(R.id.tvTitleC);

                tvTitle.setText("Update Contact");

                btnAction.setText("Update");

                edName.setText((arrContact.get(position)).name);
                edNumber.setText((arrContact.get(position)).number);
                btnAction.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String name = "", number = "";

                        if (!edName.getText().toString().equals("")) {
                            name = edName.getText().toString();
                        }else {
                            Toast.makeText(context, "Please Enter Contact Name", Toast.LENGTH_SHORT).show();
                        }
                        if (!edNumber.getText().toString().equals("")){
                            number = edNumber.getText().toString();
                        }else {
                            Toast.makeText(context, "Please Enter Contact Number ", Toast.LENGTH_SHORT).show();
                        }
                        arrContact.set(position, new ContactModel(arrContact.get(position).img, name,number));

                        notifyItemChanged(position);
                        dialog.dismiss();

                    }
                });
                dialog.show();


            }
        });

        holder.linearLayoutRow.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {

                AlertDialog.Builder builder= new AlertDialog.Builder(context)
                        .setTitle("Delete Contact")
                        .setMessage("Are you sure want to delete")
                        .setIcon(R.drawable.ic_baseline_delete_24)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                arrContact.remove(position);
                                notifyItemRemoved(position);
                            }
                        })
                        .setNegativeButton("No ", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        });

                builder.show();

                return true;
            }
        });

    }

    @Override
    public int getItemCount() {
        return arrContact.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView img;
        TextView txtName, txtNumber;
        LinearLayout linearLayoutRow;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.imgContact);
            txtName = itemView.findViewById(R.id.txtName);
            txtNumber = itemView.findViewById(R.id.txtNumber);
            linearLayoutRow = itemView.findViewById(R.id.linearLayoutRow);

        }
    }

    private void setAnimation(View viewToAnimate, int position){

        if (position > lastPosition) {
            Animation animation = AnimationUtils.loadAnimation(context,R.anim.rcy_anim);
            viewToAnimate.startAnimation(animation);
            lastPosition = position;
        }

    }
}
