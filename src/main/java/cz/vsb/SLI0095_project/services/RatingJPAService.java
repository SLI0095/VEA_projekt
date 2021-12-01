package cz.vsb.SLI0095_project.services;

import cz.vsb.SLI0095_project.entities.Book;
import cz.vsb.SLI0095_project.entities.Rating;
import cz.vsb.SLI0095_project.repositories.RatingJPARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@ConditionalOnProperty(
        value="accessType",
        havingValue = "jpa",
        matchIfMissing = true)
public class RatingJPAService implements RatingService{

    @Autowired
    RatingJPARepository ratingJPARepository;

    @Transactional
    public void saveRating(Rating rating){
        if(rating.getRatingId() == 0){
            ratingJPARepository.save(rating);
        }
        else if (rating.getRatingId() > 0){
            if(ratingJPARepository.existsById(rating.getRatingId())) {
                ratingJPARepository.save(rating);
            }
        }
    }

    public List<Rating> getAllRatings(){
        List<Rating> ratings = new ArrayList<>();
        Iterable<Rating> iterator = ratingJPARepository.findAll();
        for(Rating r : iterator){
            ratings.add(r);
        }
        return ratings;
    }

    public Rating getRatingById(long id){
        if(ratingJPARepository.existsById(id))
        {
            return ratingJPARepository.findById(id).get();
        }
        else{
            return null;
        }
    }

    @Override
    public void deleteRating(Rating rating) {
        ratingJPARepository.delete(rating);
    }
}
