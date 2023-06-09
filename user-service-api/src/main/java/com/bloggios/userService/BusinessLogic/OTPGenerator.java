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

package com.bloggios.userService.BusinessLogic;

import com.bloggios.userService.Entity.Auth;
import com.bloggios.userService.Entity.RegistrationOtp;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.function.Supplier;

/**
 * @author - rohit
 * @project - Bloggios-Learning-Platform-Backend
 * @package - com.bloggios.userService.BusinessLogic
 * @created_on - May 06-2023
 */

@Service
public class OTPGenerator {

    public OTPGenerator() throws NoSuchAlgorithmException{

    }

    public Supplier<String> generateOtp = () -> {
        StringBuilder string = new StringBuilder();
        SecureRandom secureRandom = new SecureRandom();
        for (int i=0 ; i<6 ; i++){
            string.append(secureRandom.nextInt(9));
        }
        return string.toString();
    };

    public RegistrationOtp otpSupplier(Auth auth){
        return RegistrationOtp
                .builder()
                .auth(auth)
                .otp(generateOtp.get())
                .build();
    }
}
