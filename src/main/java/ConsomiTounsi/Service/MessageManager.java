package ConsomiTounsi.Service;

import ConsomiTounsi.entities.Message;
import ConsomiTounsi.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MessageManager implements MessageManagerInterface{
    @Autowired
    MessageRepository mr;

    @Override
    public List<Message> retrieveAllMessage() {
        return (List<Message>) mr.findAll();
    }

    @Override
    public Message addMessage(Message M) {
        return mr.save(M);
    }

    @Override
    public void deleteMessage(Long id) {
        mr.deleteById(id);
    }

    @Override
    public void deleteMessage(String id) {
        mr.deleteById(Long.parseLong(id));
    }

    @Override
    public Message updateMessage(Message M) {
        return mr.save(M);
    }

    @Override
    public Message FindMessage(Long id) {
        return mr.findById(id).orElse(new Message());
    }

    @Override
    public Message FindMessage(String id) {
        return mr.findById(Long.parseLong(id)).orElse(new Message());
    }
}
