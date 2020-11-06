package es.unex.giiis.asee.uilabs_m;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by rre on 12/10/16.
 */

public class ToDoAdapter extends RecyclerView.Adapter<ToDoAdapter.ViewHolder> {
    private final ToDoItemList toDoItemList = new ToDoItemList();

    public interface OnItemClickListener {
        void onItemClick(ToDoItem item);     //Type of the element to be returned
    }


    private final OnItemClickListener listener;

    // Provide a suitable constructor (depends on the kind of dataset)
    public ToDoAdapter(OnItemClickListener listener) {
//        mItems = items;
        this.listener = listener;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ToDoAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                     int viewType) {
        //TODO - Inflate the View for every element
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.todo_item, parent, false);
//        .inflate(android.R.layout.simple_list_item_1, parent, false);
        // set the view's size, margins, paddings and layout parameters

        return new ViewHolder(v);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bind(toDoItemList.get(position),listener);

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return toDoItemList.size();
    }

    public void add(ToDoItem item) {

        toDoItemList.addItem(item);
        notifyDataSetChanged();

    }

    public void clear(){

        toDoItemList.deleteAllItems();
        notifyDataSetChanged();

    }

//    @Override
    public Object getItem(int pos) {

        return toDoItemList.get(pos);

    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        private TextView title;
        private CheckBox statusView;
        private TextView priorityView;
        private TextView dateView;

        public ViewHolder(View itemView) {
            super(itemView);

            //TODO - Get the references to every widget of the Item View
            title = (TextView) itemView.findViewById(R.id.titleView);
            statusView = (CheckBox) itemView.findViewById(R.id.statusCheckBox);
            priorityView = (TextView) itemView.findViewById(R.id.priorityView);
            dateView = (TextView) itemView.findViewById(R.id.dateView);

        }

        public void bind(final ToDoItem toDoItem, final OnItemClickListener listener) {

            //TODO - Display Title in TextView
            title.setText(toDoItem.getTitle());

            //TODO - Display Priority in a TextView
            priorityView.setText(toDoItem.getPriority().toString());

            // TODO - Display Time and Date.
            // Hint - use ToDoItem.FORMAT.format(toDoItem.getDate()) to get date and time String
            dateView.setText(ToDoItem.FORMAT.format(toDoItem.getDate()));

            // TODO - Set up Status CheckBox
            statusView.setChecked(toDoItem.getStatus() == ToDoItem.Status.DONE);

            statusView.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView,
                                             boolean isChecked) {

                    // TODO - Set up and implement an OnCheckedChangeListener
                    // is called when the user toggles the status checkbox
                    if (isChecked) {
                        toDoItem.setStatus(ToDoItem.Status.DONE);
                        title.setBackgroundColor(Color.GREEN);
                    } else {
                        toDoItem.setStatus(ToDoItem.Status.NOTDONE);
                        title.setBackgroundColor(Color.WHITE);
                    }}});

            itemView.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    listener.onItemClick(toDoItem);
                }
            });
        }
    }

}
