package com.megacity.controller.customer;

import com.megacity.model.Vehicle;
import com.megacity.service.VehicleService;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

public class addVehicleServlet extends HttpServlet {
    private VehicleService vehicleService;
    
    public addVehicleServlet() {    
        vehicleService = new VehicleService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // You can implement GET method if necessary
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
       
        String model = request.getParameter("model");
        String vehicleName = request.getParameter("vehicleName");
        String vehicleNumber = request.getParameter("vehicleNumber");
        String vehicleOwner = request.getParameter("vehicleOwner");
        String vehicleOwnerContact = request.getParameter("vehicleOwnerContact");

        
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
        Vehicle vehicle = new Vehicle(model, vehicleName, vehicleNumber, vehicleOwner, vehicleOwnerContact, vehicleImageBytes);

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
