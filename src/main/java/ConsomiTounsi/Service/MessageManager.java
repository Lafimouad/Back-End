package ConsomiTounsi.Service;

import ConsomiTounsi.entities.Message;

import java.util.List;
import java.util.Optional;

public class MessageManager implements MessageManagerInterface{
    @Override
    public List<Message> retrieveAllMessage() {
        return null;
    }

    @Override
    public Message addMessage(Message M) {
        return null;
    }

    @Override
    public void deleteMessage(Long id) {

    }

    @Override
    public void deleteMessage(String id) {

    }

    @Override
    public Message updateMessage(Message M) {
        return null;
    }

    @Override
    public Optional<Message> FindMessage(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<Message> FindMessage(String id) {
        return Optional.empty();
    }
}
