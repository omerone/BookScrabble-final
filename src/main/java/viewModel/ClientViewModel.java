package viewModel;

import model.facade.ClientModel;

import java.util.Observable;
import java.util.Observer;

public class ClientViewModel extends Observable implements Observer {
    ClientModel clientModel;

    public ClientViewModel(ClientModel clientModel) {
        this.clientModel = clientModel;
        clientModel.addObserver(this);
    }
    public void connect(String serverAddress, int port) throws Exception {
        clientModel.connect(serverAddress, port);
    }
    public void sendMessage(String message) {
        clientModel.sendMessage(message);
    }
    public void sendMessage(String message, String exit_str) {
        clientModel.sendMessage(message, exit_str);
    }
    @Override
    public void update(Observable o, Object arg) {
        if(o == clientModel){
            System.out.println("Client is connected");
            setChanged();
            notifyObservers();
        }
    }
}
