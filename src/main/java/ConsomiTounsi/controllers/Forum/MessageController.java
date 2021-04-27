package ConsomiTounsi.controllers.Forum;

import ConsomiTounsi.Service.AdminManagerInterface;
import ConsomiTounsi.Service.ClientManagerInterface;
import ConsomiTounsi.Service.MessageManagerInterface;
import ConsomiTounsi.entities.Admin;
import ConsomiTounsi.entities.Client;
import ConsomiTounsi.entities.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/Forum/Message")
public class MessageController {

    @Autowired
    ClientManagerInterface clientS;

    @Autowired
    AdminManagerInterface adminS;

    @Autowired
    MessageManagerInterface messageS;

    @PostMapping("/add")
    public Message addMessage(int clientId , int adminId , Date dateMSG , String textMessage){
        Client c = clientS.FindClientById((long) clientId);
        Admin a = adminS.FindAdminById((long) adminId);
        Message message = new Message(textMessage,dateMSG,c,a);
        return message ;}

    @GetMapping("/retrieve-all")
    public List<Message> getListMessage(){
        return messageS.retrieveAllMessage(); }

    @GetMapping("/retrieve-id")
    public Message getMessageById(@RequestParam("id") long id){
        return messageS.FindMessage(id);
    }

    @DeleteMapping("remove-id")
    public void removeMessageByID(@RequestParam("id")long id){
        messageS.deleteMessage(id);
    }

    @PutMapping("/update")
    public Message updateMessage(@RequestBody Message a){
        return messageS.updateMessage(a);
    }
}
