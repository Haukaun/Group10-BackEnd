package ntnu.group10.backend.group10.Service;

import ntnu.group10.backend.group10.Entity.Address;
import ntnu.group10.backend.group10.Repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;



    public Address findById(int id) {
        Optional<Address> author = addressRepository.findById(id);
        return author.orElse(null);
    }

    public boolean add(Address address) {
        boolean added = false;
        if (address != null) {
            Address exsistingAddress  = findById(address.getAddressId());
            if ( exsistingAddress == null) {
                addressRepository.save(address);
                added = true;
            }
        }
        return added;
    }

    /**
     * Remove an author from application state (database)
     *
     * @param authorId ID of the author to delete
     * @return ture when author deleted, false when author was not found in the database
     */
    public boolean remove(int authorId) {
        Optional<Address> address = addressRepository.findById(authorId);
        address.ifPresent(address1 -> addressRepository.delete(address1));
        return address.isPresent();
    }

}
