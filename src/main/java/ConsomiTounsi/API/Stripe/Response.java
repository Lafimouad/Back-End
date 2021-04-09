package ConsomiTounsi.API.Stripe;

import org.springframework.web.bind.annotation.GetMapping;

public class Response {

    private boolean status;
    private String details;

    public Response() {
        super();
        this.status = true;
    }

    public Response(boolean status, String details) {
        super();
        this.status = status;
        this.details = details;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    @Override
    public String toString() {
        return "Response [status=" + status + ", details=" + details + "]";
    }

	@GetMapping("/")
	public String homepage() {
	    return "homepage";
	}





}