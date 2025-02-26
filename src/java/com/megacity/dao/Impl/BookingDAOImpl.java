/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.megacity.dao.Impl;

import com.megacity.controller.addmin.adminViewAllBookingsServlet;
import com.megacity.dao.BookingDAO;
import com.megacity.model.Bookings;
import com.megacity.util.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.LoggerFactory;

/**
 *
 * @author OZT00106
 */
public class BookingDAOImpl implements BookingDAO{
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(BookingDAOImpl.class);

 private Connection connection;

    public BookingDAOImpl() {
        connection = DBConnection.getInstance().getConnection();
    }
    @Override
    public boolean addBooking(Bookings booking) {
        String query = "INSERT INTO bookings (order_number, customer_id, vehicle_id, driver_id, customer_name, " +
                       "model, vehicle_name, vehicle_number, owner, driver_name, driver_gender, amount, " +
                       "start_date, end_date) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, booking.getOrderNumber());
            ps.setInt(2, booking.getCustomerId());
            ps.setInt(3, booking.getCarId());
            ps.setInt(4, booking.getDriverId());
            ps.setString(5, booking.getCustomerName());
            ps.setString(6, booking.getModel());
            ps.setString(7, booking.getVehicleName());
            ps.setString(8, booking.getVehicleNumber());
            ps.setString(9, booking.getOwner());
            ps.setString(10, booking.getDriverName());
            ps.setString(11, booking.getDriverGender());
            ps.setString(12, booking.getAmount());
            ps.setString(13, booking.getStartDate());
            ps.setString(14, booking.getEndDate());
            
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error while adding booking: " + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }   
    @Override
    public List<Bookings> getAvailableBooking() {
        List<Bookings> bookingList = new ArrayList<>();
        String query = "SELECT * FROM bookings WHERE availability='Available'";
        
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Bookings bookings = new Bookings();
                    bookings.setBookingId(rs.getInt("booking_id"));
                    bookings.setOrderNumber(rs.getString("order_number"));
                    bookings.setCustomerId(rs.getInt("customer_id"));
                    bookings.setCarId(rs.getInt("vehicle_id"));
                    bookings.setDriverId(rs.getInt("driver_id"));
                    bookings.setCustomerName(rs.getString("customer_name"));
                    bookings.setModel(rs.getString("model"));
                    bookings.setVehicleName(rs.getString("vehicle_name"));
                    bookings.setVehicleNumber(rs.getString("vehicle_number"));
                    bookings.setOwner(rs.getString("owner"));
                    bookings.setDriverName(rs.getString("driver_name"));
                    bookings.setDriverGender(rs.getString("driver_gender"));
                    bookings.setAmount(rs.getString("amount"));
                    bookings.setStartDate(rs.getString("start_date"));
                    bookings.setEndDate(rs.getString("end_date"));
                    


                    bookingList.add(bookings);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error while adding booking: " + e.getMessage());
            e.printStackTrace();
        }
        return bookingList;
    }   
    
    @Override
    public List<Bookings> getMyBookings(String customerId ,String customerName ) {
        List<Bookings> bookingList = new ArrayList<>();
        String query = "SELECT * FROM bookings WHERE availability='Unavailable' AND customer_id=? AND customer_name=?";
        
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, customerId);
            ps.setString(2, customerName);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Bookings bookings = new Bookings();
                    bookings.setBookingId(rs.getInt("booking_id"));
                    bookings.setOrderNumber(rs.getString("order_number"));
                    bookings.setCustomerId(rs.getInt("customer_id"));
                    bookings.setCarId(rs.getInt("vehicle_id"));
                    bookings.setDriverId(rs.getInt("driver_id"));
                    bookings.setCustomerName(rs.getString("customer_name"));
                    bookings.setModel(rs.getString("model"));
                    bookings.setVehicleName(rs.getString("vehicle_name"));
                    bookings.setVehicleNumber(rs.getString("vehicle_number"));
                    bookings.setOwner(rs.getString("owner"));
                    bookings.setDriverName(rs.getString("driver_name"));
                    bookings.setDriverGender(rs.getString("driver_gender"));
                    bookings.setAmount(rs.getString("amount"));
                    bookings.setStartDate(rs.getString("start_date"));
                    bookings.setEndDate(rs.getString("end_date"));
                    


