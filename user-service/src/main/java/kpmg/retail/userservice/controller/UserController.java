package kpmg.retail.userservice.controller;

import kpmg.retail.userservice.dto.LoyaltyPointsUpdateRequest;
import kpmg.retail.userservice.dto.RegisterRequest;
import kpmg.retail.userservice.dto.FeedbackRequest;
import kpmg.retail.userservice.model.User;
import kpmg.retail.userservice.repository.FeedbackRepository;
import kpmg.retail.userservice.repository.UserRepository;
import kpmg.retail.userservice.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController
{
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private FeedbackRepository feedbackRepository;
    Logger logger = LoggerFactory.getLogger(UserController.class);


    // ------------------------------Endpoints for app------------------------------

    // Login using Mobile Number
    @GetMapping("/login/{mobileNumber}")
    public User loginUser(@PathVariable("mobileNumber") String mobileNumber) throws Exception {
        return userService.getUserByMobileNumber(mobileNumber);
    }

    // Register using name and mobile number
    @PostMapping("/register")
    public User registerUser(@RequestBody RegisterRequest registerRequest) throws Exception {
        return userService.registerUser(registerRequest);
    }

    // Get loyalty points of a user
    @GetMapping("/loyalty/{id}")
    public Integer getLoyaltyPoints(@PathVariable("id") long id) {
        User user = userRepository.findById(id);
        return user.getLoyaltyPoints();
    }

    // Update the loyalty points of a user
    @PostMapping("/updateLp")
    public void updateLp(@RequestBody LoyaltyPointsUpdateRequest lpUpdate) {
        Optional<User> user = userRepository.findById(lpUpdate.getUserId());
        Integer pointsEarned = lpUpdate.getPointsEarned();
        Boolean hasRedeemed = lpUpdate.getHasRedeemed();

        // transient variable to store the previous points balance
        int prevPoints = user.get().getLoyaltyPoints();

        if (hasRedeemed) {
            user.get().setLoyaltyPoints(pointsEarned);
        } else {
            user.get().setLoyaltyPoints(user.get().getLoyaltyPoints() + pointsEarned);
        }

        logger.info("Updated loyalty points from " + prevPoints + " to " + user.get().getLoyaltyPoints());
        userRepository.save(user.get());
    }

    // Update feedback average of a user
    @PutMapping("/feedback")
    public void updateFeedbackAvg(@RequestBody FeedbackRequest feedbackRequest) {
        feedbackRepository.save(feedbackRequest);
        userService.updateFeedbackAvg(feedbackRequest);
    }

    // ------------------------------Endpoints for dev------------------------------

    @GetMapping("/all")
    public List<User> getAllUsers() { return userRepository.findAll(); }

    @GetMapping("/search/{id}")
    public User getUserById(@PathVariable("id") long id)
    {
        return userRepository.findById(id);
    }

    @PostMapping("/add")
    public User addUser(@RequestBody User user)
    {
        return userRepository.save(user);
    }

    @PutMapping("/update")
    public User updateUser(@RequestBody User user)
    {
        return userRepository.save(user);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable("id") long id) { userRepository.deleteById(id); }
}
