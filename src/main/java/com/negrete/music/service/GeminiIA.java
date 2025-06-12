package com.negrete.music.service;

import com.google.genai.Client;
import com.google.genai.types.GenerateContentResponse;
import com.negrete.music.model.Artist;

public class GeminiIA {
    public static String API_KEY = System.getenv("GEMINI_IA_API_KEY");
    public static String model = "gemini-2.0-flash-lite";

    public static Client client = Client.builder().apiKey(API_KEY).build();

    public static String getDescription(Artist artist) {

        try {
            String prompt = "Describe con menos de 70 palabras quien es " +artist.getRealName()+
                    " conocido con el nombre artístico de " +artist.getArtistName()+
                    " del género musical " +artist.getGenre();

            GenerateContentResponse res = client.models.generateContent(model, prompt, null);

            return res.text();

        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
