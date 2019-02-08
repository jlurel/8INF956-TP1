import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.WeakHashMap;

public abstract aspect ObserverProtocol {
    protected interface Subject {}
    protected interface Observer {}

    // Mapping and Managing Subjects and Observers
    private WeakHashMap<Subject, List<Observer>> perSubjectObservers;
    protected List<Observer> getObservers(Subject s) {
        if (perSubjectObservers == null)
            perSubjectObservers = new WeakHashMap<Subject, List<Observer>>();
        List<Observer> observers = perSubjectObservers.get(s);
        if ( observers == null ) {
            observers = new LinkedList<Observer>();
            perSubjectObservers.put(s, observers);
        }
        return observers;
    }
    public void addObserver(Subject s, Observer o){
        getObservers(s).add(o);
    }
    public void removeObserver(Subject s, Observer o){
        getObservers(s).remove(o);
    }

    // Notification related functionality
    abstract protected pointcut subjectChange(Subject s);
    abstract protected void updateObserver(Subject s, Observer o);
    after(Subject s): subjectChange(s) {
        Iterator<Observer> iter = getObservers(s).iterator();
        while ( iter.hasNext() ) {
            updateObserver(s, iter.next());
        }
    }
}
