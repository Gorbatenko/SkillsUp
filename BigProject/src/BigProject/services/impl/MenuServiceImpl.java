package BigProject.services.impl;

import BigProject.services.MenuService;

public class MenuServiceImpl implements MenuService {

    public void showMainMenu() {
        System.out.println("   -= Главное Меню =-");
        System.out.println("1. Поработать с клиентами;");
        System.out.println("2. Заняться продуктами;");
        System.out.println("0. Выход.");
    }

    public void showClientMenu() {
        System.out.println("   -= Клиентское меню =-");
        System.out.println("1. Добавить клиента;");
        System.out.println("2. Редактировать данные клиента;");
        System.out.println("3. Удалить клиента;");
        System.out.println("4. Посмотреть список всех клиентов;");
        System.out.println("9. Вернуться в Главное меню;");
        System.out.println("0. Выход.");
    }

    public void showProductMenu() {
        System.out.println("   -= Продуктовое меню =-");
        System.out.println("1. Добавить продукт;");
        System.out.println("2. Редактировать параметры продукта; ");
        System.out.println("3. Удалить продукт;");
        System.out.println("4. Посмотреть список всех продуктов;");
        System.out.println("9. Вернуться назад;");
        System.out.println("0. Выход.");
    }

    @Override
    public void showEditClientMenu() {
        System.out.println("   -= Редактирование клиента =-");
        System.out.println("1. Изменить имя;");
        System.out.println("2. Изменить фамилию;");
        System.out.println("3. Изменить почту;");
        System.out.println("4. Изменить телефон;");
        System.out.println("9. Вернуться в клиентское меню;");
        System.out.println("0. Выход.");
    }

    public void showSaveMenu() {
        System.out.println("   -= Меню чтения и записи=-");
        System.out.println("1. Сохаранить в .txt;");
        System.out.println("2. Прочитать из .txt (нет);");
        System.out.println("9. Вернуться в клиентское меню;");
        System.out.println("0. Выход.");
    }
}
