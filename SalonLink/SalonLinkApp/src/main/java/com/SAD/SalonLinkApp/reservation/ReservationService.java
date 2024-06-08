package com.SAD.SalonLinkApp.reservation;

import com.SAD.SalonLinkApp.UserSession;
import com.SAD.SalonLinkApp.repo.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
@AllArgsConstructor
public class ReservationService {

    private final SalonRepository salonRepository;
    private final ReservationRepository reservationRepository;
    private final CustomerUserRepository customerUserRepository;


    public int generateUniqueNumber() {
        Random random = new Random();
        return random.nextInt(900000000) + 100000000;
    }

    public String createReservation(ReservationRequest request ){

        String selectedService = request.getSelectedService();
        Long loggedInCustomerId = UserSession.getLoggedInCustomerId();
        if (loggedInCustomerId == null) {
            throw new NullPointerException("Please login first");
        }

        String selectedSalonName = UserSession.getSelectedSalon();
        if (selectedSalonName== null) {
            throw new NullPointerException("Please select a salon first");

        }

        Optional<CustomerAppUser> customerAppUserObject = customerUserRepository.findById(loggedInCustomerId);
        CustomerAppUser loggedInCustomer = customerAppUserObject.get();
        String loggedInCustomerEmail = loggedInCustomer.getEmail();
        Optional<Salon> selectedSalonObject = salonRepository.findByName(selectedSalonName);
        Salon selectedSalon = selectedSalonObject.get();
        String salonServices = selectedSalon.getServices();
        List<String> listOfSalonServices = List.of(salonServices.split(",\\s*"));
        for(String salonSpecificService: listOfSalonServices){
            if(salonSpecificService.equalsIgnoreCase(selectedService)){

                int reservationId = generateUniqueNumber(); // Generate a unique order ID
                Reservation reservation = new Reservation(reservationId, loggedInCustomerEmail, selectedSalonName);
                reservationRepository.save(reservation);

                return "You have successfully made a reservation for "+selectedService+" at " +selectedSalonName+
                        ". Here is your reservation id: " + reservationId;

            }}

        return "Service selected not available for this salon.";

    }









}
