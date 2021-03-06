package com.cs50.finalprojectcs50.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.cs50.finalprojectcs50.R;
import com.cs50.finalprojectcs50.adapter.TransactionsAdapter;
import com.cs50.finalprojectcs50.utils.DateConverters;

public class PagerFragment extends Fragment {
    private RecyclerView recyclerView;
    private TransactionsAdapter transactionAdapter;
    private RecyclerView.LayoutManager layoutManager;

    private int currentPageIndex;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.transactions_container, container, false);
        recyclerView = view.findViewById(R.id.transaction_recycler_view);

        layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        transactionAdapter = new TransactionsAdapter(getContext());
        recyclerView.setAdapter(transactionAdapter);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        setRetainInstance(true);
        Bundle args = getArguments();
        int pageIndex = args.getInt("pageIndex");
        loadData(pageIndex);
        currentPageIndex = pageIndex;
    }

    @Override
    public void onResume() {
        super.onResume();
        loadData(currentPageIndex);
    }

    public void loadData(int pageIndex) {
        long rangeStart = 0;
        long rangeEnd = 0;

        switch (pageIndex) {
            case 0:
                rangeStart = DateConverters.startOfDate().getTime();
                rangeEnd = DateConverters.endOfDate().getTime();
                break;
            case 1:
                rangeStart = DateConverters.startOfWeek().getTime();
                rangeEnd = DateConverters.endOfWeek().getTime();
                break;
            case 2:
                rangeStart = DateConverters.startOfMonth().getTime();
                rangeEnd = DateConverters.endOfMonth().getTime();
                break;
        }

        if (rangeStart == 0 && rangeEnd == 0) {
            transactionAdapter.loadData();
        }
        transactionAdapter.setRangeTransactionStart(rangeStart);
        transactionAdapter.setRangeTransactionEnd(rangeEnd);
        transactionAdapter.loadData();
    }
}
