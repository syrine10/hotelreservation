package com.reservationhotel.app.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.reservationhotel.app.utils.RoomType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "Room")
public class Room {

	
	public Room() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "type", nullable = false)
	private RoomType type;

	@Column(name = "room_number", nullable = false, unique = true)
	private int number;

	@Column(name = "price")
	private int price;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Room")
	@JsonBackReference
	private List<Reservation> reservations;
}
