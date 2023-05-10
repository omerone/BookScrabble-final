package viewModel;

import model.facade.Model;

import java.util.Observable;
import java.util.Observer;

public class ViewModel implements Observer {
    Model model;
    public ViewModel(Model model) {
        this.model = model;
        model.addObserver(this);
    }
    public void startServer(){
        model.startServer();
    }

    @Override
    public void update(Observable o, Object arg) {

    }
}
