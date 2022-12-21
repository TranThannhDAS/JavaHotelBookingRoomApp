package Task.Inteface;

import java.util.List;

public interface IBookingHotel<T> {
    public void saveData();
    public List<T> getData();
}
