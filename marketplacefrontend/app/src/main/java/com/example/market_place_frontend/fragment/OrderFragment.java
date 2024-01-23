package com.example.market_place_frontend.fragment;

import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.market_place_frontend.R;
import com.example.market_place_frontend.adapters.OrderMessageAdapter;
import com.example.market_place_frontend.model.MessageModel;

import java.time.LocalDateTime;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link OrderFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
@RequiresApi(api = Build.VERSION_CODES.O)
public class OrderFragment extends Fragment {
    private RecyclerView recyclerViewOrderMessage;
    private OrderMessageAdapter orderMessageAdapter;
    private MessageModel[] messageModels = {new MessageModel("Order completed", "Your order is completed. We hope you’re happy " +
            "with your purchase.", LocalDateTime.now()),
            new MessageModel("Order completed", "Your order is completed. We hope you’re happy " +
                    "with your purchase.", LocalDateTime.of(2024, 1, 22, 12, 30)),
            new MessageModel("Order completed", "Your order is completed. We hope you’re happy " +
                    "with your purchase.", LocalDateTime.of(2024, 1, 11, 22, 55)),
            new MessageModel("Order completed", "Your order is completed. We hope you’re happy " +
                    "with your purchase.", LocalDateTime.of(2023, 5, 11, 14, 55))};

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public OrderFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment OrdersFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static OrderFragment newInstance(String param1, String param2) {
        OrderFragment fragment = new OrderFragment();
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_order, container, false);
        recyclerViewOrderMessage = view.findViewById(R.id.recyclerViewOrderMessages);
        LinearLayoutManager layoutManager = new LinearLayoutManager(requireContext());
        recyclerViewOrderMessage.setLayoutManager(layoutManager);

        orderMessageAdapter = new OrderMessageAdapter(messageModels, view.getContext());
        recyclerViewOrderMessage.setAdapter(orderMessageAdapter);

        return view;
    }
}