package main.java.lists.interfaces;

import main.java.invaders.interfaces.Invader;

public interface IList {
    void pruebaFuncionamiento();
    void append(Invader data);
    int getLarge();
    Invader ShowDataInPos(int x);
    void DeleteAll();
    void Delete (int pos);

    void BubbleSort();

    void InterChange();

    void ascention();
}
