package com.bookingproject.bookingproject.service;

import com.bookingproject.bookingproject.controller.CreateRoomRequest;
import com.bookingproject.bookingproject.controller.EditRoomRequest;
import com.bookingproject.bookingproject.exception.RoomNotFoundException;
import com.bookingproject.bookingproject.model.Room;
import com.bookingproject.bookingproject.model.RoomCategory;
import com.bookingproject.bookingproject.model.RoomStatus;
import com.bookingproject.bookingproject.repository.RoomRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class RoomManager implements InitializingBean {
    private RoomRepository roomRepository;

    public RoomManager(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }


    public void saveRoom1() {
        Room room = new Room();
        room.setRoomCategory(RoomCategory.DELUXE);
        room.setPrice(BigDecimal.valueOf(999));
        room.setBeds("awesowe");
        room.setRoomStatus(RoomStatus.CLEAN);
        roomRepository.save(room);
    }public void saveRoom2() {
        Room room = new Room();
        room.setRoomCategory(RoomCategory.DELUXE);
        room.setPrice(BigDecimal.valueOf(999));
        room.setBeds("tigers skin");
        room.setRoomStatus(RoomStatus.CLEAN);
        roomRepository.save(room);
    }public void saveRoom3() {
        Room room = new Room();
        room.setRoomCategory(RoomCategory.DELUXE);
        room.setPrice(BigDecimal.valueOf(899));
        room.setBeds("snakeskin");
        room.setRoomStatus(RoomStatus.CLEAN);
        roomRepository.save(room);
    }public void saveRoom4() {
        Room room = new Room();
        room.setRoomCategory(RoomCategory.EXECUTIVE);
        room.setPrice(BigDecimal.valueOf(9999));
        room.setBeds("damamged");
        room.setRoomStatus(RoomStatus.DAMAGED);
        roomRepository.save(room);
    }public void saveRoom5() {
        Room room = new Room();
        room.setRoomCategory(RoomCategory.STUDIO);
        room.setPrice(BigDecimal.valueOf(500));
        room.setBeds("double");
        room.setRoomStatus(RoomStatus.CLEAN);
        roomRepository.save(room);
    }public void saveRoom6() {
        Room room = new Room();
        room.setRoomCategory(RoomCategory.SUITE);
        room.setPrice(BigDecimal.valueOf(150));
        room.setBeds("king");
        room.setRoomStatus(RoomStatus.CLEAN);
        roomRepository.save(room);
    }public void saveRoom7() {
        Room room = new Room();
        room.setRoomCategory(RoomCategory.SUITE);
        room.setPrice(BigDecimal.valueOf(170));
        room.setBeds("king");
        room.setRoomStatus(RoomStatus.CLEAN);
        roomRepository.save(room);
    }public void saveRoom8() {
        Room room = new Room();
        room.setRoomCategory(RoomCategory.STUDIO);
        room.setPrice(BigDecimal.valueOf(100));
        room.setBeds("double");
        room.setRoomStatus(RoomStatus.DIRTY);
        roomRepository.save(room);
    }public void saveRoom9() {
        Room room = new Room();
        room.setRoomCategory(RoomCategory.SUITE);
        room.setPrice(BigDecimal.valueOf(200));
        room.setBeds("single");
        room.setRoomStatus(RoomStatus.CLEAN);
        roomRepository.save(room);
    }public void saveRoom10() {
        Room room = new Room();
        room.setRoomCategory(RoomCategory.SUITE);
        room.setPrice(BigDecimal.valueOf(80));
        room.setBeds("single");
        room.setRoomStatus(RoomStatus.DIRTY);
        roomRepository.save(room);
    }public void saveRoom11() {
        Room room = new Room();
        room.setRoomCategory(RoomCategory.SUITE);
        room.setPrice(BigDecimal.valueOf(80));
        room.setBeds("king");
        room.setRoomStatus(RoomStatus.CLEAN);
        roomRepository.save(room);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        saveRoom1();
        saveRoom2();
        saveRoom3();
        saveRoom4();
        saveRoom5();
        saveRoom6();
        saveRoom7();
        saveRoom8();
        saveRoom9();
        saveRoom10();
        saveRoom11();
    }

    public List<Room> getRooms() {
        return roomRepository.findAll();
    }

    public void editRoom(Long id, EditRoomRequest editRoomRequest) {
        Room editedRoom = roomRepository.getOne(id);
        editedRoom.setRoomStatus(editRoomRequest.getRoomStatus());
        roomRepository.save(editedRoom);
    }

    public Room findById(Long id){
        Room one = roomRepository.getOne(id);
        return one;
    }
}
