package cz.vsb.SLI0095_project.services;

import cz.vsb.SLI0095_project.entities.Rating;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RatingService {
    public void saveRating(Rating rating);
    public List<Rating> getAllRatings();
    public Rating getRatingById(long id);
    public void deleteRating(Rating rating);
}
