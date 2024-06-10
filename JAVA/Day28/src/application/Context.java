package application;

import sorting.SortingStrategy;

public class Context {
    private SortingStrategy strategy;

    public Context(SortingStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(SortingStrategy strategy) {
        this.strategy = strategy;
    }

    public int[] sortData(int[] data) {
        return strategy.sort(data);
    }
}
