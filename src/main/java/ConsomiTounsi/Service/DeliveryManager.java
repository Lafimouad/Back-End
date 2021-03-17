package ConsomiTounsi.Service;

import ConsomiTounsi.entities.Delivery;

import java.util.List;
import java.util.Optional;

public class DeliveryManager implements DeliveryManagerInterface{
    @Override
    public List<Delivery> retrieveAllDelivery() {
        return null;
    }

    @Override
    public Delivery addDelivery(Delivery De) {
        return null;
    }

    @Override
    public void deleteDelivery(Long id) {

    }

    @Override
    public void deleteDelivery(String id) {

    }

    @Override
    public Delivery updateDeliverer(Delivery De) {
        return null;
    }

    @Override
    public Optional<Delivery> FindDelivery(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<Delivery> FindDelivery(String id) {
        return Optional.empty();
    }
}
