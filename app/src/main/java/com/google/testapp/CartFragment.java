package com.google.testapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import android.content.DialogInterface;
import android.os.Bundle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CartFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CartFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public CartFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CartFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CartFragment newInstance(String param1, String param2) {
        CartFragment fragment = new CartFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }
    int sl;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cart, container, false);
        //
        TextView tvBuyMore1 = view.findViewById(R.id.tvBuyMore1);
        tvBuyMore1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_cartFragment_to_menuProducts);
            }
        });
        TextView tvOrder1 = view.findViewById(R.id.tvOrder1);
        tvOrder1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_cartFragment_to_paymentFragment);
            }
        });

        // Delete product
        LinearLayout layoutChooseItem = view.findViewById(R.id.layoutChooseItem);
        ImageView btnCloseItem = view.findViewById(R.id.btnCloseItem);
        btnCloseItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());

                builder.setMessage("Do you want to delete this product?");

                builder.setTitle("Delete Product !");

                builder.setCancelable(false);

                builder.setPositiveButton("Yes", (DialogInterface.OnClickListener) (dialog, which) -> {
                    layoutChooseItem.setVisibility(View.GONE);
                    Toast.makeText(getContext(), "Delete is successful", Toast.LENGTH_SHORT).show();
                });

                builder.setNegativeButton("No", (DialogInterface.OnClickListener) (dialog, which) -> {
                    dialog.cancel();
                });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();

            }
        });

        TextView count = view.findViewById(R.id.tvQuantity1);
        ImageView add = view.findViewById(R.id.btnAdd1);
        ImageView remove = view.findViewById(R.id.btnRemove1);

        sl =1;
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sl++;
                count.setText(String.valueOf(sl));
            }
        });
        remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (sl>1)
                {
                    sl--;
                    count.setText(String.valueOf(sl));
                }
            }
        });


        CheckBox cbAll = view.findViewById(R.id.cbAll);
        CheckBox cbItem1 = view.findViewById(R.id.cbItem1);
        CheckBox cbItem2 = view.findViewById(R.id.cbItem2);
        CheckBox cbItem3 = view.findViewById(R.id.cbItem3);
        cbAll.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if(isChecked)
                {
                    cbItem1.setChecked(true);
                    cbItem2.setChecked(true);
                    cbItem3.setChecked(true);
                }
                else
                {
                    cbItem1.setChecked(false);
                    cbItem2.setChecked(false);
                    cbItem3.setChecked(false);
                }
            }
        });
        return view;
    }
}