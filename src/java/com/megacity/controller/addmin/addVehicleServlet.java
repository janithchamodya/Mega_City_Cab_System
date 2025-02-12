package com.megacity.controller.addmin;

import com.megacity.model.Driver;
import com.megacity.model.Vehicle;
import com.megacity.service.DriverService;
import com.megacity.service.VehicleService;
import java.io.ByteArrayOutputStream;

import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;

import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.util.Base64;
import java.util.stream.Collectors;

public class addVehicleServlet extends HttpServlet {
    private VehicleService vehicleService;
    private DriverService driverService;
    
    public addVehicleServlet() {    
        vehicleService = new VehicleService();
        driverService=new DriverService();
    }

    

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String vehicleType = request.getParameter("vehicleType");
        List<Vehicle> vehicleList = vehicleService.getAllVehicleList(vehicleType);
        List<Driver> driverList = driverService.getAllAvailableDrivers();
        
        // Convert each vehicle's image to Base64 and set it
        for (Vehicle vehicle : vehicleList) {
            byte[] imageBytes = vehicle.getVehicleImage();
            if (imageBytes != null) {
                String base64Image = Base64.getEncoder().encodeToString(imageBytes);
                vehicle.setBase64Image(base64Image);    // Set Base64 image
            }
        }
    String driverListString = driverList.stream()
                                    .map(driver -> "ID: " + driver.getDriverId() + 
                                                   ", Name: " + driver.getDriverName() + 
                                                   ", Gender: " + driver.getDriverGender())
                                    .collect(Collectors.joining("; "));

        // Set attributes for vehicle and driver lists
        request.setAttribute("vehicleList", vehicleList);
        request.setAttribute("driverListString", driverListString); 
        request.getRequestDispatcher("showAvaliableVehicle.jsp").forward(request, response);
        
    }



    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
       
        String model = request.getParameter("model");
        String vehicleName = request.getParameter("vehicleName");
        String vehicleNumber = request.getParameter("vehicleNumber");
        String vehicleOwner = request.getParameter("vehicleOwner");
        String vehicleOwnerContact = request.getParameter("vehicleOwnerContact");
        String VehicleWithAC =request.getParameter("VehicleWithAC");
        String VehicleWithoutAC =request.getParameter("VehicleWithoutAC");

        
        Part filePart = request.getPart("vehicleImage");
        if (filePart == null) {
            System.out.println("Uploaded file is empty.");
            response.sendRedirect("addVehical.jsp?error=3");  // Handle empty file upload error
            return;
        } else {
            System.out.println("File part is not null. Size: " + filePart.getSize());
            if (filePart.getSize() == 0) {
                System.out.println("Uploaded file is empty.");
                response.sendRedirect("addVehical.jsp?error=3");  // Handle empty file upload error
                return;
            }
        }

        
       
        byte[] vehicleImageBytes = null;
        if (filePart != null) {
            try (InputStream fileContent = filePart.getInputStream();
                 ByteArrayOutputStream buffer = new ByteArrayOutputStream()) {

                byte[] temp = new byte[1024];
                int bytesRead;
                while ((bytesRead = fileContent.read(temp)) != -1) {
                    buffer.write(temp, 0, bytesRead);
                }
                vehicleImageBytes = buffer.toByteArray();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        Vehicle vehicle = new Vehicle(model, vehicleName, vehicleNumber, vehicleOwner, vehicleOwnerContact, VehicleWithAC,VehicleWithoutAC,vehicleImageBytes);

        if (vehicleService.addVehicleService(vehicle)) {
            System.out.println("Image bytes are null.");
             response.sendRedirect("addVehical.jsp?success=1");
            
        } else {
            System.out.println("Image bytes are not null.");
            response.sendRedirect("addVehical.jsp?error=2");
        }

    }

    @Override
    public String getServletInfo() {
        return "Handles adding a new vehicle with an image.";
    }
}
