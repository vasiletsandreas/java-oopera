public class Theatre {
    public static void main(String[] args) {

        Actor actor1 = new Actor("Иван", "Петров", Gender.MALE, 185.5);
        Actor actor2 = new Actor("Мария", "Сидорова", Gender.FEMALE, 170.0);
        Actor actor3 = new Actor("Алексей", "Иванов", Gender.MALE, 178.2);
        Actor actor4 = new Actor("Анна", "Козлова", Gender.FEMALE, 165.8);


        Director director1 = new Director("Сергей", "Васильев", Gender.MALE, 15);
        Director director2 = new Director("Ольга", "Николаева", Gender.FEMALE, 12);


        String musicAuthor = "Петр Чайковский";
        String choreographer = "Мариус Петипа";


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
        boolean replaced = ballet.replaceActor(actor3, actor2);
        if (replaced) {
            System.out.println("Актер успешно заменен!");
        } else {
            System.out.println("Актер для замены не найден!");
        }
        ballet.printActors();
        System.out.println();

        // Пытаемся заменить несуществующего актера
        System.out.println(" ПОПЫТКА ЗАМЕНИТЬ НЕСУЩЕСТВУЮЩЕГО АКТЕРА ");
        Actor nonExistentActor = new Actor("Несуществующий", "Актер", Gender.MALE, 180.0);
        boolean notReplaced = opera.replaceActor(nonExistentActor, actor1);
        if (!notReplaced) {
            System.out.println("Несуществующий актер не был заменен (ожидаемое поведение)");
        }
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