package com.hotelreservation.neededbeans;

import java.util.Date;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Reservation {

    private Long idRes;
    private Long idCust;
    private Long idRoom;
    private Date dateRes ;


}
