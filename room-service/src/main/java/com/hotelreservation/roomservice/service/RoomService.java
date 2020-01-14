package com.hotelreservation.roomservice.service;

@Service
public class RoomService {
    @Autowired
    private RoomRepository roomRepository;

    public List<Room> getRoomByNbBed(int nb) {
        return roomRepository.findByNbBed(nb);
    }
}
