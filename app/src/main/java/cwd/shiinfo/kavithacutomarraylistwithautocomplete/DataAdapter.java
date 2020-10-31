package cwd.shiinfo.kavithacutomarraylistwithautocomplete;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> implements Filterable {
    private List<People> mArrayList;
    private List<People> mFilteredList;

    public DataAdapter(List<People> arrayList) {
        mArrayList = arrayList;
        mFilteredList = arrayList;
    }

    @Override
    public DataAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.temple_list, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DataAdapter.ViewHolder viewHolder, int i) {

        viewHolder.tv_name.setText(mFilteredList.get(i).getName());
        viewHolder.tv_version.setText("EmployeeId: "+mFilteredList.get(i).getId());
        viewHolder.tv_api_level.setText("Salary: "+mFilteredList.get(i).getlastName());
    }

    @Override
    public int getItemCount() {
        return mFilteredList.size();
    }

    @Override
    public Filter getFilter() {

        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {

                String charString = charSequence.toString();

                if (charString.isEmpty()) {

                    mFilteredList = mArrayList;
                } else {

                    ArrayList<People> filteredList = new ArrayList<>();

                    for (People androidVersion : mArrayList) {

                        if (androidVersion.getName().toLowerCase().contains(charString)||androidVersion.getlastName().toLowerCase().contains(charString)||androidVersion.getId().toLowerCase().contains(charSequence)) {

                            filteredList.add(androidVersion);
                        }
                    }

                    mFilteredList = filteredList;
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = mFilteredList;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                mFilteredList = (ArrayList<People>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView tv_name,tv_version,tv_api_level;
        public ViewHolder(View view) {
            super(view);

            tv_name = (TextView)view.findViewById(R.id.textViewCountry);
            tv_version = (TextView)view.findViewById(R.id.textViewCapital);
            tv_api_level = (TextView)view.findViewById(R.id.textViewSalary);

        }
    }

}