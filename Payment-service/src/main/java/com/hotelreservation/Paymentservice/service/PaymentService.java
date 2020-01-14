package com.hotelreservation.Paymentservice.service;

import com.hotelreservation.Paymentservice.Proxy.MicroserviceReservationProxy;
import com.hotelreservation.Paymentservice.repository.PaymentRepository;
import com.hotelreservation.Paymentservice.Beans.CustomerBean;
import com.hotelreservation.Paymentservice.Beans.ReservationBean;
import com.hotelreservation.Paymentservice.Beans.RoomBean;
import com.hotelreservation.Paymentservice.model.Payment;
import com.hotelreservation.Paymentservice.Proxy.MicroserviceCustomerProxy;
import com.hotelreservation.Paymentservice.Proxy.MicroserviceRoomProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;
    @Autowired
    private MicroserviceReservationProxy microserviceReservationProxy;
    @Autowired
    private MicroserviceRoomProxy microserviceRoomProxy;
    @Autowired
    private MicroserviceCustomerProxy microserviceCustomerProxy;
    public void payerCommande(Long idCommande)
    {
        //avoir commande en utilisant id commande
        ReservationBean commande=microserviceReservationProxy.getCommande(idCommande).getBody();
        //consulter idClient
        Long idClient = commande.getIdClient();
        System.out.println(idClient);
        //
        Payment payment =new Payment();
        System.out.println("goooooo gooooo");
        Optional <CustomerBean> client= microserviceCustomerProxy.getClient(idClient);
        //solde du client
        BigDecimal soldeClient= client.get().getSolde();
        System.out.println(soldeClient);
        //comparer le solde du client au valeur de la commande
        if(soldeClient.compareTo(commande.getAmount())==1) {
            System.out.println("goooooollllll gooooollllll");
            commande.setIsPayed(true);
            ResponseEntity<ReservationBean> comandePassed= microserviceReservationProxy.updateCommande(commande);

            int quantity = commande.getQuantity();
            System.out.println(quantity);
            Long idProduit = commande.getIdProduct();
            System.out.println(idProduit);
            RoomBean produit= microserviceRoomProxy.getProduct(idProduit).getBody();
            produit.setStockQuantity(produit.getStockQuantity()-quantity);
            microserviceRoomProxy.addproduct(produit);

            CustomerBean clientb = microserviceCustomerProxy.getClient(idClient).get();
            clientb.setSolde(soldeClient.subtract(commande.getAmount()));
            microserviceCustomerProxy.addClient(clientb);

            payment.setQuantity(quantity);
            payment.setIdCommande(idCommande);
            payment.setIdClient(idClient);
            payment.setIdProduit(idProduit);
            paymentRepository.save(payment);
        }
    }
    public List<RoomBean> TestProduit()
    {
        return microserviceRoomProxy.getAllProducts();
    }
    public List <ReservationBean> TestCommande()
    {
        return microserviceReservationProxy.allCommandes();
    }
}

