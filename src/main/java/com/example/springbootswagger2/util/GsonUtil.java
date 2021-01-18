package com.example.springbootswagger2.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonUtil {
    public static Gson getDefault() {
        return new Gson();
    }

    public static Gson getPrettyDefault() {
        return new GsonBuilder().setPrettyPrinting().create();
    }
}
