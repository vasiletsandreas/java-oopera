import java.util.ArrayList;
import java.util.List;

public class Show {
    protected String title;
    protected int duration;
    protected Director director;
    protected List<Actor> listOfActors;

    public Show(String title, int duration, Director director) {
        this.title = title;
        this.duration = duration;
        this.director = director;
        this.listOfActors = new ArrayList<>();
    }

    public void printActors() {
        System.out.println("Актеры в спектакле \"" + title + "\":");
        for (Actor actor : listOfActors) {
            System.out.println("  - " + actor);
        }
    }

    public void addActor(Actor actor) {
        if (actor != null && !listOfActors.contains(actor)) {
            listOfActors.add(actor);
        }
    }

    public boolean replaceActor(Actor oldActor, Actor newActor) {
        if (oldActor == null || newActor == null) {
            return false;
        }

        int index = listOfActors.indexOf(oldActor);
        if (index != -1) {
            listOfActors.set(index, newActor);
            return true;
        }
        return false;
    }

    public String getTitle() { return title; }
    public int getDuration() { return duration; }
    public Director getDirector() { return director; }
    public List<Actor> getListOfActors() { return listOfActors; }
}