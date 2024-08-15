package com.capstone.mobilerechargeservice.Repositary;


import com.capstone.mobilerechargeservice.Models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface User_Repository extends JpaRepository<UserModel, Integer> {
    // Custom query to find a user by their number
    @Query("SELECT u FROM UserModel u WHERE u.user_Number = :userNumber")
    Optional<UserModel> getByUserNumber(long userNumber);







}