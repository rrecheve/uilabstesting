package es.unex.giiis.asee.uilabs_m;

import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;

public class TodoItemListTest {

    private ToDoItemList toDoItemList;

    @Test
    public void shouldAddItemToList() {
        // TODO - Probar método addItem - Insertar elemento
        toDoItemList.addItem(new ToDoItem("TEST", ToDoItem.Priority.MED, ToDoItem.Status.NOTDONE, new Date(2018, 1, 1)));

        // TODO - Probar método addItem - Comprobar en la lista que ha sido correctamente insertado
        assertEquals(toDoItemList.elements.size(), 1);
        assertEquals(toDoItemList.elements.get(0).getDate(), new Date(2018, 1, 1));
        assertEquals(toDoItemList.elements.get(0).getStatus(), ToDoItem.Status.NOTDONE);
        assertEquals(toDoItemList.elements.get(0).getPriority(), ToDoItem.Priority.MED);
        assertEquals(toDoItemList.elements.get(0).getTitle(), "TEST");
    }


    @Test
    public void shouldUpdateItemOnList() {
        toDoItemList.addItem(new ToDoItem("TEST", ToDoItem.Priority.MED, ToDoItem.Status.NOTDONE, new Date(2018, 1, 1)));
        ToDoItem item = new ToDoItem("TEST", ToDoItem.Priority.HIGH, ToDoItem.Status.DONE, new Date(2018, 1, 1));
        toDoItemList.updateItem(0, item);
        assertEquals(toDoItemList.elements.get(0).getDate(), new Date(2018, 1, 1));
        assertEquals(toDoItemList.elements.get(0).getStatus(), ToDoItem.Status.DONE);
        assertEquals(toDoItemList.elements.get(0).getPriority(), ToDoItem.Priority.HIGH);
        assertEquals(toDoItemList.elements.get(0).getTitle(), "TEST");
    }


    @Test
    public void shouldDeleteAllItemsOnList() {
        toDoItemList.addItem(new ToDoItem("TEST1", ToDoItem.Priority.MED, ToDoItem.Status.NOTDONE, new Date(2018, 1, 1)));
        toDoItemList.addItem(new ToDoItem("TEST2", ToDoItem.Priority.HIGH, ToDoItem.Status.NOTDONE, new Date(2018, 1, 1)));
        toDoItemList.addItem(new ToDoItem("TEST3", ToDoItem.Priority.LOW, ToDoItem.Status.NOTDONE, new Date(2018, 1, 1)));
        toDoItemList.addItem(new ToDoItem("TEST4", ToDoItem.Priority.MED, ToDoItem.Status.DONE, new Date(2018, 1, 1)));
        toDoItemList.deleteAllItems();
        assertEquals(toDoItemList.elements.size(), 0);
    }


    @Before
    public void initTest(){
        toDoItemList = new ToDoItemList();
    }
}




