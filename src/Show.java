import java.util.ArrayList;
import java.util.Collections;
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

    public boolean replaceActor(Actor newActor, String surnameToReplace) {
        if (newActor == null || surnameToReplace == null || surnameToReplace.trim().isEmpty()) {
            System.out.println("Ошибка: новый актер или фамилия для замены не могут быть пустыми");
            return false;
        }

        List<Actor> actorsWithSameSurname = new ArrayList<>();
        for (Actor actor : listOfActors) {
            if (actor.getSurname().equalsIgnoreCase(surnameToReplace)) {
                actorsWithSameSurname.add(actor);
            }
        }

        if (actorsWithSameSurname.isEmpty()) {
            System.out.println("Предупреждение: актер с фамилией '" + surnameToReplace + "' не найден в спектакле");
            return false;
        }

        if (actorsWithSameSurname.size() > 1) {
            System.out.println("Предупреждение: найдено несколько актеров с фамилией '" + surnameToReplace + "':");
            for (Actor actor : actorsWithSameSurname) {
                System.out.println("  - " + actor);
            }
            System.out.println("Замена не выполнена. Уточните фамилию или используйте более конкретные данные.");
            return false;
        }

        // Заменяем актера
        Actor actorToReplace = actorsWithSameSurname.get(0);
        int index = listOfActors.indexOf(actorToReplace);
        listOfActors.set(index, newActor);
        System.out.println("Актер " + actorToReplace + " заменен на " + newActor);
        return true;
    }

    public String getTitle() { return title; }
    public int getDuration() { return duration; }
    public Director getDirector() { return director; }

    // Возвращаем неизменяемую копию списка
    public List<Actor> getListOfActors() {
        return Collections.unmodifiableList(new ArrayList<>(listOfActors));
    }
}