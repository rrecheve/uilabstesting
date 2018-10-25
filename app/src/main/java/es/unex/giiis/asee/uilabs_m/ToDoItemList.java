package es.unex.giiis.asee.uilabs_m;

import java.util.ArrayList;
import java.util.List;

public class ToDoItemList {

    protected List<ToDoItem> elements;

    public ToDoItemList(){
        elements = new ArrayList<>();
    }

    public void addItem(ToDoItem item){
        elements.add(item);
    }

    public void deleteAllItems(){
        elements.clear();
    }

    public void updateItem(int position, ToDoItem item){
        elements.get(position).setStatus(item.getStatus());
    }

    public ToDoItem get(int position){
        return elements.get(position);
    }

    public int size(){
        return elements.size();
    }
}
