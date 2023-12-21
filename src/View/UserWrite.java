package View;

import Model.User;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class UserWrite {
    public void userFileWriter(User user){
        String[] strings = user.getFio().split(" ");
        String nameFile = strings[0];
        try(FileWriter  fileWriter = new FileWriter(nameFile, true)) {
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
}
