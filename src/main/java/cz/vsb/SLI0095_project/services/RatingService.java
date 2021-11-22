package cz.vsb.SLI0095_project.services;

import cz.vsb.SLI0095_project.entities.Rating;
import cz.vsb.SLI0095_project.repositories.RatingJPARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class RatingService {

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


    public Rating getRatingById(long id){
        if(ratingJPARepository.existsById(id))
        {
            return ratingJPARepository.findById(id).get();
        }
        else{
            return null;
        }
    }
}
