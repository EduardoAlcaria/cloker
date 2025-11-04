package main;

import services.SendMail;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {

        LocalTime localTime = LocalTime.now().plusHours(8);

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("hh:mm:ss");

        String localTimeFormated = dateTimeFormatter.format(localTime);

        String msg = "entrou as " +  dateTimeFormatter.format(LocalTime.now()) + "\nsair as " + localTimeFormated;
        SendMail.send(msg);
    }
}
