package cz.vsb.SLI0095_project;

import cz.vsb.SLI0095_project.entities.Rating;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;


public class RatingFormatter implements Formatter<Rating> {


    @Override
    public Rating parse(String text, Locale locale) throws ParseException {
        return null;
    }

    @Override
    public String print(Rating object, Locale locale) {
        String ratingAuthor = object.getRatingAuthor().getLogin();
        int ratingScore = object.getRatingScore();
        String returningString = ratingAuthor + " (" + ratingScore + " out of 10)";
        return returningString;
    }
}
