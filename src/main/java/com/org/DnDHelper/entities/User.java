package com.org.DnDHelper.entities;

import com.fasterxml.jackson.annotation.JsonView;
import com.org.DnDHelper.view.UserView;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    String authUserMail;

    @JsonView({UserView.GameMaster.class})
    @OneToMany(mappedBy = "owner")
    List<Session> sessionOwnerList;

    @ManyToMany
            @JoinTable(
                name = "sessionParticipants",
                    joinColumns = @JoinColumn(name = "user_id"),
                    inverseJoinColumns = @JoinColumn(name = "session_id")
            )
    List<Session> sessionParticipantList;


}
