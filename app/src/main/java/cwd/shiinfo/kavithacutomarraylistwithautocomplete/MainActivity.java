package cwd.shiinfo.kavithacutomarraylistwithautocomplete;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    SearchView txtSearch;
    List<People> mList;
    EmployeeAdapter adapter;
    RecyclerView recyclerView;
    DataAdapter adapter1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mList = retrievePeople();
        txtSearch = (SearchView) findViewById(R.id.searchview);
        ListView listView=(ListView)findViewById(R.id.listview2);
        AutoCompleteTextView textView=(AutoCompleteTextView)findViewById(R.id.autosearch);

        final EmployeeAdapter employeeAdapter=new EmployeeAdapter(this,R.layout.activity_main,R.id.textViewCountry,mList);
        textView.setThreshold(1);
        textView.setAdapter(employeeAdapter);

        listView.setAdapter(employeeAdapter);
        employeeAdapter.notifyDataSetChanged();
        recyclerView=findViewById(R.id.listview);
        recyclerView.setHasFixedSize(true);
        adapter1=new DataAdapter(mList);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        adapter1.notifyDataSetChanged();
        recyclerView.setAdapter(adapter1);
textView.addTextChangedListener(new TextWatcher() {
    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        employeeAdapter.getFilter().filter(s);
        employeeAdapter.notifyDataSetChanged();
    }

    @Override
    public void afterTextChanged(Editable s) {
      employeeAdapter.getFilter().filter(s);
      employeeAdapter.notifyDataSetChanged();
    }
});

        // Below event is triggered when submit search query.
        txtSearch.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                if (mList.contains(query)) {
                    adapter.getFilter().filter(query);
                    adapter.notifyDataSetChanged();

                } else {

                }
                return false;

            }

            @Override
            public boolean onQueryTextChange(String newText) {
                recyclerView.getRecycledViewPool().clear();
                adapter1.getFilter().filter(newText);
                adapter1.notifyDataSetChanged();
                return false;
            }
        });




    }

    private List<People> retrievePeople() {
        List<People> list = new ArrayList<People>();
        list.add(new People("James", "$2500", "SH1"));
        list.add(new People("Jason", "$1000", "SH2"));
        list.add(new People("Ethan", "$500", "SH3"));
        list.add(new People("Sherlock", "$450", "SH4"));
        list.add(new People("David", "$3000", "SH5"));
        list.add(new People("Bryan", "$4000", "SH6"));
        list.add(new People("Arjen", "$270", "SH7"));
        list.add(new People("Van", "$600", "SH8"));
        list.add(new People("Zinedine", "$890", "SH9"));
        list.add(new People("Luis", "$750", "SH10"));
        list.add(new People("John", "$350", "SH11"));
        return list;
    }
}