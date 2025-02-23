package com.megacity.controller.addmin;

import com.megacity.controller.LoginServlet;
import com.megacity.model.Driver;
import com.megacity.model.Vehicle;
import com.megacity.service.DriverService;
import com.megacity.service.Impl.DriverServiceImpl;
import com.megacity.service.VehicleService;
import com.megacity.service.Impl.VehicleServiceImpl;
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
import java.util.logging.Logger;
import java.util.stream.Collectors;
import org.slf4j.LoggerFactory;

public class addVehicleServlet extends HttpServlet {
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(addDriverServlet.class);

    private VehicleService vehicleService;
    private DriverService driverService;
    
    
    public addVehicleServlet() {    
        vehicleService = new VehicleServiceImpl();
        driverService=new DriverServiceImpl();
        
    }

    

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String vehicleType = request.getParameter("vehicleType");
        List<Vehicle> vehicleList = vehicleService.getAllVehicleList(vehicleType);
        List<Driver> driverList = driverService.getAllAvailableDrivers();
        
        for(Vehicle vehicle : vehicleList){
            LOGGER.info(vehicle.toString());
        }
        for(Driver driver : driverList){
            LOGGER.info(driver.toString());
        }
        
        
        for (Vehicle vehicle : vehicleList) {
            
            byte[] imageBytes = vehicle.getVehicleImage();
            if (imageBytes != null) {
                String base64Image = Base64.getEncoder().encodeToString(imageBytes);
                vehicle.setBase64Image(base64Image); 
                vehicle.setId((vehicle.getId()));
            }
        }
        String driverListString = driverList.stream()
                        .map(driver -> "ID: " + driver.getDriverId() + 
                            ", Name: " + driver.getDriverName() + 
                            ", Gender: " + driver.getDriverGender() +
                            ", License No: " + driver.getDriverLicenseNo() +
                            ", Phone: " + driver.getPhoneNumber())
                                 .collect(Collectors.joining("; "));


        
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
            LOGGER.info("Uploaded file is empty.");
            response.sendRedirect("addVehical.jsp?error=3");  
            return;
        } else {
            LOGGER.info("File part is not null. Size: " + filePart.getSize());
            if (filePart.getSize() == 0) {
                LOGGER.info("Uploaded file is empty.");
                response.sendRedirect("addVehical.jsp?error=3");  
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
             LOGGER.info("Image bytes are null.");
             response.sendRedirect("addVehical.jsp?success=1");
                        
        } else {
            LOGGER.info("Image bytes are not null.");
            response.sendRedirect("addVehical.jsp?error=2");
        }

    }

    @Override
    public String getServletInfo() {
        return "Handles adding a new vehicle with an image.";
    }
}
