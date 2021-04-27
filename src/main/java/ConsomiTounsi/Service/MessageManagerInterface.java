package ConsomiTounsi.Service;


import ConsomiTounsi.entities.Message;

import java.util.List;
import java.util.Optional;

public interface MessageManagerInterface {
    List<Message> retrieveAllMessage();
    Message addMessage(Message M);
    void deleteMessage(Long id);
    void deleteMessage(String id);
    Message updateMessage(Message M);
    Message FindMessage(Long id);
    Message FindMessage(String id);
}
