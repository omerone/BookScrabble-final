package viewModel;

import model.facade.GuestModel;

import java.util.Observable;
import java.util.Observer;

public class ClientViewModel extends Observable implements Observer {
    GuestModel guestModel;

    @Override
    public void update(Observable o, Object arg) {

    }
}
