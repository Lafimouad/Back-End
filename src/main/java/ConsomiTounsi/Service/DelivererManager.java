package ConsomiTounsi.Service;

import java.util.List;
import java.util.Optional;

public class DelivererManager implements DelivererManagerInterface{
    @Override
    public List<ConsomiTounsi.entities.Deliverer> retrieveAllDeliverer() {
        return null;
    }

    @Override
    public ConsomiTounsi.entities.Deliverer addDeliverer(ConsomiTounsi.entities.Deliverer D) {
        return null;
    }

    @Override
    public void deleteDeliverer(Long id) {

    }

    @Override
    public void deleteDeliverer(String id) {

    }

    @Override
    public ConsomiTounsi.entities.Deliverer updateDeliverer(ConsomiTounsi.entities.Deliverer D) {
        return null;
    }

    @Override
    public Optional<ConsomiTounsi.entities.Deliverer> FindDeliverer(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<ConsomiTounsi.entities.Deliverer> FindDeliverer(String id) {
        return Optional.empty();
    }
}
