/*
 * Copyright 2023 Rohit Parihar and Bloggios
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.bloggios.userService.Repository;

import com.bloggios.userService.Entity.Auth;
import com.bloggios.userService.Entity.RegistrationOtp;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author - rohit
 * @project - Bloggios-Learning-Platform-Backend
 * @package - com.bloggios.userService.Repository
 * @created_on - May 08-2023
 */

public interface RegistrationOtpRepository extends JpaRepository<RegistrationOtp, String> {
    Optional<RegistrationOtp> findByOtp(String otp);
    Optional<RegistrationOtp> findByAuth_AuthId(String authId);
}
