package ntnu.group10.backend.group10.Service;

import ntnu.group10.backend.group10.Entity.Customer;
import ntnu.group10.backend.group10.Entity.OrderItem;
import ntnu.group10.backend.group10.Repository.OrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderItemService{



    @Autowired
    private OrderItemRepository orderItemRepository;



    public OrderItem findById(Integer id) {
        return orderItemRepository.findById(id).orElse(null);
    }

    public boolean add(OrderItem orderItem) {
        boolean added = false;
        if (orderItem != null) {
            OrderItem exsistingCustomer = findById(orderItem.getOrderItemId());
            if ( exsistingCustomer == null) {
                orderItemRepository.save(orderItem);
                added = true;
            }
        }
        return added;
    }


    public boolean remove(int orderItemId) {
        Optional<OrderItem> orderItem = orderItemRepository.findById(orderItemId);
        orderItem.ifPresent(orderItem1 -> orderItemRepository.delete(orderItem1));
        return orderItem.isPresent();
    }
}
