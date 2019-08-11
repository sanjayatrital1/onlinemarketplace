package edu.mum.cs.onlinemarketplace.controller;

import edu.mum.cs.onlinemarketplace.domain.UserOrder;
import edu.mum.cs.onlinemarketplace.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/seller")
public class SellerManagerOrdersController {

    @Autowired
    OrderService orderService;

    @GetMapping("/orders")
    public String managerOrders(Model model, HttpSession session){
//        Long id = (Long) session.getAttribute("userid");
        Long id = 1L;
        model.addAttribute("orders", orderService.getOrdersBySellerId(id));
        return "manageOrders";
    }

    @PostMapping("/order/{id}/{status}")
    public String cancelOrder(@PathVariable("id") Long id, @PathVariable("status") String status, Model model){
        UserOrder userOrder = orderService.getOrderById(id);
        userOrder.setStatus(status);
        orderService.saveOrder(userOrder);
        return "redirect:/seller/orders";
    }


}
