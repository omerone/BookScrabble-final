package viewModel;

import model.Model;

import java.util.Observable;
import java.util.Observer;

public class ViewModel implements Observer {

    Model model;
    public ViewModel(Model model) {
        this.model = model;
        model.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {

    }
}
