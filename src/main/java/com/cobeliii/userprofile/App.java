package com.cobeliii.userprofile;

import com.cobeliii.userprofile.user.UserProfile;
import com.cobeliii.userprofile.user.UserProfileRepository;
import com.cobeliii.userprofile.youtubeaccount.YoutubeAccount;
import com.cobeliii.userprofile.youtubeaccount.YoutubeAccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

import static com.cobeliii.userprofile.Gender.Female;
import static com.cobeliii.userprofile.Gender.Male;

@SpringBootApplication
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Bean
    CommandLineRunner init(UserProfileRepository userProfileRepository,
                           YoutubeAccountRepository youtubeAccountRepository) {
        return args -> {
          UserProfile userProfile = new UserProfile(
                  "John", "Doe","johndoe@gmail.com", Male
          );

          userProfileRepository.save(userProfile);

          UserProfile userProfile2 = new UserProfile(
            "Jamila", "Jorge", "jj@gmail.com", Female
          );

          userProfileRepository.save(userProfile2);

          YoutubeAccount youtubeAccount = new YoutubeAccount(userProfile);
          YoutubeAccount youtubeAccount2 = new YoutubeAccount(userProfile2);
          List<YoutubeAccount> youtubeAccountList = new ArrayList<>();
          youtubeAccountList.add(youtubeAccount);
          youtubeAccountList.add(youtubeAccount2);
          youtubeAccountRepository.saveAll(youtubeAccountList);

        };
    }

}
