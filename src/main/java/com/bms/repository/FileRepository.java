package com.bms.repository;

import com.bms.models.Movie;
import com.bms.models.Schedule;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FileRepository {

    public List<Movie> getMovies(String filePath) throws IOException {
        byte[] moviesFile = Files.readAllBytes(Paths.get(filePath));
        Type listType = new TypeToken<List<Movie>>() {}.getType();
        return new Gson().fromJson(new String(moviesFile), listType);
    }

    public Schedule getSchedule(String filePath) throws IOException {
        byte[] timingsFile = Files.readAllBytes(Paths.get(filePath));
        return new Gson().fromJson(new String(timingsFile), Schedule.class);
    }
}
