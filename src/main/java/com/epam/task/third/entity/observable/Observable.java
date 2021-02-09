package com.epam.task.third.entity.observable;

import com.epam.task.third.observer.Observer;

public interface Observable {

    void attach(Observer observer);

    void detach(Observer observer);

}
