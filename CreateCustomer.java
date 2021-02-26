package CKPTDv2;



public class CreateCustomer {



    private int minService;
    private int maxService;
    private String serviceType;
    
    public CreateCustomer()
    {
        
    }

    public CreateCustomer(int minService, int maxService, int serviceTypeNum) {
        super();
        this.minService = minService;
        this.maxService = maxService;
        if (serviceTypeNum==1)
        	this.serviceType = "Full";
        else if(serviceTypeNum==2) {
        	this.serviceType= "Self";
        }
    }
    
    public int generateRandomNum(int min,int max)
    {
        int span = max-min+1;
        int rand = (int) (Math.random()*span);
        rand= rand+min;
        return rand;
    }
    
    public Customer makeCust(int arrival, double percentExtra)
    {
        Customer cust = null;
        int service = generateRandomNum(getMinService(),getMaxService());
        if (serviceType.equals("Self")) {
        	service = service+(int) ( service*percentExtra);
        }
        cust = new Customer(arrival,service, 0, serviceType);
        return cust;
    }

    

    public int getMinService() {
        return minService;
    }

    public void setMinService(int minService) {
        this.minService = minService;
    }

    public int getMaxService() {
        return maxService;
    }

    public void setMaxService(int maxService) {
        this.maxService = maxService;
    }


}

