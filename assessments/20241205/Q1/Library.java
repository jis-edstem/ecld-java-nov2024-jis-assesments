import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Library {
    private List<LibraryItem> items;

    public Library() {
        items = new ArrayList<>();
    }

    public void addItem(LibraryItem item) {
        items.add(item);
    }

    public void removeItem(String id) {
        items.removeIf(item -> item.getId().equals(id));
    }

    public List<LibraryItem> searchByTitle(String title) {
        return items.stream()
                .filter(item -> item.getTitle().equalsIgnoreCase(title))
                .collect(Collectors.toList());
    }

    public LibraryItem borrowItem(String id) {
        for(LibraryItem item : items) {
            if (item.getId().equals(id) && item.isAvailable()) {
                item.setAvailable(false);
                return item;
            }
        }
        return null;
    }

    public void returnItem(String id) {
        for(LibraryItem item: items) {
            if(item.getId().equals(id)) {
                item.setAvailable(true);
                return;
            }
        }
    }

    public List<LibraryItem> getOverdueItems(int daysOverdue) {
        List<LibraryItem> overdueItems = new ArrayList<>();
        for(LibraryItem item: items) {
            if(!item.isAvailable()) {
                overdueItems.add(item);
            }
        }
        return overdueItems;
    }
}
