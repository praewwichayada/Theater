package theater.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import theater.model.Ticket;
import theater.service.TicketService;


import java.util.UUID;

@Controller
public class BookingController {
    @Autowired
    TicketService ticketService;

    @RequestMapping("/booking/{showTimeID}/{seat}")
    public String getFourKPage(@PathVariable UUID showTimeID, @PathVariable String seat, Model model, @AuthenticationPrincipal OAuth2User principal) {
        Ticket ticket = new Ticket();
        ticket.setShowTimeID(showTimeID.toString());
        ticket.setSeat(seat);
        ticket.setEmail(principal.getAttribute("email"));

        ticketService.create(ticket);
        return "redirect:/";
    }
}
