package theater.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import theater.model.Ticket;
import theater.repository.TicketRepository;


import java.util.List;
import java.util.UUID;

@Service
public class TicketService {
    @Autowired
    private TicketRepository ticketRepository;

    public List<Ticket> getALl(){
        return ticketRepository.findAll();
    }

    public Ticket getTicket(UUID id){
        return ticketRepository.findById(id).get();
    }

    public Ticket create(Ticket ticket){
        ticketRepository.save(ticket);
        return ticket;
    }

    public Ticket delete(UUID id){
        Ticket record = ticketRepository.findById(id).get();
        ticketRepository.deleteById(id);
        return record;
    }
}
