import Model.User;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

/*
Напишите приложение, которое будет запрашивать у пользователя следующие данные в произвольном порядке, разделенные пробелом:
Фамилия Имя Отчество датарождения номертелефона пол

Форматы данных:
фамилия, имя, отчество - строки
датарождения - строка формата dd.mm.yyyy
номертелефона - целое беззнаковое число без форматирования
пол - символ латиницей f или m.

Приложение должно проверить введенные данные по количеству. Если количество не совпадает с требуемым, вернуть код ошибки,

обработать его и показать пользователю сообщение, что он ввел меньше и больше данных, чем требуется.

Приложение должно попытаться распарсить полученные значения и выделить из них требуемые параметры. Если форматы данных не
совпадают, нужно бросить исключение, соответствующее типу проблемы. Можно использовать встроенные типы java и создать свои.
Исключение должно быть корректно обработано, пользователю выведено сообщение с информацией, что именно неверно.

Если всё введено и обработано верно, должен создаться файл с названием, равным фамилии, в него в одну строку должны записаться полученные данные, вида

<Фамилия><Имя><Отчество><датарождения> <номертелефона><пол>

Однофамильцы должны записаться в один и тот же файл, в отдельные строки.

Не забудьте закрыть соединение с файлом.

При возникновении проблемы с чтением-записью в файл, исключение должно быть корректно обработано, пользователь должен увидеть стектрейс ошибки.

Данная промежуточная аттестация оценивается по системе "зачет" / "не зачет"

"Зачет" ставится, если слушатель успешно выполнил
"Незачет"" ставится, если слушатель успешно выполнил
 */
public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        User user = parsing(scanner.nextLine());
//        System.out.println(user.getDate());
//        System.out.println(user.getGender());
//        System.out.println(user.getPhoneNumder());
//        System.out.println(user.getFio());
//        userWrite(user);
        userControl(user);
//-------------------------------------------------------------------------------------
                //   ДОБАСИТЬ ОБРАБОТКУ ОШИБОК !!!!
//-------------------------------------------------------------------------------------







    }
    public static User parsing(String string){
        User user = new User();
        StringBuilder stringBuilder = new StringBuilder();

       String[] arrayString =  string.split(" ");


        for (int i = 0; i < arrayString.length; i++) {
            if (arrayString[i].contains(".")){
                try {
                    DateTimeFormatter europeanDateFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
                    LocalDate date = LocalDate.parse(arrayString[i], europeanDateFormatter);
                    user.setDate(date);
                }catch (DateTimeParseException e){
                    System.out.println("Вы ввели некорректную дату рождению");

                }

            } else if (arrayString[i].equals("f") || arrayString[i].equals("m")) {
                char gender = arrayString[i].charAt(0);
                user.setGender(gender);
            }

            try {
                user.setPhoneNumder(Integer.parseInt(arrayString[i]));
            }catch (NumberFormatException e){
                if(!arrayString[i].contains(".")&& !(arrayString[i].equals("f") || arrayString[i].equals("m"))){
                   stringBuilder.append(arrayString[i]);
                   stringBuilder.append(" ");
                }
            }

        }

        user.setFio(stringBuilder.toString());

       return user;

    }
    public static void userWrite(User user){
        String[] strings = user.getFio().split(" ");
        String nameFile = strings[0];
        try(FileWriter fileWriter = new FileWriter(nameFile, true)) {
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(user.getFio());
            bufferedWriter.write(user.getDate().toString());
            bufferedWriter.write(" ");
            bufferedWriter.write(user.getPhoneNumderToString());
            bufferedWriter.write(" ");
            bufferedWriter.write(user.getGender());
            bufferedWriter.write("\n");
            bufferedWriter.close();
        } catch (IOException e) {


        }
    }
    public static void userControl (User user) {
        if (user.getFio().equals(" ")){
            throw new RuntimeException("ФИО не введено");
        }
        if (user.getDate() == null){
            throw new RuntimeException("Дата не введена");
        }
        if (user.getPhoneNumder() == null){
            throw new RuntimeException("Номер теллефона не введен");
        }
        if (!(user.getGender() == 'f' || user.getGender() =='m')){
            throw new RuntimeException("Пол не введен");
        }

    }


}