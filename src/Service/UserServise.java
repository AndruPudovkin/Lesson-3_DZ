package Service;

import Model.User;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class UserServise {
   private   User user;
   private String scanerString;

   public User getUserIsString(String scanerString){
       String[] arrayString = scanerString.split(" ");
       StringBuilder stringBuilder = new StringBuilder();

       for (int i = 0; i < arrayString.length; i++) {
           if (arrayString[i].contains(".")){
               DateTimeFormatter europeanDateFormatter = DateTimeFormatter.ofPattern(arrayString[i]);
               LocalDate date = LocalDate.parse(arrayString[i], europeanDateFormatter); // оштбка даты нужна обработка
               user.setDate(date);
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


}
