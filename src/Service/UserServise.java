package Service;

import Model.User;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class UserServise {

    public User getUserIsString(String scanerString){
        User user = new User();
       String[] arrayString = scanerString.split(" ");
       StringBuilder stringBuilder = new StringBuilder();

       for (int i = 0; i < arrayString.length; i++) {
           if (arrayString[i].contains(".")){
               try {
                   DateTimeFormatter europeanDateFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
                   LocalDate date = LocalDate.parse(arrayString[i], europeanDateFormatter);
                   user.setDate(date);
               }catch (DateTimeParseException e){
                   System.out.println("Вы ввели некорректную дату рождению");

               }

           }
           else if (arrayString[i].equals("f") || arrayString[i].equals("m")) {
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

       public void userControl(User user){
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
