package com.hotelreservation.roomservice.service;

@Service
public class RoomService {
     @Autowired
    private RoomRepository roomRepository;

    public List<Room> getRoomByNbBed(int nb)
    {
        return roomRepository.getByNbBed(nb);
    }
    boolean findRoomByNbBed(int nb){
        return roomRepository.findByNbBed(nb);
    }
    boolean findRootByNumber(int nb){
        return roomRepository.findByNumber(nb);
    }
    boolean findRoomByPrice(int price){
        return roomRepository.findByPrice(price);
    }
    int getRoomByPrice(int price){
        return roomRepository.getByPrice(price);
    }
    Room getRoomByNumber(int nb){
        return  roomRepository.getByNumber(nb);
    }
    List<Room> getRoomByState(boolean state){
        return roomRepository.getByState(state);
    }
}
