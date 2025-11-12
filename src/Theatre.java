public class Theatre {
    public static void main(String[] args) {

        Actor actor1 = new Actor("Иван", "Петров", Gender.MALE, 185.5);
        Actor actor2 = new Actor("Мария", "Сидорова", Gender.FEMALE, 170.0);
        Actor actor3 = new Actor("Алексей", "Иванов", Gender.MALE, 178.2);
        Actor actor4 = new Actor("Анна", "Козлова", Gender.FEMALE, 165.8);


        Director director1 = new Director("Сергей", "Васильев", Gender.MALE, 15);
        Director director2 = new Director("Ольга", "Николаева", Gender.FEMALE, 12);


        Person musicAuthor = new Person("Петр", "Чайковский", Gender.MALE);
        Person choreographer = new Person("Мариус", "Петипа", Gender.MALE);

        Show regularShow = new Show("Обычный спектакль", 120, director1);
        Opera opera = new Opera("Евгений Онегин", 180, director2,
                musicAuthor, "Либретто оперы 'Евгений Онегин' по роману А.С. Пушкина", 30);
        Ballet ballet = new Ballet("Лебединое озеро", 150, director1,
                musicAuthor, "Либретто балета 'Лебединое озеро' о принце Зигфриде и заколдованной принцессе Одетте",
                choreographer);


        regularShow.addActor(actor1);
        regularShow.addActor(actor2);

        opera.addActor(actor2);
        opera.addActor(actor3);

        ballet.addActor(actor1);
        ballet.addActor(actor3);
        ballet.addActor(actor4);


        System.out.println(" СПИСКИ АКТЕРОВ ПОСЛЕ РАСПРЕДЕЛЕНИЯ ");
        regularShow.printActors();
        System.out.println();
        opera.printActors();
        System.out.println();
        ballet.printActors();
        System.out.println();


        System.out.println(" ЗАМЕНА АКТЕРА В БАЛЕТЕ ");
        Actor newActor = new Actor("Екатерина", "Новикова", Gender.FEMALE, 168.0);
        boolean replaced = ballet.replaceActor(newActor, "Иванов");
        ballet.printActors();
        System.out.println();

        // Пытаемся заменить несуществующего актера
        System.out.println(" ПОПЫТКА ЗАМЕНИТЬ НЕСУЩЕСТВУЮЩЕГО АКТЕРА ");
        boolean notReplaced = opera.replaceActor(actor1, "Несуществующий");
        System.out.println();

        // Выводим информацию о режиссерах
        System.out.println(" ИНФОРМАЦИЯ О РЕЖИССЕРАХ ");
        System.out.println("Режиссер 1: " + director1);
        System.out.println("Режиссер 2: " + director2);
        System.out.println();

        // Выводим либретто для музыкальных спектаклей
        System.out.println(" ЛИБРЕТТО МУЗЫКАЛЬНЫХ СПЕКТАКЛЕЙ ");
        opera.printLibretto();
        System.out.println();
        ballet.printLibretto();

        // Дополнительная демонстрация работы с разными типами спектаклей
        System.out.println("\n ДОПОЛНИТЕЛЬНАЯ ИНФОРМАЦИЯ ");
        System.out.println("Балет '" + ballet.getTitle() + "', хореограф: " + ballet.getChoreographer());
        System.out.println("Опера '" + opera.getTitle() + "', размер хора: " + opera.getChoirSize() + " человек");
    }
}