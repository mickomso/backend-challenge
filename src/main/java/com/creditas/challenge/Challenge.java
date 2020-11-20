package com.creditas.challenge;

import com.creditas.challenge.model.*;
import com.creditas.challenge.services.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Optional;

/**
 * USE CASES:
 *
 * -
 *
 * - Third Use Case: If the payment is an ordinary book, you must generate a shipping label with
 *   a notification that it is a tax-exempt item.
 *
 * - Fourth Use Case: If payment of any digital media (music, video), in addition to sending
 *   the description of the purchase by email to the buyer, grant a discount voucher of 10% to the
 *   buyer associated with the payment.
 *
 */
@SpringBootApplication
public class Challenge {

	public static void main(String[] args) {
		SpringApplication.run(Challenge.class, args);
	}

}
