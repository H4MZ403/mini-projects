package com.example.market_place_frontend.model;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class MessageModel {
    private String title;
    private String description;
    private LocalDateTime date;

    public MessageModel() {
        String title;
        String description;
        Date date;
    }

    public MessageModel(String title, String description, LocalDateTime date) {
        this.title = title;
        this.description = description;
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public String getDateAsString() {
        LocalDate currentDate = LocalDate.now();
        int year = date.getYear();
        int month = date.getMonthValue();
        int dayOfMonth = date.getDayOfMonth();

        DateTimeFormatter monthDayFormatter = DateTimeFormatter.ofPattern("MM/dd");
        DateTimeFormatter fullDateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        if (currentDate.getYear() == year) {
            if (currentDate.getMonthValue() == month) {
                if (currentDate.getDayOfMonth() == dayOfMonth) {
                    DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
                    return date.format(timeFormatter);
                } else if (dayOfMonth == currentDate.getDayOfMonth() - 1) {
                    return "Yesterday";
                }
                return date.format(monthDayFormatter);
            }
            return date.format(monthDayFormatter);
        }
        return date.format(fullDateFormatter);
    }
}
