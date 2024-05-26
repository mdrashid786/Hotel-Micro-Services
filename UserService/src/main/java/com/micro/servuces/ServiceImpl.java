package com.micro.servuces;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.micro.entities.Hotel;
import com.micro.entities.Rating;
import com.micro.entities.User;
import com.micro.external.service.HotelService;
import com.micro.repository.UserRepository;

@Service
public class ServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private RestTemplate restTemplate;
    
    @Autowired
	private Environment environment;
    
    @Autowired
    private HotelService hotelService;
    
    private Logger logger=LoggerFactory.getLogger(UserService.class);
    
    @Override
    public User saveUser(User user) {
        //String randomUserId= UUID.randomUUID().toString();
       // Long randomId= Long.valueOf(randomUserId);
       // user.setId(randomId);
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }
    
    

    @Override
    public User getUserById(Long id) {
//        Optional<User> user=userRepository.findById(id);
//        	 User existUser= user.get();
//             Rating[] ratingOfUser = restTemplate.getForObject("http://localhost:8083/ratings/users/"+existUser.getId(), Rating[].class);
//             List<Rating> ratings = Arrays.stream(ratingOfUser).toList();
//
//             List<Rating> ratingList = ratings.stream().map(rating -> {
//            	    ResponseEntity<Hotel> responseEntity = restTemplate.getForEntity(
//            	        "http://localhost:8082/hotels/" + rating.getHotelId(), // Assuming rating has a method getHotelId()
//            	        Hotel.class
//            	    );
//
//            	    Hotel hotel = responseEntity.getBody();
//            	    logger.info("response status code : {}", responseEntity.getStatusCode());
//
//            	    rating.setHotel(hotel); 
//            	    return rating; 
//            	}).collect(Collectors.toList());
//             
//             existUser.setRatings(ratingList);
//             
//             return existUser;
        
    	Optional<User> user=userRepository.findById(id);
        User existUser = user.get();
        Rating[] ratingOfUserArray = restTemplate.getForObject("http://RATING-SERVICE/ratings/users/" + existUser.getId(), Rating[].class);

        // Convert array to list
        List<Rating> ratings = new ArrayList<>(Arrays.asList(ratingOfUserArray));

        // Iterate through each rating
        List<Rating> ratingList = new ArrayList<>();
        for (Rating rating : ratings) {
            // Fetch hotel information for the rating
//            ResponseEntity<Hotel> responseEntity = restTemplate.getForEntity(
//                "http://HOTEL-SERVICE/hotels/" + rating.getHotelId(),Hotel.class
           // );
            // Get hotel object from the response
             Hotel hotel = hotelService.getHotel(rating.getHotelId());
             //Hotel hotel = responseEntity.getBody();
            //logger.info("response status code : {}", responseEntity.getStatusCode());

            // Set the hotel in the rating object
            rating.setHotel(hotel);

            // Add the updated rating to the list
            ratingList.add(rating);
        }

        // Set the ratings list in existUser
        existUser.setRatings(ratingList);

        // Return existUser
        return existUser;

       
       
    }

    @Override
    public User updateUserById(User user,Long id) {
        Optional<User> existingUser=userRepository.findById(id);
        if (existingUser.isPresent()) {
            User updateNew = existingUser.get();
            updateNew.setName(user.getName());
            updateNew.setEmail(user.getEmail());
            updateNew.setAbout(user.getAbout());
            return userRepository.save(updateNew);
        }
        return null;
    }

    @Override
    public void deleteUserById(Long id) {
        Optional<User> existingUser=userRepository.findById(id);
        if (existingUser.isPresent()) {
            User updateNew = existingUser.get();
            userRepository.delete(updateNew);
        }
    }
}
