package com.cobeliii.userprofile.youtubeaccount;

import com.cobeliii.userprofile.user.UserProfile;
import jakarta.persistence.*;

import java.time.ZonedDateTime;

import static jakarta.persistence.GenerationType.SEQUENCE;

@Entity
public class YoutubeAccount {
    @Id
    private Integer userProfileId;
    @OneToOne
    @JoinColumn(
            name = "user_profile_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "user_profile_id_user_profile_id_fk"
            ),
            nullable = false,
            unique = true
    )
    private UserProfile userProfile;
    //private Integer userProfileId;
    private ZonedDateTime createdAt;

    public YoutubeAccount() {
    }

    public YoutubeAccount(UserProfile userProfile) {
        this.userProfile = userProfile;
    }

    @PrePersist
    public void prePersist() {
        this.createdAt = ZonedDateTime.now();
        this.userProfileId = this.userProfile.getId();
    }

    public UserProfile getUserProfile() {
        return userProfile;
    }

    public void setUserProfile(UserProfile userProfile) {
        this.userProfile = userProfile;
    }

    public Integer getUserProfileId() {
        return userProfileId;
    }

    public void setUserProfileId(Integer userProfileId) {
        this.userProfileId = userProfileId;
    }

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(ZonedDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
