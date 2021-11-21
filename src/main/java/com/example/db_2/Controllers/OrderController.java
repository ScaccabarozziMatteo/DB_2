package com.example.db_2.Controllers;

import com.example.db_2.POJO.OptionalProduct;
import com.example.db_2.POJO.Order;
import com.example.db_2.Services.MessageException;
import com.example.db_2.Services.OrderService;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping(value = "/order")
public class OrderController {

    private OrderService OS;

    @Autowired
    public OrderController(OrderService orderService){
        this.OS = orderService;
    }


    @GetMapping(value = "/get/{user_id}")
    public List<Order> getAllforUser (@PathVariable int user_id, HttpServletResponse response) throws IOException {
        List<Order> orders = new ArrayList<>();
        try {
            orders = OS.getUserOrders(user_id);
        } catch (MessageException e) {
            //e.printStackTrace();
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Impossible to retrive orders for user" + user_id + ": " + e.getMessage());
        }
        return orders;
    }

    @PutMapping(value = "/simulatePayment/{order_id}")
    public int paymentSimulation(@PathVariable Integer order_id,HttpServletResponse response) throws IOException {
        Random rand = new Random();
        int AcceptedProbability = 50;

        return rand.nextInt(101)<=AcceptedProbability ? setPayed(order_id, response ): setRefused(order_id,response);
    }

    @PutMapping(value = "/payed/{order_id}")
    public int setPayed(@PathVariable Integer order_id,HttpServletResponse response) throws IOException {
        Integer i = null;
        try {
           i = OS.setStatusPayed(order_id);
        } catch (MessageException e) {
            //e.printStackTrace();
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "Impossible to complete payment" + order_id + ": " + e.getMessage());
        }
        return i;
    }

    @PutMapping(value = "/refuse/{order_id}")
    public int setRefused(@PathVariable Integer order_id,HttpServletResponse response) throws IOException {
        Integer i=null;
        try {
            i=OS.refusedPayment(order_id);
        } catch (MessageException e) {
            //e.printStackTrace();
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "Impossible to complete payment" + order_id + ": " + e.getMessage());
        }
        return i;
    }

    @PostMapping(value = "/create")
    public int createOrder(@RequestBody Order order, @RequestBody List<Integer> list, HttpServletResponse response) throws IOException {

        /*
        List<Integer> list = new ArrayList<>();
        for(OptionalProduct opp : order.getOptionalProducts()){
            list.add(opp.getId());
        }*/

       int orderID = 0;
        try {
            orderID=  OS.createOrder(order.getStart_subs(),order.getValidity(),order.getUser().getId(), order.getaPackage().getId(),list );
        } catch (MessageException e) {
            //e.printStackTrace();
            response.sendError(HttpServletResponse.SC_FORBIDDEN, "Order creation failed: " + e.getMessage());
        }

        return orderID;

    }

}
