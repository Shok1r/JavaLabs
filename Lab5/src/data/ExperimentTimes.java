package data;

public class ExperimentTimes {
    private GraphPoint[] arrayListAddTimes = new GraphPoint[5];
    private GraphPoint[] arrayListRemoveTimes = new GraphPoint[5];
    private GraphPoint[] linkedListAddTimes = new GraphPoint[5];
    private GraphPoint[] linkedListRemoveTimes = new GraphPoint[5];

    public ExperimentTimes() {
        arrayListAddTimes[0] = new GraphPoint(1, 33400);
        arrayListAddTimes[1] = new GraphPoint(2, 91400);
        arrayListAddTimes[2] = new GraphPoint(3, 411800);
        arrayListAddTimes[3] = new GraphPoint(4, 1759900);
        arrayListAddTimes[4] = new GraphPoint(5, 9627700);

        arrayListRemoveTimes[0] = new GraphPoint(1, 555900);
        arrayListRemoveTimes[1] = new GraphPoint(2, 15900);
        arrayListRemoveTimes[2] = new GraphPoint(3, 218600);
        arrayListRemoveTimes[3] = new GraphPoint(4, 1619600);
        arrayListRemoveTimes[4] = new GraphPoint(5, 101990800);

        linkedListAddTimes[0] = new GraphPoint(1, 49100);
        linkedListAddTimes[1] = new GraphPoint(2, 25400);
        linkedListAddTimes[2] = new GraphPoint(3, 279200);
        linkedListAddTimes[3] = new GraphPoint(4, 1498700);
        linkedListAddTimes[4] = new GraphPoint(5, 9933300);

        linkedListRemoveTimes[0] = new GraphPoint(1, 36400);
        linkedListRemoveTimes[1] = new GraphPoint(2, 47600);
        linkedListRemoveTimes[2] = new GraphPoint(3, 332000);
        linkedListRemoveTimes[3] = new GraphPoint(4, 18298300);
        linkedListRemoveTimes[4] = new GraphPoint(5, 487979380);
    }

    public GraphPoint[] getArrayListAddTimes() {
            return arrayListAddTimes;
    }

    public void setArrayListAddTimes(GraphPoint[] arrayListAddTimes) {
            this.arrayListAddTimes = arrayListAddTimes;
    }

    public GraphPoint[] getArrayListRemoveTimes() {
            return arrayListRemoveTimes;
    }

    public void setArrayListRemoveTimes(GraphPoint[] arrayListRemoveTimes) {
            this.arrayListRemoveTimes = arrayListRemoveTimes;
    }

    public GraphPoint[] getLinkedListAddTimes() {
            return linkedListAddTimes;
    }

    public void setLinkedListAddTimes(GraphPoint[] linkedListAddTimes) {
            this.linkedListAddTimes = linkedListAddTimes;
    }

    public GraphPoint[] getLinkedListRemoveTimes() {
            return linkedListRemoveTimes;
    }

    public void setLinkedListRemoveTimes(GraphPoint[] linkedListRemoveTimes) {
            this.linkedListRemoveTimes = linkedListRemoveTimes;
    }
}