                    bookingList.add(bookings);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error while adding booking: " + e.getMessage());
            e.printStackTrace();
        }
        return bookingList;
    }  

    /**
     *
     * @param customerId
     * @return
     */
    @Override
    public List<Bookings> getMyBookingsFromCustID(String customerId) {
        LOGGER.info("customerId " + customerId);
        List<Bookings> bookingList = new ArrayList<>();

        // Corrected SQL query
        String query = "SELECT \n" +
                        "    b.booking_id,\n" +
                        "    b.order_number,\n" +
                        "    b.customer_name,\n" +
                        "    b.customer_id,\n"+
                        "    b.vehicle_id,\n"+
                        "    b.driver_id,\n"+
                        "    b.model,\n" +
                        "    b.vehicle_name,\n" +
                        "    b.vehicle_number,\n" +
                        "    b.owner,\n" +
                        "    b.driver_name,\n" +
                        "    b.driver_gender,\n" +
                        "    b.amount,\n" +
                        "    b.start_date,\n" +
                        "    b.end_date\n" +
                        "FROM \n" +
                        "    bookings b\n" +
                        "JOIN \n" +
                        "    users u ON b.customer_id = u.id\n" +
                        "WHERE \n" +
                        "    u.customer_id = ?";  


        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, customerId); // Set the customerId in the query

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Bookings bookings = new Bookings();
                    bookings.setBookingId(rs.getInt("booking_id"));
                    bookings.setOrderNumber(rs.getString("order_number"));
                    bookings.setCustomerId(rs.getInt("customer_id"));
                    bookings.setCarId(rs.getInt("vehicle_id"));
                    bookings.setDriverId(rs.getInt("driver_id"));
                    bookings.setCustomerName(rs.getString("customer_name"));
                    bookings.setModel(rs.getString("model"));
                    bookings.setVehicleName(rs.getString("vehicle_name"));
                    bookings.setVehicleNumber(rs.getString("vehicle_number"));
                    bookings.setOwner(rs.getString("owner"));
                    bookings.setDriverName(rs.getString("driver_name"));
                    bookings.setDriverGender(rs.getString("driver_gender"));
                    bookings.setAmount(rs.getString("amount"));
                    bookings.setStartDate(rs.getString("start_date"));
                    bookings.setEndDate(rs.getString("end_date"));

                    bookingList.add(bookings);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error while adding booking: " + e.getMessage());
            e.printStackTrace();
        }
        return bookingList;
    }

    @Override
    public List<Bookings> getAllBookingsForAdminView( ) {
        List<Bookings> bookingList = new ArrayList<>();
        String query = "SELECT * FROM bookings WHERE availability='Unavailable'";
        
        try (PreparedStatement ps = connection.prepareStatement(query)) {
           
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Bookings bookings = new Bookings();
                    bookings.setBookingId(rs.getInt("booking_id"));
                    bookings.setOrderNumber(rs.getString("order_number"));
                    bookings.setCustomerId(rs.getInt("customer_id"));
                    bookings.setCarId(rs.getInt("vehicle_id"));
                    bookings.setDriverId(rs.getInt("driver_id"));
                    bookings.setCustomerName(rs.getString("customer_name"));
                    bookings.setModel(rs.getString("model"));
                    bookings.setVehicleName(rs.getString("vehicle_name"));
                    bookings.setVehicleNumber(rs.getString("vehicle_number"));
                    bookings.setOwner(rs.getString("owner"));
                    bookings.setDriverName(rs.getString("driver_name"));
                    bookings.setDriverGender(rs.getString("driver_gender"));
                    bookings.setAmount(rs.getString("amount"));
                    bookings.setStartDate(rs.getString("start_date"));
                    bookings.setEndDate(rs.getString("end_date"));
                    


                    bookingList.add(bookings);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error while adding booking: " + e.getMessage());
            e.printStackTrace();
        }
        return bookingList;
    } 
    @Override
    public boolean updateBookingAsUnavailable(String orderNumber) {
        String query = "UPDATE bookings SET availability='Unavailable' WHERE order_number=?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, orderNumber);

            int rowsUpdated = ps.executeUpdate();
            return rowsUpdated > 0;  // Return true if the update was successful

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;  // Return false if there was an error
    }

    @Override
    public String generateOrderNumber() {
        String query = "SELECT order_number FROM bookings ORDER BY booking_id DESC LIMIT 1";
        try (PreparedStatement ps = connection.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                String lastOrderNumber = rs.getString("order_number");
                System.out.println("Last Order Number: " + lastOrderNumber);

               
                String numericPart = lastOrderNumber.substring(4); 
                int lastOrderNum = Integer.parseInt(numericPart); 
                int nextOrderNum = lastOrderNum + 1;  

                
                String nextOrderNumber = String.format("ORD_%d", nextOrderNum); 
                System.out.println("Next Order Number: " + nextOrderNumber);
                return nextOrderNumber;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "ORD_001";  
    }

    
}
