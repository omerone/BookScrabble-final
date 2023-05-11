package viewModel;

import model.facade.ServerModel;

import java.util.Observable;
import java.util.Observer;

public class ServerViewModel extends Observable implements Observer  {

    ServerModel serverModel;
    public ServerViewModel(ServerModel model) {
        this.serverModel = model;
        model.addObserver(this);
    }
    public void startServer() {
        serverModel.startServer();
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o == serverModel) {
            System.out.println("Server is running");
            setChanged();
            notifyObservers();
        }
    }
}
