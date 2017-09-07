package com.exp.testtableview.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.widget.ArrayAdapter;

/**
 * Created by Administrator on 2017/9/2.
 */

public class BookListFragment extends ListFragment{

    public interface Callbacks{
        public void onItemSelected(Integer id);
    }


    private Callbacks mCallbacks;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setListAdapter(new ArrayAdapter<BookContent.Book>(getActivity(),android.R.layout.simple_list_item_activated_1,android.R.id.text1, BookContent.ITEMS));

    }


}
