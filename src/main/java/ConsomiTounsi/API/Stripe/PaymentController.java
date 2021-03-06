package ConsomiTounsi.API.Stripe;

import ConsomiTounsi.Service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.mail.MessagingException;

@Controller
public class PaymentController {
    @Value("${stripe.key.public}")
    private String API_PUBLIC_KEY;
    @Autowired
    PaymentService paymentService;

    private StripeService stripeService;

    public PaymentController(StripeService stripeService) {
        this.stripeService = stripeService;
    }

    @GetMapping("/stripe")
    public String homepage() {
        return "homepage";
    }

    @GetMapping("/charge")
    public String chargePage(Model model) {
        model.addAttribute("stripePublicKey", API_PUBLIC_KEY);
        return "charge";
    }

    @PostMapping("/create-charge")
    public @ResponseBody Response createCharge(String email, String token) throws MessagingException {

        if (token == null) {
            return new Response(false, "Stripe payment token is missing. please try again later.");
        }

        String chargeId = stripeService.createCharge(email, token, 71);// 9.99 usd
        System.out.println(email);
        paymentService.sendEmail(email , "amount");
        if (chargeId == null) {
            return new Response(false, "An error accurred while trying to charge.");
        }

        // You may want to store charge id along with order information

        return new Response(true, "Success your charge id is " + chargeId);
    }
}
